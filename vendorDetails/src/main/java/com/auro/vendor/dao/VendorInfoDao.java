package com.auro.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auro.vendor.model.VendorInfo;

@Repository
public interface VendorInfoDao extends JpaRepository<VendorInfo, Integer> {

	VendorInfo findByVendorId(int vendorId);

}
