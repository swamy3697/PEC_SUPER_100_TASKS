//package com.swamy3697;

import java.util.*;

public class Library {
    static HashMap<Integer,Member> members;
    static Scanner scanner;
    static Member member;
    static HashMap<String,Book> booksList;
    public static void main(String[] args) {
	// write your code here
        scanner=new Scanner(System.in);
        members=new HashMap<>();
        booksList=new HashMap<>();
        boolean isYouIn=true;
        //int action;
        System.out.println("WELCOME YOU LIBRARY");
        System.out.println("CHOOSE ACTION");

        while(isYouIn){
            System.out.println("1 : BOOKS LIST");
            System.out.println("2 : BARROW BOOK");
            System.out.println("3 : YOUR ACCOUNT DEATILS");
            System.out.println("4 : CREATE ACCOUNT");
            System.out.println("5 : ADD BOOK");
            System.out.println("6 : EXIT");
            switch (scanner.nextInt()){
                case 1:
                    printBooksList(booksList);
                    break;
                case 2:
                    barrowBook();
                    //books.barrowBook();
                    break;
                case 3:
                    bookDetails();
                    break;
                case 4:
                    createAccount();
                    break;
                case 5:
                    addBook();
                    break;
                case 6:
                    isYouIn=false;
                    System.out.println("THANKS FOR VISITING LIBRARY");
                    break;
                default:
                    System.out.println("PLEASE WASH YOUR EYES I KINDLY REQUEST....");
                    break;
            }



        }


    }

    private static void addBook() {
        String name;
        String Authour;
        int yearOfPublished;
        String publisher;
        int numberOfPages;
         double price;
        String available;
        int count;
        System.out.println("WELCOME TO ADD BOOK SECTION");
        System.out.println("PLEASE ENTER BOOK DEATILS TO ADD TO LIBRARY");

        System.out.println("PLEASE ENTER NAME OF THE BOOK");
        scanner.next();
        name= scanner.nextLine();

        System.out.println("PLEASE ENTER NAME OF AUTHOR");
        Authour= scanner.nextLine();

        System.out.println("PLEASE ENTER YEAR OF PUBLISHED");
        yearOfPublished= scanner.nextInt();
        scanner.next();

        System.out.println("PLEASE ENTER NAME OF PUBLISHERS");
        publisher= scanner.nextLine();

        System.out.println("PLEASE ENTER NUMBER OF PAGES");
        numberOfPages= scanner.nextInt();

        System.out.println("PLEASE ENTER PRICE");
        price= scanner.nextInt();

        System.out.println("PLEASE ENTER AVAILBILITY");
        available= scanner.nextLine();

        System.out.println("PLEASE ENTER AVAILBLE BOOK COUNT");
        count= scanner.nextInt();

        Book book2=new Book(name,Authour,yearOfPublished,publisher,numberOfPages,price,available,count);
        booksList.put(name,book2);




    }

    private static void createAccount() {
        System.out.println("WELCOME TO CREATE ACCOUNT ");
        System.out.println("PLEASE ENTER YOUR DETAILS");
        System.out.println("ENTER YOUR NAME ");
        String name= scanner.nextLine();

        System.out.println("ENTER YOUR AGE ");
        int age= scanner.nextInt();

        System.out.println("ENTER YOUR ID ");
        int id= scanner.nextInt();

        System.out.println("ENTER YOUR PASSWORD ");
        String password= scanner.nextLine();

        Member member1=new Member(name,age,id,password);
        members.put(id,member1);

    }

    private static void bookDetails() {
        System.out.println("WELCOME TO BOOK DEATILS");
        printBooksList(booksList);
        System.out.println("PLEASE ENTER BOOK NAME TO SEARCH DETAILS");
        String book=scanner.nextLine();
        if(booksList.containsKey(book)){
            Book book1=booksList.get(book);
            System.out.println("BOOK NAME : "+book1.getName());
            System.out.println("AUTHOR : "+book1.getAuthour());
            System.out.println("PRICE "+book1.getPrice());
            System.out.println("NO PAGES : "+book1.getNumberOfPages());
            System.out.println("PIBLISHER : "+book1.getPublisher());
            System.out.println("AVAILBILITY : "+book1.isAvailable());
            System.out.println("YEAR OF PUBLISHED : "+book1.getYearOfPublished());
            return;
        }
        System.out.println("WE DON'T HAVE THAT BOOK");


    }

    private static void printBooksList(HashMap booksKey) {
        List booklist= Arrays.asList(booksKey.keySet().toArray());
        Iterator iterator=booklist.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    private static void barrowBook() {
        //String[] booksKey=
        if(!isMember()){
            System.out.println("SORRY YOU DONT HAVE AN ACCOUNT ");
            return;
        }
        printBooksList(booksList);
        System.out.println("PLEASE ENTER BOOK THAT YOU WANT TO ADD");
        String bookName=scanner.nextLine();
        if(booksList.containsKey(bookName)){
            member.addBook(booksList.get(bookName));
            System.out.println("BOOK SUCCESSFULLY BARROWED");
            return;
        }
        System.out.println("WE DONT HAVE THAT BOOK");
    }
    private static boolean isMember(){
        System.out.println("PLEASE ENTER YOUR ID");
        int id=scanner.nextInt();
        if(!members.containsKey(id)){
            System.out.println("ACCESS DENIED");
            System.out.println("WANT TO CREATE ACCOUT IF YES TYPE 'Y' 'N' FOR NO");
            if(scanner.nextLine().equals("Y")){
                createAccount();
            }

            return false;
        }
        member=members.get(id);
        return true;

    }
}
