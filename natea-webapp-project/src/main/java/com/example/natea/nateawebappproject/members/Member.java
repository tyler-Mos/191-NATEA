package com.example.natea.nateawebappproject.members;

import org.springframework.data.annotation.Id;

/*
will not work for formbase login, just for testing in memory database
*/
public class Member{
    @Id
    private String id;

    private String firstName;
    private String lastName;
 
    public Member(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
      return String.format(
          "Member[id=%s, firstName='%s', lastName='%s']",
          id, firstName, lastName);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}