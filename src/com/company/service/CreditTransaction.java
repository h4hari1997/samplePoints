package com.company.service;

import com.company.dto.Customer;

public class CreditTransaction extends Transaction {

    @Override
    public void execute(Customer cust, int points) throws Exception
    {
        if(cust == null){
            throw new Exception("Customer does not exist");
        }
        updateBalance(points + customerPointsMap.get(cust),cust);
    }
}

