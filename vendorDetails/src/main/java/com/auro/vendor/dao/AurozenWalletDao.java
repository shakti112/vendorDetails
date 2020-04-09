package com.auro.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auro.vendor.model.AurozenWallet;

@Repository
public interface AurozenWalletDao extends JpaRepository<AurozenWallet, Integer> {

	AurozenWallet findByAurozenWalletId(int aurozenWalletId);

}
