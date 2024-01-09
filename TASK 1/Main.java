package com.swamy3697;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan=new Scanner(System.in);
        //create account
        System.out.println("------- -- ----- -------");
        System.out.println("WELCOME TO STARK BANKING");
        System.out.println("------- -- ----- -------");

        //options to user

        int acountCount=0;

        Bank bank=new Bank(scan);
        boolean isBankOpen=true;
        while(isBankOpen) {
            System.out.println("1 FOR : CREATE ACCOUNT");
            System.out.println("2 FOR : UPDATE ACCOUNT");
            System.out.println("3 FOR : CREDIT AMOUNT");
            System.out.println("4 FOR : WITHDRAW ACCOUNT");
            System.out.println("5 FOR : DELETE ACCOUNT");
            System.out.println("6 FOR : EXIT FROM BANK");

            int option=scan.nextInt();
            switch (option){
                case 1:
                    bank.createAccount(acountCount++);
                    break;
                case 2:
                    bank.updateAccount();
                    break;
                case 3:
                    bank.creditAmount();
                    break;
                case 4:
                    bank.withDraw();
                    break;
                case 5:
                    bank.deleteAccount();
                    break;
                case 6:
                    isBankOpen=false;
                    break;
                default:
                    System.out.println("PLEASE WASH YOUR EYES WITH HARPIC AND CHOOSE  ACTION CORRECTLY NEXT TIME UNTIL THEN BYE!!");
            }

        }



    }


}
