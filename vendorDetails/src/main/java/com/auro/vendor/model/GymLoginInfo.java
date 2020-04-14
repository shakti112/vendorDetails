package com.auro.vendor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Gym_Login_info")
public class GymLoginInfo implements Serializable {
	@Id
	/*
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "gym_id")
	 */
	private int gymId;
	private String password;

	public int getGymId() {
		return gymId;
	}

	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
