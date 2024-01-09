//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.swamy3697;

import com.swamy3697.Customer.CustomerBuilder;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    Scanner scanner;
    private String customerName;
    private long accountNumber;
    private int secretPin;
    private int age;
    private int phoneNumber;
    private int accountBalance;
    private int accountIndex = 0;
    Customer[] customers = new Customer[10];

    Bank(Scanner scan) {
        this.scanner = scan;
    }

    public void createAccount(int accountCount) {
        System.out.println("CREATION OF BANK ACCOUNT");
        System.out.println("PLEASE ENTER YOUR NAME :");
        this.scanner.nextLine();
        this.customerName = this.scanner.nextLine();
        System.out.println("PLEASE ENTER YOUR  SECRET PIN :");
        this.secretPin = this.scanner.nextInt();
        this.accountNumber = this.getAccountNumber();
        System.out.println("PLEASE ENTER YOUR AGE :");
        this.age = this.scanner.nextInt();
        System.out.println("PLEASE ENTER YOUR PHONE NUMBER :");
        this.scanner.nextLine();
        this.phoneNumber = this.scanner.nextInt();
        System.out.println("PLEASE ADD SOME MONEY TO YOUR ACCOUNT :");
        this.accountBalance = this.scanner.nextInt();
        Customer customer = (new CustomerBuilder(this.customerName, this.accountNumber, this.secretPin)).age(this.age).phone_Number(this.phoneNumber).account_Balance(this.accountBalance).build();
        this.customers[accountCount] = customer;
        System.out.println("YOUR ACCOUNT IS SUCCESSFULLY CREATED :");
        String loading = "LOADING";
    }

    public void updateAccount() {
        System.out.println("WELCOME TO UPDATE ACCOUNT");
        System.out.println("");
        System.out.println("ENTER YOUR SECRET PIN :");
        int scretePin = this.scanner.nextInt();
        Customer customer = this.getCustomer(scretePin);
        if (customer != null) {
            System.out.println("WELCOME " + customer.getCustomerName());
            boolean wantToUpdate = true;

            while(wantToUpdate) {
                this.update(customer);
            }
        } else {
            System.out.println("ACCESS DENIED");
        }

    }

    private void update(Customer customer) {
        System.out.println("CHOOSE ONE OPTION");
        System.out.println("1 FOR :  UPDATE NAME");
        System.out.println("2 FOR : UPDATE AGE");
        System.out.println("3 FOR : UPDATE PHONE NUMBER");
        int option = this.scanner.nextInt();
        switch(option) {
            case 1:
                this.updateAccountHolderName(customer);
                break;
            case 2:
                this.updateAccountHolderAge(customer);
                break;
            case 3:
                this.updateAccountHolderPhoneNumber(customer);
                break;
            default:
                System.out.println("PLEASE WASH YOUR EYES WITH HARPIC AND CHOOSE  ACTION CORRECTLY NEXT TIME UNTIL THEN BYE!!");
        }

    }

    private Customer getCustomer(int scretePin) {
        Customer[] var2 = this.customers;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Customer cu = var2[var4];
            if (cu != null && cu.getSecretPin() == scretePin) {
                return cu;
            }
        }

        return null;
    }

    private void updateAccountHolderPhoneNumber(Customer customer) {
        System.out.println("PLEASE ENTER YOUR NEW PHONE NUMBER :");
        int phNo = this.scanner.nextInt();
        customer.setPhoneNumber(phNo);
    }

    private void updateAccountHolderAge(Customer customer) {
        System.out.println("PLEASE ENTER YOUR NEW AGE :");
        int age = this.scanner.nextInt();
        customer.setAge(age);
    }

    private void updateAccountHolderName(Customer customer) {
        System.out.println("PLEASE ENTER YOUR NEW NAME :");
        String name = this.scanner.nextLine();
        customer.setName(name);
    }

    public void creditAmount() {
        System.out.println("WELCOME TO CREDIT AMOUNT IN ACCOUNT");
        System.out.println("");
        System.out.println("ENTER YOUR SECRET PIN :");
        int scretePin = this.scanner.nextInt();
        Customer customer = this.getCustomer(scretePin);
        if (customer != null) {
            System.out.println("WELCOME " + customer.getCustomerName());
            System.out.println("PLEASE ENTER HOW MUCH MONEY YOU WANT TO CREDIT IN YOUR ACCOUNT");
            customer.CreditAmount(this.scanner.nextInt());
            System.out.println("YOUR AVAILBLE BALANCE IS " + customer.getAccountBalance());
            System.out.println("AMOUNT SUCCESSFULLY CREDITED...");
        } else {
            System.out.println("ACCESS DENIED");
        }

    }

    public void withDraw() {
        System.out.println("WELCOME TO WITHDRAW AMOUNT IN ACCOUNT");
        System.out.println("");
        System.out.println("ENTER YOUR SECRET PIN :");
        int scretePin = this.scanner.nextInt();
        Customer customer = this.getCustomer(scretePin);
        if (customer != null) {
            System.out.println("WELCOME " + customer.getCustomerName());
            System.out.println("PLEASE ENTER HOW MUCH MONEY YOU WANT TO WITHDRAW FROM YOUR ACCOUNT");
            System.out.println("YOUR AVAILBLE BALANCE IS " + customer.getAccountBalance());
            customer.debitAmount(this.scanner.nextInt());
            System.out.println("YOUR CURRENT BALANCE IS " + customer.getAccountBalance());
            System.out.println("AMOUNT SUCCESSFULLY DEBITED...");
        } else {
            System.out.println("ACCESS DENIED");
        }

    }

    public void deleteAccount() {
        System.out.println("WELCOME TO DELETION OF YOUR  ACCOUNT");
        System.out.println("");
        System.out.println("ENTER YOUR SECRET PIN :");
        int scretePin = this.scanner.nextInt();
        Customer customer = this.getCustomer(scretePin);
        if (customer != null) {
            System.out.println("WELCOME " + customer.getCustomerName());
            System.out.println("ARE YOU SURE");
            System.out.println("9 : YES");
            System.out.println("(1 to 8) : NO");
            int opt = this.scanner.nextInt();
            if (opt == 9) {
                int index = 0;
                Customer[] var5 = this.customers;
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    Customer cu = var5[var7];
                    if (cu.getSecretPin() == scretePin) {
                        this.customers[index] = null;
                        System.out.println("YOUR ACCOUNT WAS DELETED SUCCESSFULLY");
                        break;
                    }

                    ++index;
                }
            }
        } else {
            System.out.println("ACCESS DENIED");
        }

    }

    private long getAccountNumber() {
        Random random = new Random();
        long ranNo = 1L + (long)(random.nextDouble() * 9.999999998E9D);
        return Long.parseLong(String.format("%010d", ranNo));
    }
}
