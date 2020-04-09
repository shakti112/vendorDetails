package com.auro.vendor.vendorService;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.auro.vendor.dto.UserLoginInfoDto;
import com.auro.vendor.model.UserLoginInfo;

public interface UserLoginService extends UserDetailsService {
	public UserLoginInfoDto userLogin(UserLoginInfoDto logininfo);

	public UserLoginInfo loadUserByEmailId(String username);

	public UserLoginInfoDto getUserByEmail(String email);

}
