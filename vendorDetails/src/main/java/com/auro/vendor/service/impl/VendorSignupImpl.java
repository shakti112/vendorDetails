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

import com.auro.vendor.Utils.AmazonClient;
import com.auro.vendor.custom.exception.BusinessException;
import com.auro.vendor.custom.exception.DuplicateUserException;
import com.auro.vendor.dao.AurozenWalletDao;
import com.auro.vendor.dao.INRWalletDao;
import com.auro.vendor.dao.UserLoginInfoDao;
import com.auro.vendor.dao.VendorInfoDao;
import com.auro.vendor.dto.VendorInfoDto;
import com.auro.vendor.model.AurozenWallet;
import com.auro.vendor.model.INRWallet;
import com.auro.vendor.model.UserLoginInfo;
import com.auro.vendor.model.VendorInfo;
import com.auro.vendor.vendorService.VendorSignupService;

@Service
public class VendorSignupImpl implements VendorSignupService {
	private static final Logger logger = LoggerFactory.getLogger(VendorSignupImpl.class);
	@Autowired
	private VendorInfoDao vendorInfoDao;
	@Autowired
	private UserLoginInfoDao userLoginInfoDao;
	@Autowired
	private AurozenWalletDao aurozenWalletDao;
	@Autowired
	private INRWalletDao inrWalletDao;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AmazonClient amazonClient;
	// @Autowired
	// public VendorSignupImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
	// this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	// }

	@Transactional
	@Override
	public VendorInfoDto saveVendorDetails(VendorInfoDto vendorinfo) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserLoginInfo userinfo = userLoginInfoDao.findByEmail(vendorinfo.getEmail());
		if (userinfo != null) {
			throw new DuplicateUserException("user already exists");
		}
		VendorInfo info = mapper.map(vendorinfo, VendorInfo.class);
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setPassword(bCryptPasswordEncoder.encode(vendorinfo.getPassword()));
		userLoginInfo.setCategory(vendorinfo.getCategory());
		userLoginInfo.setPhone(vendorinfo.getPhone());
		userLoginInfo.setEmail(vendorinfo.getEmail());
		userLoginInfo = userLoginInfoDao.save(userLoginInfo);
		info.setVendorId(userLoginInfo.getLoginId());
		info.setVendorId(userLoginInfo.getLoginId());
		// info.setUserLoginInfo(userLoginInfo);
		if (Objects.nonNull(vendorinfo.getAurozenWalletId()) && vendorinfo.getAurozenWalletId() > 0) {
			AurozenWallet aurozenWallet = aurozenWalletDao.findByAurozenWalletId(vendorinfo.getAurozenWalletId());
			if (Objects.nonNull(aurozenWallet)) {
				info.setAurozenWallet(aurozenWallet);
			}
		}
		if (Objects.nonNull(vendorinfo.getiNRWalletId()) && vendorinfo.getiNRWalletId() > 0) {
			INRWallet inrWallet = inrWalletDao.findByInrWalletId(vendorinfo.getiNRWalletId());
			if (Objects.nonNull(inrWallet)) {
				info.setInrWallet(inrWallet);
			}
		}
		info = vendorInfoDao.save(info);
		logger.debug("successfully signup");
		return mapper.map(info, VendorInfoDto.class);
	}

	@Override
	public VendorInfoDto updateVendorDetails(VendorInfoDto vendorinfo, int vendorId) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		mapper.createTypeMap(VendorInfoDto.class, VendorInfo.class).addMappings(mapp -> {
			mapp.skip(VendorInfo::setVendorId);
		});
		Optional<VendorInfo> vendorInfoFromDB = vendorInfoDao.findById(vendorId);
		VendorInfo vendorInfoToUpdate = null;
		if (vendorInfoFromDB.isPresent()) {
			vendorInfoToUpdate = vendorInfoFromDB.get();
		} else {
			throw new BusinessException("Vendor Details not found to update for ID: " + vendorId);
		}
		// UserLoginInfo userinfo = userLoginInfoDao.findById(vendorId);
		mapper.map(vendorinfo, vendorInfoToUpdate);
		UserLoginInfo userLoginInfo = userLoginInfoDao.findByLoginId(vendorId);
		userLoginInfo.setPhone(vendorinfo.getPhone());
		userLoginInfo.setEmail(vendorinfo.getEmail());
		userLoginInfoDao.save(userLoginInfo);
		vendorInfoDao.save(vendorInfoToUpdate);
		logger.debug("successfully signup");
		return mapper.map(vendorInfoToUpdate, VendorInfoDto.class);
	}

}
