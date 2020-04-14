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
@Table(name = "Gym_Details")
public class AddGymDetails implements Serializable {
	@Id
	private int gymId;
	@JoinColumn(name = "gym_Id")
	@OneToOne(fetch = FetchType.LAZY)
	private UserLoginInfo userLoginInfo;
	@Column(name = "gym_name")
	private String gymName;
	@Column(name = "gym_Address")
	private String gymAddress;
	@Column(name = "gym_Country")
	private String gymCountry;
	@Column(name = "gym_city")
	private String gymCity;
	@Column(name = "gym_state")
	private String gymState;
	@Column(name = "gym_contact")
	private String gymContact;
	@Column(name = "gym_gst_no")
	private int gymGstNo;

	public int getGymId() {
		return gymId;
	}

	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	public String getGymAddress() {
		return gymAddress;
	}

	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}

	public String getGymCountry() {
		return gymCountry;
	}

	public void setGymCountry(String gymCountry) {
		this.gymCountry = gymCountry;
	}

	public String getGymCity() {
		return gymCity;
	}

	public void setGymCity(String gymCity) {
		this.gymCity = gymCity;
	}

	public String getGymState() {
		return gymState;
	}

	public void setGymState(String gymState) {
		this.gymState = gymState;
	}

	public String getGymContact() {
		return gymContact;
	}

	public void setGymContact(String gymContact) {
		this.gymContact = gymContact;
	}

	public int getGymGstNo() {
		return gymGstNo;
	}

	public void setGymGstNo(int gymGstNo) {
		this.gymGstNo = gymGstNo;
	}

}
