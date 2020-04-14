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
import com.auro.vendor.dao.VrStateHeadInfoDao;
import com.auro.vendor.dto.VrStateHeadDto;
import com.auro.vendor.model.AurozenWallet;
import com.auro.vendor.model.UserLoginInfo;
import com.auro.vendor.model.VrStateDetails;
import com.auro.vendor.vendorService.VrStateHeadService;

@Service
public class VrStateHeadServiceImpl implements VrStateHeadService {
	private static final Logger logger = LoggerFactory.getLogger(VrStateHeadServiceImpl.class);
	@Autowired
	private UserLoginInfoDao userLoginInfoDao;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AurozenWalletDao aurozenWalletDao;
	@Autowired
	private VrStateHeadInfoDao vrStateHeadInfoDao;

	@Transactional
	@Override
	public VrStateHeadDto saveVrStateHeadDetails(VrStateHeadDto vrStateHeadInfo) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserLoginInfo userinfo = userLoginInfoDao.findByPhone(vrStateHeadInfo.getPhone());
		if (userinfo != null) {
			throw new DuplicateUserException("user already exists");
		}
		VrStateDetails info = mapper.map(vrStateHeadInfo, VrStateDetails.class);
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setPassword(bCryptPasswordEncoder.encode(vrStateHeadInfo.getPhone()));
		userLoginInfo.setCategory(vrStateHeadInfo.getCotegary());
		userLoginInfo.setPhone(vrStateHeadInfo.getPhone());
		userLoginInfo = userLoginInfoDao.save(userLoginInfo);
		info.setVrStateId(userLoginInfo.getLoginId());
		if (Objects.nonNull(vrStateHeadInfo.getAurozenWalletId()) && vrStateHeadInfo.getAurozenWalletId() > 0) {
			AurozenWallet aurozenWallet = aurozenWalletDao.findByAurozenWalletId(vrStateHeadInfo.getAurozenWalletId());
			if (Objects.nonNull(aurozenWallet)) {
				info.setAurozenWallet(aurozenWallet);
			}
		}
		info = vrStateHeadInfoDao.save(info);
		logger.debug("successfully signup");
		return mapper.map(info, VrStateHeadDto.class);
	}

	@Override
	public VrStateHeadDto updateVrStateHeadDetails(VrStateHeadDto vrStateHeadInfo, int vrStateId) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		mapper.createTypeMap(VrStateHeadInfoDao.class, VrStateDetails.class).addMappings(mapp -> {
			mapp.skip(VrStateDetails::setVrStateId);
		});
		Optional<VrStateDetails> vendorInfoFromDB = vrStateHeadInfoDao.findById(vrStateId);
		VrStateDetails vreInfoToUpdate = null;
		if (vendorInfoFromDB.isPresent()) {
			vreInfoToUpdate = vendorInfoFromDB.get();
		} else {
			throw new BusinessException("Vendor Details not found to update for ID: " + vrStateId);
		}
		// UserLoginInfo userinfo = userLoginInfoDao.findById(vendorId);
		mapper.map(vrStateHeadInfo, vreInfoToUpdate);
		UserLoginInfo userLoginInfo = userLoginInfoDao.findByLoginId(vrStateId);
		userLoginInfo.setPhone(vreInfoToUpdate.getPhone());
		userLoginInfoDao.save(userLoginInfo);
		vrStateHeadInfoDao.save(vreInfoToUpdate);
		logger.debug("successfully signup");
		return mapper.map(vreInfoToUpdate, VrStateHeadDto.class);
	}

}
