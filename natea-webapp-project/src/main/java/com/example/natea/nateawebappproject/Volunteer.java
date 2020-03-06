package com.example.natea.nateawebappproject;

public class Volunteer extends Member {

	public Volunteer(String firstName, String lastName, String memberID, String email, String phoneNumber,
			String address) {
		super(firstName, lastName, memberID, email, phoneNumber, address);
		this.setType("Volunteer");
	}

}
