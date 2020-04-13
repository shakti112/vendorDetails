package com.auro.vendor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auro.vendor.dto.VrManagerDto;
import com.auro.vendor.vendorService.VrManagerService;

@RestController
public class VrManagerController {
	private static final Logger logger = LoggerFactory.getLogger(VendorRegistrationController.class);
	@Autowired
	private VrManagerService vrManagerService;

	@PostMapping(path = "/VrManagerSignup")
	public ResponseEntity<VrManagerDto> vrManagerSignup(@RequestBody VrManagerDto vrManagerInfo) {
		vrManagerInfo = vrManagerService.saveVrManagerDetails(vrManagerInfo);
		logger.debug("successfully signup");
		return new ResponseEntity<VrManagerDto>(vrManagerInfo, HttpStatus.CREATED);
	}

	@PutMapping(path = "/updateVreManagerDetails/{vrManagerId}")
	public ResponseEntity<VrManagerDto> updateVeExcutiveDetails(@RequestBody VrManagerDto vrManagerInfo,
			@PathVariable("vrManagerId") int vrManagerId) {
		VrManagerDto update = vrManagerService.updateVrManagerDetails(vrManagerInfo, vrManagerId);
		logger.debug("successfully updated");
		return new ResponseEntity<VrManagerDto>(update, HttpStatus.CREATED);
	}
}
