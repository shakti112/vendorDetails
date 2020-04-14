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

import com.auro.vendor.dto.VrStateHeadDto;
import com.auro.vendor.vendorService.VrStateHeadService;

@RestController
public class VrStateHeadController {
	private static final Logger logger = LoggerFactory.getLogger(VendorRegistrationController.class);
	@Autowired
	private VrStateHeadService vrStateHeadService;

	@PostMapping(path = "/VrStateHeadSignup")
	public ResponseEntity<VrStateHeadDto> vrManagerSignup(@RequestBody VrStateHeadDto vrStateHeadInfo) {
		vrStateHeadInfo = vrStateHeadService.saveVrStateHeadDetails(vrStateHeadInfo);
		logger.debug("successfully signup");
		return new ResponseEntity<VrStateHeadDto>(vrStateHeadInfo, HttpStatus.CREATED);
	}

	@PutMapping(path = "/updateVrStateHeadDetails/{vrStateId}")
	public ResponseEntity<VrStateHeadDto> updateVrStateHeadDetails(@RequestBody VrStateHeadDto vrStateHeadInfo,
			@PathVariable("vrStateId") int vrStateId) {
		VrStateHeadDto update = vrStateHeadService.updateVrStateHeadDetails(vrStateHeadInfo, vrStateId);
		logger.debug("successfully updated");
		return new ResponseEntity<VrStateHeadDto>(update, HttpStatus.CREATED);
	}
}
