package com.auro.vre.vreService;

import com.auro.vre.dto.VrExcutiveDto;

public interface VrExcutiveService {

	public VrExcutiveDto saveVendorDetails(VrExcutiveDto vrExcutiveInfo);

	public VrExcutiveDto updateVendorDetails(VrExcutiveDto vrExcutiveInfo, int vendorId);

}
