package com.company.dto;

import java.util.HashMap;

public class Customer {

    private String customer_id;
    private String name;
    private int current_balance;

    public static HashMap<String,Customer> customerIdMap = new HashMap<>();

    public Customer() {
    }

    public Customer(String customer_id, String name, int current_balance) {
        this.customer_id = customer_id;
        this.name = name;
    }

    public String getCustomer_id() {
        return this.customer_id;
    }

    public String getName() {
        return this.name;
    }

    public void setCustomer_id(String customer_id){
        this.customer_id = customer_id;
    }

    public void setName(String name){
        this.name = name;
    }

}