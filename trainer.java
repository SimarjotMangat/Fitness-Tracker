package com.example.fitness_tracker;

public class trainer {
    String number;
    String name;
    String address;
    String email;
    public trainer(){

    }

    public String getEmail() {
        return email;
    }

    public trainer(String name, String number, String address, String email){
        this.name=name;
        this.email=email;
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
