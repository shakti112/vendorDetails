package com.auro.vendor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auro.vendor.dto.AddGymDetailsDto;
import com.auro.vendor.vendorService.AddGymDetailsService;

@RestController
public class AddGymDetailsController {
	@Autowired
	private AddGymDetailsService addGymDetailsService;
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	@PostMapping(path = "/addgymDetails")
	public ResponseEntity<AddGymDetailsDto> addGymDetails(@RequestBody AddGymDetailsDto gymDetails) {
		gymDetails = addGymDetailsService.addGymDetails(gymDetails);
		logger.debug("successfully added gym::");
		return new ResponseEntity<AddGymDetailsDto>(gymDetails, HttpStatus.CREATED);
	}
}
