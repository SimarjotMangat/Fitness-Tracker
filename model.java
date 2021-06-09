package com.example.fitness_tracker;

public class model {
    String name;
    String address;
    String number;
    String email;



    public model(String name, String email ,String address, String phoneno1) {
        this.name = name;
        this.address = address;
        this.number = phoneno1;
        this.email = email;
    }
    public model(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }


}
