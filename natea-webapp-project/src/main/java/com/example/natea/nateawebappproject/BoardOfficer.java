package com.example.natea.nateawebappproject;

import java.util.Hashtable;

public class BoardOfficer extends Member implements Votable{
	private Hashtable <String, Boolean> positionVoted;
	public BoardOfficer(String firstName, String lastName, String memberID, String email, String phoneNumber,
			String address) {
		super(firstName, lastName, memberID, email, phoneNumber, address);
		this.setType("BoardOfficer");
	}
	@Override
	public void vote(String position, String memberID) {
		positionVoted.put(position, true);
	}
}
