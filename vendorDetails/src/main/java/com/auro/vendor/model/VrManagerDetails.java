package com.auro.vendor.model;

import java.io.Serializable;

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
	/*
	 * @JoinColumn(name = "vr_Manager_Id")
	 * 
	 * @OneToOne(fetch = FetchType.LAZY)
	 */
	private String vrManagerName;
	private String phone;
	private String vrManagerEmail;
	private String vrManagerAddress;
	private String vrManagerCity;
	private String vrManagerState;
	private String vrManagerCountry;
	private String vrManagerAadhar;
	private String vrManagerPAN;
	private String Photo;
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
