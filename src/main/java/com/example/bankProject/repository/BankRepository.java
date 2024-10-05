package com.example.bankProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.bankProject.model.BankEntity;


public interface BankRepository extends MongoRepository<BankEntity,String> {

    
} 
