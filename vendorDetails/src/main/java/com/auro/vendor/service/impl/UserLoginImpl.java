package com.auro.vendor.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auro.vendor.Utils.PasswordUtils;
import com.auro.vendor.custom.exception.UnAuthorizedUserException;
import com.auro.vendor.dao.UserLoginInfoDao;
import com.auro.vendor.dto.UserLoginInfoDto;
import com.auro.vendor.model.UserLoginInfo;
import com.auro.vendor.vendorService.UserLoginService;

@Service
public class UserLoginImpl implements UserLoginService {
	private static final Logger logger = LoggerFactory.getLogger(UserLoginImpl.class);
	@Autowired
	private UserLoginInfoDao userLoginInfoDao;
	@Autowired
	PasswordEncoder bCryptPasswordEncoder;

	// @Autowired
	// public UserLoginImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
	// this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	// }

	public UserLoginInfoDto userLogin(UserLoginInfoDto logininfo) {
		UserLoginInfo userinfo = userLoginInfoDao.findByEmailAndPassword(logininfo.getEmail(),
				PasswordUtils.encrypt(logininfo.getPassword(), PasswordUtils.secretKey));
		logininfo.setCategory(userinfo.getCategory());
		if (userinfo == null) {
			throw new UnAuthorizedUserException("Invalid user or password");
		}
		/*
		 * String decriptedPassword = PasswordUtils.decrypt(userinfo.getPassword(),
		 * PasswordUtils.secretKey); if (StringUtils.equalsIgnoreCase(decriptedPassword,
		 * logininfo.getPassword())) {
		 * 
		 * }
		 */
		logger.debug("login successfully");
		return logininfo;
	}

	@Override
	public UserLoginInfoDto getUserByEmail(String email) {
		ModelMapper mapper = new ModelMapper();
		UserLoginInfo userinfo = userLoginInfoDao.findByEmail(email);
		if (userinfo == null) {
			throw new UsernameNotFoundException(email);
		}
		return mapper.map(userinfo, UserLoginInfoDto.class);
	}

	@Override
	public UserLoginInfo loadUserByEmailId(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// ModelMapper mapper = new ModelMapper();
		UserLoginInfo userinfo = userLoginInfoDao.findByEmail(username);
		if (userinfo == null) {
			throw new UsernameNotFoundException(username);
		}

		User user = new User(username, userinfo.getPassword(), true, true, true, true, new ArrayList<>());
		return user;
	}

}
