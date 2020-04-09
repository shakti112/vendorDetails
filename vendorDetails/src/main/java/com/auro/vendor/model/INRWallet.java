package com.auro.vendor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inr_wallet")
public class INRWallet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inr_wallet_id")
	private int inrWalletId;
	@Column(name = "inr_wallet_amount")
	private double inrWalletAmount;

	public int getInrWalletId() {
		return inrWalletId;
	}

	public void setInrWalletId(int inrWalletId) {
		this.inrWalletId = inrWalletId;
	}

	public double getInrWalletAmount() {
		return inrWalletAmount;
	}

	public void setInrWalletAmount(double inrWalletAmount) {
		this.inrWalletAmount = inrWalletAmount;
	}

}
