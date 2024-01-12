package com.swamy3697;

import java.util.Iterator;

public class Book {
    private final String name;
    private final String Authour;
    private final int yearOfPublished;
    private final String publisher;
    private final int numberOfPages;
    private final double price;
    private final String available;

    public int getCount() {
        return count;
    }

    private int count;

    public String getName() {
        return this.name;
    }

    public String getAuthour() {
        return this.Authour;
    }

    public int getYearOfPublished() {
        return this.yearOfPublished;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public double getPrice() {
        return this.price;
    }

    public String isAvailable() {
        return this.available;
    }


    public Book(String name, String authour, int yearOfPublished, String publisher, int numberOfPages, double price, String available,int count) {
        this.name = name;
        this.Authour = authour;
        this.yearOfPublished = yearOfPublished;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.available = available;
        this.count=count;
    }

}
