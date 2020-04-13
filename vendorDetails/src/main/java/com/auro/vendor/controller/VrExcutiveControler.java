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

import com.auro.vendor.dto.VrExcutiveDto;
import com.auro.vendor.vendorService.VrExcutiveService;

@RestController
public class VrExcutiveControler {
	private static final Logger logger = LoggerFactory.getLogger(VrExcutiveControler.class);
	@Autowired
	private VrExcutiveService vrExcutiveService;

	@PostMapping(path = "/VrExcutiveSignup")
	public ResponseEntity<VrExcutiveDto> vrExcutiveSignup(@RequestBody VrExcutiveDto vrExcutiveInfo) {
		vrExcutiveInfo = vrExcutiveService.saveVendorDetails(vrExcutiveInfo);
		logger.debug("successfully signup");
		return new ResponseEntity<VrExcutiveDto>(vrExcutiveInfo, HttpStatus.CREATED);
	}

	@PutMapping(path = "/updateVreExcutiveDetails/{vreId}")
	public ResponseEntity<VrExcutiveDto> updateVeExcutiveDetails(@RequestBody VrExcutiveDto vrExcutiveInfo,
			@PathVariable("vreId") int vreId) {
		VrExcutiveDto update = vrExcutiveService.updateVendorDetails(vrExcutiveInfo, vreId);
		logger.debug("successfully updated");
		return new ResponseEntity<VrExcutiveDto>(update, HttpStatus.CREATED);
	}
}
