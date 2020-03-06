package com.example.natea.nateawebappproject;

import java.util.ArrayList;

public class Member {
	private String firstName, lastName, memberID, email, phoneNumber, address, type, 
		facebook, linkedin, workingPlace;
	private ArrayList<String> eventsAttended;
	public Member(String firstName, String lastName, String memberID, String email, 
			String phoneNumber, String address) {
		this.setFirstName(firstName);
		this.lastName = lastName;
		this.memberID = memberID;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.type = "";
		this.facebook = "";
		this.linkedin = "";
		this.workingPlace = "";
		this.eventsAttended = new ArrayList<String>();
	}
	//This method allows members to reserve a seat at their desired event using its eventID
	public void registerEvent(String eventID) {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getWorkingPlace() {
		return workingPlace;
	}
	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace;
	}
	public ArrayList<String> getEventsAttended() {
		return eventsAttended;
	}
	public void setEventsAttended(ArrayList<String> eventsAttended) {
		this.eventsAttended = eventsAttended;
	}
	
	
}
