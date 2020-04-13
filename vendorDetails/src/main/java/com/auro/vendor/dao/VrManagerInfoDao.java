package com.auro.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auro.vendor.model.VrManagerDetails;

@Repository
public interface VrManagerInfoDao extends JpaRepository<VrManagerDetails, Integer> {

}
