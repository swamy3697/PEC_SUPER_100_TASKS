package com.swamy3697;

public class Customer {
    private String CustomerName;
    private long accountNumber;
    private int secretPin;
    private int age;
    private int phoneNumber;
    private int accountBalance;

    private Customer(CustomerBuilder builder) {

    }

    public String getCustomerName() {
        return CustomerName;
    }

    public int getSecretPin() {
        return this.secretPin;
    }

    public void setAge(int age){
        this.age=age;
    }
    public void setPhoneNumber(int age){
        this.age=age;
    }
    public void setName(String name){
        this.CustomerName=name;
    }
    public void CreditAmount(int amount){
        this.accountBalance=this.accountBalance+amount;
    }
    public void debitAmount(int amount){
        this.accountBalance=this.accountBalance-amount;
    }
    public int getAccountBalance(){
        return this.accountBalance;
    }

    public static class CustomerBuilder {
        private String CustomerName;
        private long accountNumber;
        private int secretPin;
        private int age = 25;
        private int phoneNumber = 1234567890;
        private int accountBalance = 10000;

        CustomerBuilder(String customerName, long accountNumber, int secretPin) {
            this.CustomerName = customerName;
            this.accountNumber = accountNumber;
            this.secretPin = secretPin;

        }

        public CustomerBuilder age(int age) {
            this.age = age;
            return this;
        }

        public CustomerBuilder phone_Number(int PhoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerBuilder account_Balance(int balance_Amount) {
            this.accountBalance = balance_Amount;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }

}
