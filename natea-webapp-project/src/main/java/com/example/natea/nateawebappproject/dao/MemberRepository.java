package com.example.natea.nateawebappproject.dao;

import java.util.List;

import com.example.natea.nateawebappproject.model.Member;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "members", path = "members")
public interface MemberRepository extends MongoRepository<Member, String>{

    public List<Member> findByFirstName(@Param("firstname") String firstName);
}