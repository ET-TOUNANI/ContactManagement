package com.example.contact.entities;

import java.util.List;

public class Contact {
        private long id;
        String firstName;
        String lastName;
        String email;
        String phone;
        Type type;
        Gender gender;
    public Contact(){
        id=0;
         firstName="";
         lastName="";
         email="";
         phone="";
         type=Type.PERSONNEL;
         gender=Gender.MALE;
    }
    public Contact(long id, String firstName, String lastName, String email, String phone, Type type, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.gender = gender;
    }

    public Contact(Contact contact) {
        this.id = contact.getId();
        this.firstName =  contact.getFirstName();
        this.lastName =  contact.getLastName();
        this.email =  contact.getEmail();
        this.phone =  contact.getPhone();
        this.type =  contact.getType();
        this.gender =  contact.getGender();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}