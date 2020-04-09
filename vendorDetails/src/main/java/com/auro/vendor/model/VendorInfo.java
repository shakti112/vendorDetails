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
@Table(name = "vendor_info")
public class VendorInfo implements Serializable {
	@Id
	private int vendorId;
	@JoinColumn(name = "vendor_id")
	@OneToOne(fetch = FetchType.LAZY)
	private UserLoginInfo userLoginInfo;
	private String name;
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
	@Column(name = "number_of_gyms")
	private int numberOfGyms;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aurozen_wallet_id")
	private AurozenWallet aurozenWallet;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inr_wallet_id")
	private INRWallet inrWallet;

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

	public AurozenWallet getAurozenWallet() {
		return aurozenWallet;
	}

	public void setAurozenWallet(AurozenWallet aurozenWallet) {
		this.aurozenWallet = aurozenWallet;
	}

	public INRWallet getInrWallet() {
		return inrWallet;
	}

	public void setInrWallet(INRWallet inrWallet) {
		this.inrWallet = inrWallet;
	}

	public void setUserLoginInfo(UserLoginInfo userLoginInfo) {
		this.userLoginInfo = userLoginInfo;
	}

}
