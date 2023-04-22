package com.example.java_demo_practice.controller;

import com.example.java_demo_practice.Service.ifs.LoginInfoService;
import com.example.java_demo_practice.entity.LoginInfo;
import com.example.java_demo_practice.vo.LoginInfoRequest;
import com.example.java_demo_practice.vo.LoginInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginInfoController {
    @Autowired
    LoginInfoService loginInfoService;
    @PostMapping(value = "sign_up")
    public LoginInfoResponse signUp(@RequestBody LoginInfo loginInfo){
        return loginInfoService.signUp(loginInfo);
    }

    @PostMapping(value = "active")
    public LoginInfoResponse active(@RequestBody LoginInfoRequest request){//還沒測試 應該OK了
        return  loginInfoService.active(request);
    }

    @PostMapping(value = "login")
    public LoginInfoResponse login(@RequestBody LoginInfoRequest request){//還沒測試
        return loginInfoService.login(request);
    }

    @PostMapping(value = "get_user_information_by_city")
    public LoginInfoResponse getUserInfoByCity(@RequestBody LoginInfoRequest request){
        return loginInfoService.getUserInfoByCity(request.getCity());
    }



}
