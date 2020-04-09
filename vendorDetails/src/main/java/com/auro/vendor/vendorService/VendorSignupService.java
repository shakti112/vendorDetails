package com.auro.vendor.vendorService;

import com.auro.vendor.dto.VendorInfoDto;

public interface VendorSignupService {

	public VendorInfoDto saveVendorDetails(VendorInfoDto vendorinfo);

	public VendorInfoDto updateVendorDetails(VendorInfoDto vendorinfo, int vendorId);

}
