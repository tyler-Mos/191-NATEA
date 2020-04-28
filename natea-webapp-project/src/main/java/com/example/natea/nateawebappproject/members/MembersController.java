package com.example.natea.nateawebappproject.members;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
will not work for formbase login, just for testing in memory database
*/

@RestController
@RequestMapping("/members")
public class MembersController {
    
    private static final List<Member> MEMBERS = Arrays.asList(
        new Member("1", "James", "Bone"),
        new Member("2", "Maria", "Jones"),
        new Member("3", "Anna", "Smith")
    );

// PreAuthorize    hasRole('ROLE_')  hasAnyRole('ROLE_')  hasAuthority('permission')   hasAnyAuthority('permission') 

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<Member> getAllMembers(){
        System.out.println("getAllMembers");
        return MEMBERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:write')")
    public void registerNewMember(@RequestBody Member member){
        System.out.println("registerNewMember");
        System.out.println(member);
    }

    @DeleteMapping(path = "{firstName}")
    public void deleteMember(@PathVariable("firstName") String memberName){
        System.out.println("deleteMember");
        System.out.println(memberName);
    }

    @PutMapping(path = "{firstName}")
    public void updateMember(@PathVariable("firstName") String memberName, @RequestBody Member member){
        System.out.println("updateMember");
        System.out.println(String.format("%s %s", memberName, member));
    }

    @GetMapping(path = "{firstName}")
    public Member getMember(@PathVariable("firstName") String memberName){
        return MEMBERS.stream()
            .filter(member -> memberName.equals(member.getFirstName()))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Member " + memberName + "does not exist"));
    }

}
