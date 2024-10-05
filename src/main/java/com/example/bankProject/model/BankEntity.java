package com.example.bankProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bankentity")

public class BankEntity {
    @Id
    private String id;
    private int customerBooks;
    private int customerAmount;
    private String customerName;


    public int getCustomerBooks() {
        return customerBooks;
    }
    public void setCustomerBooks(int customerBooks) {
        this.customerBooks = customerBooks;
    }
    public int getCustomerAmount() {
        return customerAmount;
    }
    public void setCustomerAmount(int customerAmount) {
        this.customerAmount = customerAmount;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
}
