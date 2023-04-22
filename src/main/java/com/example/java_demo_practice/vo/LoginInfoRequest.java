package com.example.java_demo_practice.vo;

import com.example.java_demo_practice.entity.LoginInfo;

import java.time.LocalDateTime;

public class LoginInfoRequest {
    private LoginInfo loginInfo;
    private String name;
    private String account;
    private String pwd;

    private int age;

    private String city;

    private LocalDateTime registerTime;

    private boolean isActive;
//----------------------------------------------------------------------------Constructor

    public LoginInfoRequest() {
    }


//---------------------------------------------------------------------------Get Setter


    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
