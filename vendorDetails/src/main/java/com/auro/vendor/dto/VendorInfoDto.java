package com.auro.vendor.dto;

import lombok.Data;

@Data
public class VendorInfoDto {
	private int vendorId;
	private String name;
	private String password;
	private String category;
	private String phone;
	private String email;
	private String address;
	private String gender;
	private String city;
	private String state;
	private String country;
	private String photo;
	private String aadhar;
	private String pAN;
	private int numberOfGyms;
	private int aurozenWalletId;
	private int iNRWalletId;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getpAN() {
		return pAN;
	}

	public void setpAN(String pAN) {
		this.pAN = pAN;
	}

	public int getNumberOfGyms() {
		return numberOfGyms;
	}

	public void setNumberOfGyms(int numberOfGyms) {
		this.numberOfGyms = numberOfGyms;
	}

	public int getAurozenWalletId() {
		return aurozenWalletId;
	}

	public void setAurozenWalletId(int aurozenWalletId) {
		this.aurozenWalletId = aurozenWalletId;
	}

	public int getiNRWalletId() {
		return iNRWalletId;
	}

	public void setiNRWalletId(int iNRWalletId) {
		this.iNRWalletId = iNRWalletId;
	}

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

}
