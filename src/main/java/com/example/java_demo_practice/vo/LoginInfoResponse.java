package com.example.java_demo_practice.vo;

import com.example.java_demo_practice.entity.LoginInfo;
import com.example.java_demo_practice.repository.Projection;
import com.example.java_demo_practice.repository.ProjectionTest;

import java.util.List;

public class LoginInfoResponse {

    private List<ProjectionTest> projectionTest;

//    private Projection loginInfoWithoutPwd ;

//    private LoginInfo loginInfo ;

//    private List<LoginInfoWithoutPwd> loginInfoWithoutPwd;

    private  String message ;

    private String name;

    private List<LoginInfo> loginInfoList;

//---------------------------------------------------------------------------Constructor

    public LoginInfoResponse() {
    }

    public LoginInfoResponse(List<ProjectionTest> projectionTest, String message) {
        this.projectionTest = projectionTest;
        this.message = message;
    }

//    public LoginInfoResponse(Projection loginInfoWithoutPwd, String message) {
//        this.loginInfoWithoutPwd = loginInfoWithoutPwd;
//        this.message = message;
//    }

    public LoginInfoResponse(String message) {
        this.message = message;
    }

    public LoginInfoResponse(String message, String name) {
        this.message = message;
        this.name = name;
    }

//    public LoginInfoResponse( List<LoginInfo> loginInfoList,String message )  {
//        this.message = message;
//        this.loginInfoList = loginInfoList;
//    }

//    public LoginInfoResponse(List<LoginInfoWithoutPwd> loginInfoWithoutPwd, String message) {
//        this.loginInfoWithoutPwd = loginInfoWithoutPwd;
//        this.message = message;
//    }
    //---------------------------------------------------------------------------Get Setter


    public List<ProjectionTest> getProjectionTest() {
        return projectionTest;
    }

    public void setProjectionTest(List<ProjectionTest> projectionTest) {
        this.projectionTest = projectionTest;
    }

//    public Projection getLoginInfoWithoutPwd() {
//        return loginInfoWithoutPwd;
//    }

//    public void setLoginInfoWithoutPwd(Projection loginInfoWithoutPwd) {
//        this.loginInfoWithoutPwd = loginInfoWithoutPwd;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LoginInfo> getLoginInfoList() {
        return loginInfoList;
    }

    public void setLoginInfoList(List<LoginInfo> loginInfoList) {
        this.loginInfoList = loginInfoList;
    }

//    public LoginInfo getLoginInfo() {
//        return loginInfo;
//    }

//    public void setLoginInfo(LoginInfo loginInfo) {
//        this.loginInfo = loginInfo;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
