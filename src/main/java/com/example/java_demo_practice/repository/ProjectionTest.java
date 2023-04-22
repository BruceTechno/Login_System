package com.example.java_demo_practice.repository;

import java.time.LocalDateTime;

public interface ProjectionTest {

    public String getAccount();
    public String getName();

    public int getAge();

    public String getCity();

    public LocalDateTime getRegisterTime();

    public boolean getIsActive();
}
/*
*   private String account;

    private String pwd;

    private String name;

    private int age;

    private String city;

    private LocalDateTime registerTime;

    private boolean isActive;
* */