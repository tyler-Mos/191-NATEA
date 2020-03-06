package com.example.natea.nateawebappproject;

import java.util.Hashtable;
import java.util.logging.*;

public class MemberManagementSystem {
	
	Hashtable<String, Member> members;
	Logger logger;
	
	private MemberManagementSystem() {
		members = new Hashtable<String, Member>();
		this.logger = Logger.getLogger(MemberManagementSystem.class.getName());
		this.logger.setLevel(Level.WARNING);
	}
	
	//Ensure there exists only 1 instance of the system
	private static class Singleton{
		private static final MemberManagementSystem INSTANCE = new MemberManagementSystem();
	}
	//Method getInstance allows us to get reference to the MemberManagementSystem
	//Example: MemberManagementSystem system = MemberManagementSystem.getInstance();
	public static MemberManagementSystem getInstance() {
		return Singleton.INSTANCE;
	}
	
	//Returns a reference of the Member object whose memberID matches
	public Member getMember(String memberID) {
		return members.getOrDefault(memberID, null);
	}
	
	//Adds a new member to the system using memberID
	public void addMember(String memberID, Member member) {
		if (this.members.contains(memberID)){
			
			logger.warning("THE MEMBERID THAT YOU ARE TRYING TO ADD ALREADY EXISTS."
					+ "IF YOU WISH TO OVERWRRITE, USE updateMember METHOD INSTEAD");
		} else {
			members.put(memberID, member);
		}
	}
	
	//Updates an existing member in the system using their memberID
	public void updateMember(String memberID, Member member) {
		members.replace(memberID, member);
	}
	
	//Removes a specified member whose memberID matches
	public void removeMember(String memberID) {
		members.remove(memberID);
	}
	
	
}
