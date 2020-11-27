package com.company;

import com.company.dto.*;
import com.company.service.CreditTransaction;
import com.company.service.DebitTransaction;
import com.company.service.Transaction;

import java.util.Scanner;

import static com.company.dto.Customer.customerIdMap;
import static com.company.service.Transaction.customerPointsMap;

public class Main {

    public static void main(String[] args) {
        String option;
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add a new Customer");
        System.out.println("2.Credit Points");
        System.out.println("3.Debit Points");
        System.out.println("4.Show Balance");
        System.out.println("5.Exit");

        while(true) {
            System.out.println("Enter your option : ");
            option = sc.nextLine();
            switch(option)
            {
                case "1":
                    Customer cust = createNewCustomer();
                    if(cust == null) {
                        System.out.println("Customer already exists");
                        break;
                    } else {
                        customerIdMap.put(cust.getCustomer_id(),cust);
                        customerPointsMap.put(cust,0);
                    }
                    break;
                case "2":
                    System.out.println("Enter your Customer ID : ");
                    String cust_id1 = sc.nextLine();
                    System.out.println("Enter points to be credited : ");
                    int credit_points = Integer.parseInt(sc.nextLine());
                    Transaction credit = new CreditTransaction();

                    credit.execute(customerIdMap.get(cust_id1),credit_points);
                    break;
                case "3":
                    System.out.println("Enter your Customer ID : ");
                    String cust_id2 = sc.nextLine();
                    System.out.println("Enter points to be debited : ");
                    int debit_points = Integer.parseInt(sc.nextLine());
                    Transaction debit = new DebitTransaction();
                    debit.execute(customerIdMap.get(cust_id2),debit_points);
                    break;
                case "4":
                    System.out.println("Enter your Customer ID : ");
                    String cust_id3 = sc.nextLine();
                    Customer customer = customerIdMap.get(cust_id3);
                    if(customer == null)
                    {
                        System.out.println("Customer does not exist");
                        break;
                    }
                    System.out.print("Balance = ");
                    System.out.println(customerPointsMap.get(customer));
                    break;
                case "5":
                    System.out.println("Exiting");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid option ");
                    break;
            }
        }
    }

    public static Customer createNewCustomer()
    {
        Customer cust = new Customer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        cust.setName(sc.nextLine());
        System.out.println("Enter your customer id: ");
        cust.setCustomer_id(sc.nextLine());
        if(customerIdMap.get(cust.getCustomer_id())!=null) {
            return null;
        }
        else {
            return cust;
        }
    }
}

