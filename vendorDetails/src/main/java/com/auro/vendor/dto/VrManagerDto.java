package com.auro.vendor.dto;

public class VrManagerDto {
	private int vrManagerId;
	private String vrManagerName;
	private String phone;
	private String password;
	private String category;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	private String vrManagerEmail;
	private String vrManagerAddress;
	private String vrManagerCity;
	private String vrManagerState;
	private String vrManagerCountry;
	private String vrManagerAadhar;
	private String vrManagerPAN;
	private String Photo;
	private String Gender;
	private int aurozenWalletId;

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

	public int getAurozenWalletId() {
		return aurozenWalletId;
	}

	public void setAurozenWalletId(int aurozenWalletId) {
		this.aurozenWalletId = aurozenWalletId;
	}

}
