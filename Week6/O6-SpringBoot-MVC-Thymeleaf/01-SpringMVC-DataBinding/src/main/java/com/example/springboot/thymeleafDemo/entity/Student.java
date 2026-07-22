package com.example.springboot.thymeleafDemo.entity;

public class Student {

    public String Firstname;
    public String Lastname;
    public int age ;
    public String country;
    public String language;
    public String gender;

    public Student(){}

    public Student(String Firstname, String Lastname, int age , String country , String language , String gender) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.age = age;
        this.country = country;
        this.language = language;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
