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
import com.auro.vendor.dao.VrExcutiveInfoDao;
import com.auro.vendor.dto.VrExcutiveDto;
import com.auro.vendor.model.AurozenWallet;
import com.auro.vendor.model.UserLoginInfo;
import com.auro.vendor.model.VrExcutiveDetails;
import com.auro.vendor.vendorService.VrExcutiveService;

@Service
public class VrExcutiveServiceImpl implements VrExcutiveService {
	private static final Logger logger = LoggerFactory.getLogger(VrExcutiveServiceImpl.class);
	@Autowired
	private VrExcutiveInfoDao vrExcutiveInfoDao;
	@Autowired
	private UserLoginInfoDao userLoginInfoDao;
	@Autowired
	private AurozenWalletDao aurozenWalletDao;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	// @Autowired
	// public VendorSignupImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
	// this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	// }

	@Transactional
	@Override
	public VrExcutiveDto saveVendorDetails(VrExcutiveDto vrExcutiveInfo) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserLoginInfo userinfo = userLoginInfoDao.findByPhone(vrExcutiveInfo.getPhone());
		if (userinfo != null) {
			throw new DuplicateUserException("user already exists");
		}
		VrExcutiveDetails info = mapper.map(vrExcutiveInfo, VrExcutiveDetails.class);
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setPassword(bCryptPasswordEncoder.encode(vrExcutiveInfo.getPassword()));
		userLoginInfo.setCategory(vrExcutiveInfo.getCategory());
		userLoginInfo.setPhone(vrExcutiveInfo.getPhone());
		userLoginInfo = userLoginInfoDao.save(userLoginInfo);
		info.setVreId(userLoginInfo.getLoginId());
		// info.setUserLoginInfo(userLoginInfo);
		if (Objects.nonNull(vrExcutiveInfo.getAurozenWalletId()) && vrExcutiveInfo.getAurozenWalletId() > 0) {
			AurozenWallet aurozenWallet = aurozenWalletDao.findByAurozenWalletId(vrExcutiveInfo.getAurozenWalletId());
			if (Objects.nonNull(aurozenWallet)) {
				info.setAurozenWallet(aurozenWallet);
			}
		}
		info = vrExcutiveInfoDao.save(info);
		logger.debug("successfully signup");
		return mapper.map(info, VrExcutiveDto.class);
	}

	@Override
	public VrExcutiveDto updateVendorDetails(VrExcutiveDto vrExcutiveInfo, int vreId) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		mapper.createTypeMap(VrExcutiveInfoDao.class, VrExcutiveDetails.class).addMappings(mapp -> {
			mapp.skip(VrExcutiveDetails::setVreId);
		});
		Optional<VrExcutiveDetails> vendorInfoFromDB = vrExcutiveInfoDao.findById(vreId);
		VrExcutiveDetails vreInfoToUpdate = null;
		if (vendorInfoFromDB.isPresent()) {
			vreInfoToUpdate = vendorInfoFromDB.get();
		} else {
			throw new BusinessException("Vendor Details not found to update for ID: " + vreId);
		}
		// UserLoginInfo userinfo = userLoginInfoDao.findById(vendorId);
		mapper.map(vrExcutiveInfo, vreInfoToUpdate);
		UserLoginInfo userLoginInfo = userLoginInfoDao.findByLoginId(vreId);
		userLoginInfo.setPhone(vreInfoToUpdate.getVreContact());
		userLoginInfoDao.save(userLoginInfo);
		vrExcutiveInfoDao.save(vreInfoToUpdate);
		logger.debug("successfully signup");
		return mapper.map(vreInfoToUpdate, VrExcutiveDto.class);
	}

}
