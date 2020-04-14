package com.auro.vendor.vendorService;

import com.auro.vendor.dto.VrStateHeadDto;

public interface VrStateHeadService {
	VrStateHeadDto saveVrStateHeadDetails(VrStateHeadDto vrStateHeadInfo);

	VrStateHeadDto updateVrStateHeadDetails(VrStateHeadDto vrStateHeadInfo, int vrStateId);

}
