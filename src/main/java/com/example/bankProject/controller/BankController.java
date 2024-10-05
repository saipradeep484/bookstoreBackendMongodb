package com.example.bankProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; // Use Spring's RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankProject.model.BankEntity;
import com.example.bankProject.service.BankService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bank") // Optional: sets a base path for all endpoints in this controller
public class BankController {

    @Autowired 
    private BankService bankService;

    @GetMapping("/customers")
    public List<BankEntity> getAllCustomers() {
        return bankService.findAllCustomers();
    }
   
    @PostMapping("/saveCustomer")
    public BankEntity saveCustomer(@RequestBody BankEntity bankEntity) {
        return bankService.saveCustomer(bankEntity);
    }
    @GetMapping("/customers/{id}")
    public Optional<BankEntity> findById(@PathVariable String id)
    {
        return bankService.findCustomerById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id)
    {
        bankService.deleteCustomerById(id);
    }
   
    @PutMapping("/customers/{id}")
public ResponseEntity<BankEntity> updateCustomer(@PathVariable String id, @RequestBody BankEntity updatedCustomer) {
    Optional<BankEntity> existingCustomer = bankService.findCustomerById(id);
    if (existingCustomer.isPresent()) {
        BankEntity customer = existingCustomer.get();
        customer.setCustomerBooks(updatedCustomer.getCustomerBooks());
        customer.setCustomerAmount(updatedCustomer.getCustomerAmount());
        bankService.saveCustomer(customer);
        return ResponseEntity.ok(customer);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}

}
