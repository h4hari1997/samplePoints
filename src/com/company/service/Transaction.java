package com.company.service;

import com.company.dto.Customer;

import java.util.HashMap;

public abstract class Transaction {

    public static HashMap<Customer,Integer> customerPointsMap = new HashMap<>();

    public abstract void execute(Customer cust, int points) throws Exception;

    public void updateBalance(int points,Customer cust) {
        customerPointsMap.put(cust,points);
    }

}