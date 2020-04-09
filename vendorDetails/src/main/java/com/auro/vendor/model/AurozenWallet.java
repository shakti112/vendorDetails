package com.auro.vendor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aurozen_wallet")
public class AurozenWallet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "aurozen_wallet_id")
	private int aurozenWalletId;
	@Column(name = "aurozen_wallet_amount")
	private double aurozenWalletAmount;

	public int getAurozenWalletId() {
		return aurozenWalletId;
	}

	public void setAurozenWalletId(int aurozenWalletId) {
		this.aurozenWalletId = aurozenWalletId;
	}

	public double getAurozenWalletAmount() {
		return aurozenWalletAmount;
	}

	public void setAurozenWalletAmount(double aurozenWalletAmount) {
		this.aurozenWalletAmount = aurozenWalletAmount;
	}

}
