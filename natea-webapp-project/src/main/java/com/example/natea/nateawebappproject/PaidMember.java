package com.example.natea.nateawebappproject;

import java.util.Hashtable;

public class PaidMember extends Member implements Votable{
	private Hashtable <String, Boolean> positionVoted;
	public PaidMember(String firstName, String lastName, String memberID, String email, String phoneNumber,
			String address) {
		super(firstName, lastName, memberID, email, phoneNumber, address);
		this.setType("Paid");
		this.positionVoted = new Hashtable <String, Boolean>();
	}
	@Override
	public void vote(String position, String memberID) {
		this.positionVoted.put(position, true);
		
	}
	
	

}
