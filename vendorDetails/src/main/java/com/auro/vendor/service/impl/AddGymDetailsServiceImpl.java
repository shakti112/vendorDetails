package com.auro.vendor.service.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auro.vendor.dao.GymLoginInfoDao;
import com.auro.vendor.dao.UserLoginInfoDao;
import com.auro.vendor.dto.AddGymDetailsDto;
import com.auro.vendor.model.AddGymDetails;
import com.auro.vendor.model.UserLoginInfo;
import com.auro.vendor.vendorService.AddGymDetailsService;

@Service
public class AddGymDetailsServiceImpl implements AddGymDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(AddGymDetailsServiceImpl.class);
	/*
	 * @Autowired private GymLoginInfo gymLoginInfo;
	 */
	@Autowired
	private GymLoginInfoDao gymLoginInfoDao;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserLoginInfoDao userLoginInfoDao;

	@Transactional
	@Override
	public AddGymDetailsDto addGymDetails(AddGymDetailsDto gymDetails) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		/*
		 * GymLoginInfo gyminfo = gymLoginInfoDao.findByGymId(gymDetails.getGymId()); if
		 * (gyminfo != null) { throw new DuplicateUserException("user already exists");
		 * }
		 */
		AddGymDetails info = mapper.map(gymDetails, AddGymDetails.class);
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setPassword(bCryptPasswordEncoder.encode(gymDetails.getGymContact()));
		userLoginInfo = userLoginInfoDao.save(userLoginInfo);
		info.setGymId(userLoginInfo.getLoginId());
		info = gymLoginInfoDao.save(info);
		logger.debug("successfully signup");
		return mapper.map(info, AddGymDetailsDto.class);
	}

}
