package com.auro.vendor.vendorService;

import com.auro.vendor.dto.VrExcutiveDto;

public interface VrExcutiveService {

	public VrExcutiveDto saveVendorDetails(VrExcutiveDto vrExcutiveInfo);

	public VrExcutiveDto updateVendorDetails(VrExcutiveDto vrExcutiveInfo, int vendorId);

}
