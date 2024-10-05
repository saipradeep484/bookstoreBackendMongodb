package com.example.bankProject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankProject.model.BankEntity;
import com.example.bankProject.repository.BankRepository;

@Service
public class BankService {
    @Autowired BankRepository bankRepository;

    public List<BankEntity> findAllCustomers()
    {
        return bankRepository.findAll();
    }
    public BankEntity saveCustomer(BankEntity bankEntity)
    {
        return bankRepository.save(bankEntity);
    }
    public java.util.Optional<BankEntity> findCustomerById(String id)
    {
        return bankRepository.findById(id);
    }
    public void deleteCustomerById(String s)
    {
         bankRepository.deleteById(s);
    }
}
