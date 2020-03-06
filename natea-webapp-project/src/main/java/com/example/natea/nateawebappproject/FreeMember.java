package com.example.natea.nateawebappproject;

public class FreeMember extends Member {

	public FreeMember(String firstName, String lastName, String memberID, String email, String phoneNumber,
			String address) {
		super(firstName, lastName, memberID, email, phoneNumber, address);
		this.setType("Free");
	}

}
