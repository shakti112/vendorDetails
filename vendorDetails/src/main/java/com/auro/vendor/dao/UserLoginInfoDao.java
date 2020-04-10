package com.auro.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auro.vendor.model.UserLoginInfo;

@Repository
public interface UserLoginInfoDao extends JpaRepository<UserLoginInfo, Integer> {

	public UserLoginInfo findByPhoneAndPassword(String email, String encrypt);

	public UserLoginInfo findByLoginId(int vendorId);

	public UserLoginInfo findByPhone(String phone);

}
