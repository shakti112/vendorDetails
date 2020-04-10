package com.auro.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auro.vendor.model.VrExcutiveDetails;

@Repository
public interface VrExcutiveInfoDao extends JpaRepository<VrExcutiveDetails, Integer> {

	// public VrExcutiveDetails findByVreId(int vreId);

}
