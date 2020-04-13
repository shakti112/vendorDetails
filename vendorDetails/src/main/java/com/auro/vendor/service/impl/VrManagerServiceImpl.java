package com.auro.vendor.service.impl;

import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auro.vendor.custom.exception.BusinessException;
import com.auro.vendor.custom.exception.DuplicateUserException;
import com.auro.vendor.dao.AurozenWalletDao;
import com.auro.vendor.dao.UserLoginInfoDao;
import com.auro.vendor.dao.VrManagerInfoDao;
import com.auro.vendor.dto.VrManagerDto;
import com.auro.vendor.model.AurozenWallet;
import com.auro.vendor.model.UserLoginInfo;
import com.auro.vendor.model.VrManagerDetails;
import com.auro.vendor.vendorService.VrManagerService;

@Service
public class VrManagerServiceImpl implements VrManagerService {
	private static final Logger logger = LoggerFactory.getLogger(VrManagerServiceImpl.class);
	@Autowired
	private VrManagerInfoDao vrManagerInfoDao;
	@Autowired
	private UserLoginInfoDao userLoginInfoDao;
	@Autowired
	private AurozenWalletDao aurozenWalletDao;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Transactional
	@Override
	public VrManagerDto saveVrManagerDetails(VrManagerDto vrManagerInfo) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserLoginInfo userinfo = userLoginInfoDao.findByPhone(vrManagerInfo.getPhone());
		if (userinfo != null) {
			throw new DuplicateUserException("user already exists");
		}
		VrManagerDetails info = mapper.map(vrManagerInfo, VrManagerDetails.class);
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setPassword(bCryptPasswordEncoder.encode(vrManagerInfo.getPassword()));
		userLoginInfo.setCategory(vrManagerInfo.getCategory());
		userLoginInfo.setPhone(vrManagerInfo.getPhone());
		userLoginInfo = userLoginInfoDao.save(userLoginInfo);
		info.setVrManagerId(userLoginInfo.getLoginId());
		// info.setUserLoginInfo(userLoginInfo);
		if (Objects.nonNull(vrManagerInfo.getAurozenWalletId()) && vrManagerInfo.getAurozenWalletId() > 0) {
			AurozenWallet aurozenWallet = aurozenWalletDao.findByAurozenWalletId(vrManagerInfo.getAurozenWalletId());
			if (Objects.nonNull(aurozenWallet)) {
				info.setAurozenWallet(aurozenWallet);
			}
		}
		info = vrManagerInfoDao.save(info);
		logger.debug("successfully signup");
		return mapper.map(info, VrManagerDto.class);
	}

	@Override
	public VrManagerDto updateVrManagerDetails(VrManagerDto vrManagerInfo, int vrManagerId) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		mapper.createTypeMap(VrManagerInfoDao.class, VrManagerDetails.class).addMappings(mapp -> {
			mapp.skip(VrManagerDetails::setVrManagerId);
		});
		Optional<VrManagerDetails> vendorInfoFromDB = vrManagerInfoDao.findById(vrManagerId);
		VrManagerDetails vreInfoToUpdate = null;
		if (vendorInfoFromDB.isPresent()) {
			vreInfoToUpdate = vendorInfoFromDB.get();
		} else {
			throw new BusinessException("Vendor Details not found to update for ID: " + vrManagerId);
		}
		// UserLoginInfo userinfo = userLoginInfoDao.findById(vendorId);
		mapper.map(vrManagerInfo, vreInfoToUpdate);
		UserLoginInfo userLoginInfo = userLoginInfoDao.findByLoginId(vrManagerId);
		userLoginInfo.setPhone(vreInfoToUpdate.getPhone());
		userLoginInfoDao.save(userLoginInfo);
		vrManagerInfoDao.save(vreInfoToUpdate);
		logger.debug("successfully signup");
		return mapper.map(vreInfoToUpdate, VrManagerDto.class);
	}
}
