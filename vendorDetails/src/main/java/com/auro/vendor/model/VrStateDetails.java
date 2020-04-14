package com.auro.vendor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vr_Statehead_Details")
public class VrStateDetails implements Serializable {
	@Id
	@Column(name = "VR_SH_Id")
	private int vrStateId;
	@JoinColumn(name = "VR_SH_Id")
	@OneToOne(fetch = FetchType.LAZY)
	private UserLoginInfo userLoginInfo;
	@Column(name = "VR_SH_NAME")
	private String vrStateName;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "VR_SH_EMAIL")
	private String vrStateEmail;
	@Column(name = "VR_SH_ADDRESS")
	private String vrStateAddress;
	@Column(name = "VR_SH_CITY")
	private String vrStateCity;
	@Column(name = "VR_SH_STATE")
	private String vrStateState;
	@Column(name = "VR_SH_COUNTRY")
	private String vrStateCountry;
	@Column(name = "VR_SH_AADHAR")
	private String vrStateAadhar;
	@Column(name = "VR_SH_PAN")
	private String vrStatePAN;
	@Column(name = "PHOTO")
	private String Photo;
	@Column(name = "VR_SH_GENDER")
	private String vrStateGender;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aurozen_wallet_id")
	private AurozenWallet aurozenWallet;

	public int getVrStateId() {
		return vrStateId;
	}

	public void setVrStateId(int vrStateId) {
		this.vrStateId = vrStateId;
	}

	public String getVrStateName() {
		return vrStateName;
	}

	public void setVrStateName(String vrStateName) {
		this.vrStateName = vrStateName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVrStateEmail() {
		return vrStateEmail;
	}

	public void setVrStateEmail(String vrStateEmail) {
		this.vrStateEmail = vrStateEmail;
	}

	public String getVrStateAddress() {
		return vrStateAddress;
	}

	public void setVrStateAddress(String vrStateAddress) {
		this.vrStateAddress = vrStateAddress;
	}

	public String getVrStateCity() {
		return vrStateCity;
	}

	public void setVrStateCity(String vrStateCity) {
		this.vrStateCity = vrStateCity;
	}

	public String getVrStateState() {
		return vrStateState;
	}

	public void setVrStateState(String vrStateState) {
		this.vrStateState = vrStateState;
	}

	public String getVrStateCountry() {
		return vrStateCountry;
	}

	public void setVrStateCountry(String vrStateCountry) {
		this.vrStateCountry = vrStateCountry;
	}

	public String getVrStateAadhar() {
		return vrStateAadhar;
	}

	public void setVrStateAadhar(String vrStateAadhar) {
		this.vrStateAadhar = vrStateAadhar;
	}

	public String getVrStatePAN() {
		return vrStatePAN;
	}

	public void setVrStatePAN(String vrStatePAN) {
		this.vrStatePAN = vrStatePAN;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getVrStateGender() {
		return vrStateGender;
	}

	public void setVrStateGender(String vrStateGender) {
		this.vrStateGender = vrStateGender;
	}

	public AurozenWallet getAurozenWallet() {
		return aurozenWallet;
	}

	public void setAurozenWallet(AurozenWallet aurozenWallet) {
		this.aurozenWallet = aurozenWallet;
	}

}
