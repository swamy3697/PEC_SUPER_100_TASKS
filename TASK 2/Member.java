//package com.swamy3697;


import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    public List<Book> bookList=new ArrayList<>();
    public Member(String name, int age, int id, String password) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.password = password;
    }

    private int age;
    private final int id;
    private final String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void addBook(Book book){
        this.bookList.add(book);
    }


}
