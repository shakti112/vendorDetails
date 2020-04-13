package com.auro.vendor.vendorService;

import com.auro.vendor.dto.VrManagerDto;

public interface VrManagerService {

	VrManagerDto saveVrManagerDetails(VrManagerDto vrManagerInfo);

	VrManagerDto updateVrManagerDetails(VrManagerDto vrManagerInfo, int vrManagerId);

}
