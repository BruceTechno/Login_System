package com.example.java_demo_practice.Service.ifs;

import com.example.java_demo_practice.entity.LoginInfo;
import com.example.java_demo_practice.vo.LoginInfoRequest;
import com.example.java_demo_practice.vo.LoginInfoResponse;

public interface LoginInfoService {

    //forget pwd
    //Login
    // find specific user by the city

    public LoginInfoResponse signUp (LoginInfo loginInfo );

    public LoginInfoResponse active(LoginInfoRequest request);

    public LoginInfoResponse login(LoginInfoRequest loginInfoRequest);

  public LoginInfoResponse getUserInfoByCity (String city);



    //forget pwd 可以在DB裡面加一個問與答 如果輸入問與答成功 吐出 密碼




}
