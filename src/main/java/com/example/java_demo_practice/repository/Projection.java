package com.example.java_demo_practice.repository;

import com.example.java_demo_practice.entity.LoginInfo;

import java.time.LocalDateTime;

public class Projection {

//    private LoginInfo loginInfo;
    private String account;

    private String name;

    private int age;

    private String city;

    private LocalDateTime registerTime;

    private boolean isActive;
    //--------------------------------------

    public Projection() {
    }

    public Projection(String account, String name, int age, String city, LocalDateTime registerTime, boolean isActive) {
        this.account = account;
        this.name = name;
        this.age = age;
        this.city = city;
        this.registerTime = registerTime;
        this.isActive = isActive;
    }
    //---------------------------------


//    public LoginInfo getLoginInfo() {
//        return loginInfo;
//    }
//
//    public void setLoginInfo(LoginInfo loginInfo) {
//        this.loginInfo = loginInfo;
//    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
