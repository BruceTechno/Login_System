package com.example.java_demo_practice.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "login")
public class LoginInfo {

    @Id
    @Column(name = "account")
    private String account;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age ;
    @Column(name = "city")
    private String city;
    @Column(name = "register_time")
    private LocalDateTime registerTime =LocalDateTime.now();
    @Column(name = "active")
    private boolean isActive ;
//==============================================--Constructor--=====================

    public LoginInfo(String account, String pwd, String name, int age, String city) {
        this.account = account;
        this.pwd = pwd;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public LoginInfo() {
    }
//==============================================--Get Setter --=====================


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
