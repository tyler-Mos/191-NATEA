package com.example.natea.nateawebappproject;

import java.util.Hashtable;

public class LifetimeMember extends Member implements Votable{
	private Hashtable <String, Boolean> positionVoted;
	public LifetimeMember(String firstName, String lastName, String memberID, String email, String phoneNumber,
			String address) {
		super(firstName, lastName, memberID, email, phoneNumber, address);
		positionVoted = new Hashtable <String, Boolean>();
		this.setType("Lifetime");
	}

	@Override
	public void vote(String position, String memberID) {
		positionVoted.put(position, true);
		
	}

}
