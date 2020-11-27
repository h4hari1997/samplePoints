package com.company.service;

import com.company.dto.Customer;

public class DebitTransaction extends Transaction {

    @Override
    public void execute(Customer cust, int points) {
        if(cust == null){
            System.out.println("Customer does not exist");
            return;
        }
        if(points > customerPointsMap.get(cust)) {
            System.out.println("Balance not sufficient");
        }
        else {
            updateBalance(customerPointsMap.get(cust)-points,cust);
        }
    }

}