package com.auro.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auro.vendor.model.VrStateDetails;

@Repository
public interface VrStateHeadInfoDao extends JpaRepository<VrStateDetails, Integer> {

}
