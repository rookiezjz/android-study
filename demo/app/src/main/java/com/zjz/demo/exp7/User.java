package com.zjz.demo.exp7;

public class User {
    private String name, number, email;
    public User(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public String getNumber(){
        return number;
    }
    public String getEmail(){
        return email;
    }
}
