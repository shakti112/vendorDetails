package com.auro.vendor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.auro.vendor.Utils.AmazonClient;
import com.auro.vendor.dto.VendorInfoDto;
import com.auro.vendor.vendorService.VendorSignupService;

@RestController
public class VendorRegistrationController {
	private static final Logger logger = LoggerFactory.getLogger(VendorRegistrationController.class);

	@Autowired
	private VendorSignupService vendorSignupService;
	@Autowired
	private AmazonClient amazonClient;

	@PostMapping(path = "/vendorSignup")
	public ResponseEntity<VendorInfoDto> vendorSignup(@RequestBody VendorInfoDto vendorinfo) {
		vendorinfo = vendorSignupService.saveVendorDetails(vendorinfo);
		logger.debug("successfully signup");
		return new ResponseEntity<VendorInfoDto>(vendorinfo, HttpStatus.CREATED);
	}

	@PutMapping(path = "/updateVendorDetails/{vendorId}")
	public ResponseEntity<VendorInfoDto> updateVendorDetails(@RequestBody VendorInfoDto vendorinfo,
			@PathVariable("vendorId") int vendorId) {
		VendorInfoDto update = vendorSignupService.updateVendorDetails(vendorinfo, vendorId);
		logger.debug("successfully updated");
		return new ResponseEntity<VendorInfoDto>(update, HttpStatus.CREATED);
	}

	@PostMapping("/uploadFile/vendor/{vendorId}")
	public String uploadFile(@PathVariable("vendorId") int vendorId, @RequestPart(value = "file") MultipartFile file) {
		return amazonClient.uploadFile(vendorId, file);
	}

	@DeleteMapping("/deleteFile")
	public String deleteFile(@RequestPart(value = "url") String fileUrl) {
		return amazonClient.deleteFileFromS3Bucket(fileUrl);
	}

}
