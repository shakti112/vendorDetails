package com.auro.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auro.vendor.model.AddGymDetails;
import com.auro.vendor.model.GymLoginInfo;

@Repository
public interface GymLoginInfoDao extends JpaRepository<AddGymDetails, Integer> {
	public GymLoginInfo findByGymId(int gymId);

}
