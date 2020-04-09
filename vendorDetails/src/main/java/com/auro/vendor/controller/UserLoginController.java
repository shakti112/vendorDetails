package com.auro.vendor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auro.vendor.dto.UserLoginInfoDto;
import com.auro.vendor.vendorService.UserLoginService;

@RestController
public class UserLoginController {
	@Autowired
	private UserLoginService userLoginService;
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	@PostMapping(path = "/userlogin")
	public ResponseEntity<UserLoginInfoDto> userLogin(@RequestBody UserLoginInfoDto logininfo) {
		logininfo = userLoginService.userLogin(logininfo);
		logger.debug("user Login successfully::");
		return new ResponseEntity<UserLoginInfoDto>(logininfo, HttpStatus.CREATED);
	}

}
