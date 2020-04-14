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
@Table(name = "VR_Manager_Details")
public class VrManagerDetails implements Serializable {
	@Id
	private int vrManagerId;
	@JoinColumn(name = "vrm_Id")
	@OneToOne(fetch = FetchType.LAZY)
	private UserLoginInfo userLoginInfo;
	@Column(name = "vrm_name")
	private String vrManagerName;
	@Column(name = "phone")
	private String phone;
	@Column(name = "vrm_email")
	private String vrManagerEmail;
	@Column(name = "vrm_address")
	private String vrManagerAddress;
	@Column(name = "vrm_city")
	private String vrManagerCity;
	@Column(name = "vrm_state")
	private String vrManagerState;
	@Column(name = "vrm_country")
	private String vrManagerCountry;
	@Column(name = "vrm_aadhar")
	private String vrManagerAadhar;
	@Column(name = "vrm_pan")
	private String vrManagerPAN;
	@Column(name = "photo")
	private String Photo;
	@Column(name = "vrm_gender")
	private String Gender;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aurozen_wallet_id")
	private AurozenWallet aurozenWallet;

	public int getVrManagerId() {
		return vrManagerId;
	}

	public void setVrManagerId(int vrManagerId) {
		this.vrManagerId = vrManagerId;
	}

	public String getVrManagerName() {
		return vrManagerName;
	}

	public void setVrManagerName(String vrManagerName) {
		this.vrManagerName = vrManagerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVrManagerEmail() {
		return vrManagerEmail;
	}

	public void setVrManagerEmail(String vrManagerEmail) {
		this.vrManagerEmail = vrManagerEmail;
	}

	public String getVrManagerAddress() {
		return vrManagerAddress;
	}

	public void setVrManagerAddress(String vrManagerAddress) {
		this.vrManagerAddress = vrManagerAddress;
	}

	public String getVrManagerCity() {
		return vrManagerCity;
	}

	public void setVrManagerCity(String vrManagerCity) {
		this.vrManagerCity = vrManagerCity;
	}

	public String getVrManagerState() {
		return vrManagerState;
	}

	public void setVrManagerState(String vrManagerState) {
		this.vrManagerState = vrManagerState;
	}

	public String getVrManagerCountry() {
		return vrManagerCountry;
	}

	public void setVrManagerCountry(String vrManagerCountry) {
		this.vrManagerCountry = vrManagerCountry;
	}

	public String getVrManagerAadhar() {
		return vrManagerAadhar;
	}

	public void setVrManagerAadhar(String vrManagerAadhar) {
		this.vrManagerAadhar = vrManagerAadhar;
	}

	public String getVrManagerPAN() {
		return vrManagerPAN;
	}

	public void setVrManagerPAN(String vrManagerPAN) {
		this.vrManagerPAN = vrManagerPAN;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public AurozenWallet getAurozenWallet() {
		return aurozenWallet;
	}

	public void setAurozenWallet(AurozenWallet aurozenWallet) {
		this.aurozenWallet = aurozenWallet;
	}

}
