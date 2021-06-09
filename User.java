package com.example.fitness_tracker;

public class User {
    String number;
    String name;
    String address;
    String email;
    public User(){

    }

    public String getEmail() {
        return email;
    }

    public User(String name, String number, String address, String email){
        this.email=email;
        this.name=name;

        this.number=number;
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
