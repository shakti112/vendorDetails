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
@Table(name = "vre_details")
public class VrExcutiveDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int vreId;
	@JoinColumn(name = "vre_id")
	@OneToOne(fetch = FetchType.LAZY)
	private UserLoginInfo userLoginInfo;
	@Column(name = "vre_Name")
	private String vreName;
	@Column(name = "Phone")
	private String vreContact;
	@Column(name = "vre_Email")
	private String vreEmail;
	@Column(name = "vre_Address")
	private String vreAddress;
	@Column(name = "vre_City")
	private String vreCity;
	@Column(name = "vre_State")
	private String vreState;
	@Column(name = "vre_Country")
	private String vreCountry;
	@Column(name = "vre_Aadhar")
	private String vreAadhar;
	private String category;
	@Column(name = "vre_Pan")
	private String vrePAN;
	private String Photo;
	@Column(name = "vre_Gender")
	private String vreGender;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aurozen_wallet_id")
	private AurozenWallet aurozenWallet;

	public int getVreId() {
		return vreId;
	}

	public void setVreId(int vreId) {
		this.vreId = vreId;
	}

	public UserLoginInfo getUserLoginInfo() {
		return userLoginInfo;
	}

	public void setUserLoginInfo(UserLoginInfo userLoginInfo) {
		this.userLoginInfo = userLoginInfo;
	}

	public String getVreName() {
		return vreName;
	}

	public void setVreName(String vreName) {
		this.vreName = vreName;
	}

	public String getVreContact() {
		return vreContact;
	}

	public void setVreContact(String vreContact) {
		this.vreContact = vreContact;
	}

	public String getVreEmail() {
		return vreEmail;
	}

	public void setVreEmail(String vreEmail) {
		this.vreEmail = vreEmail;
	}

	public String getVreAddress() {
		return vreAddress;
	}

	public void setVreAddress(String vreAddress) {
		this.vreAddress = vreAddress;
	}

	public String getVreCity() {
		return vreCity;
	}

	public void setVreCity(String vreCity) {
		this.vreCity = vreCity;
	}

	public String getVreState() {
		return vreState;
	}

	public void setVreState(String vreState) {
		this.vreState = vreState;
	}

	public String getVreCountry() {
		return vreCountry;
	}

	public void setVreCountry(String vreCountry) {
		this.vreCountry = vreCountry;
	}

	public String getVreAadhar() {
		return vreAadhar;
	}

	public void setVreAadhar(String vreAadhar) {
		this.vreAadhar = vreAadhar;
	}

	public String getVrePAN() {
		return vrePAN;
	}

	public void setVrePAN(String vrePAN) {
		this.vrePAN = vrePAN;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getVreGender() {
		return vreGender;
	}

	public void setVreGender(String vreGender) {
		this.vreGender = vreGender;
	}

	public AurozenWallet getAurozenWallet() {
		return aurozenWallet;
	}

	public void setAurozenWallet(AurozenWallet aurozenWallet) {
		this.aurozenWallet = aurozenWallet;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
