package com.auro.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auro.vendor.model.INRWallet;

@Repository
public interface INRWalletDao extends JpaRepository<INRWallet, Integer> {

	INRWallet findByInrWalletId(int getiNRWalletId);

}
