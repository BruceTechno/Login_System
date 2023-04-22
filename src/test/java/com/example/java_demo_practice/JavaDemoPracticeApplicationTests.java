package com.example.java_demo_practice;

import com.example.java_demo_practice.Service.ifs.LoginInfoService;
import com.example.java_demo_practice.entity.LoginInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaDemoPracticeApplicationTests {
@Autowired
private LoginInfoService loginInfoService;
	@Test
	public void signUpTest() {
		LoginInfo loginInfo = new LoginInfo("a123457","@1234567","Bruce",245,"Tainan");
		LoginInfo loginInfo2 = new LoginInfo("01234567","01234567","Nancy",29,"Taipei");

		loginInfoService.signUp(loginInfo);
	}

}
