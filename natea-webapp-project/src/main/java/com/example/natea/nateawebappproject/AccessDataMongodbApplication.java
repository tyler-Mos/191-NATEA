package com.example.natea.nateawebappproject;

import com.example.natea.nateawebappproject.dao.MemberRepository;
import com.example.natea.nateawebappproject.model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessDataMongodbApplication implements CommandLineRunner{

    @Autowired
    private MemberRepository repository;

    public static void main(String[] args){
        SpringApplication.run(AccessDataMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        repository.deleteAll();

        repository.save(new Member("001", "Alice", "Smith"));
        repository.save(new Member("002", "Mike", "Smith"));

        System.out.println("Members found with findAll():");
        System.out.println("------------------------------");
        for(Member member: repository.findAll()){
            System.out.println(member);
        }
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));
    }
    
}