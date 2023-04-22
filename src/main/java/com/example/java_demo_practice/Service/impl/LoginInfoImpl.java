package com.example.java_demo_practice.Service.impl;

import com.example.java_demo_practice.Service.ifs.LoginInfoService;
import com.example.java_demo_practice.entity.LoginInfo;
import com.example.java_demo_practice.repository.LoginInfoDao;
import com.example.java_demo_practice.repository.ProjectionTest;
import com.example.java_demo_practice.vo.LoginInfoRequest;
import com.example.java_demo_practice.vo.LoginInfoResponse;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.plaf.synth.SynthTableUI;
import java.awt.desktop.PreferencesEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoginInfoImpl implements LoginInfoService {
    @Autowired
    private LoginInfoDao loginInfoDao;

    @Override
    public LoginInfoResponse signUp(LoginInfo loginInfo) {//要拆成兩個方法(Yet) //account重複的判斷還沒做

        String account = loginInfo.getAccount();
        String pwd = loginInfo.getPwd();
        String name = loginInfo.getName();
        int    age  = loginInfo.getAge();
        String city = loginInfo.getCity();

        String patternAccount = "^[^\\s]{3,8}$";
        String patternPwd = "^(?=.*[\\p{Punct}])(?!.*[\\s\\t\\r\\n\\f])[\\p{Print}]{8,12}$";

        if (loginInfo == null) {
            return new LoginInfoResponse("Login information is null");
        }
        if (!StringUtils.hasText(account) || !account.matches(patternAccount)) { // 順便判斷 帳號長度3~8碼  不能有任何空白   + pattern
            return new LoginInfoResponse("account format is error");
        }
        if (!StringUtils.hasText(pwd) || !pwd.matches(patternPwd)) { // pwd 8~12碼  至少要有一個特殊符號但不能有空白、Tab、定位、換行、換頁等符號 (Maybe use /s )
            return new LoginInfoResponse("password format is error");
        }
        if (!StringUtils.hasText(name)) {
            return new LoginInfoResponse("name format is error");
        }
        if (age < 1 ){
            return new LoginInfoResponse("age format is error");
        }
        if(!StringUtils.hasText(city)){
            return new LoginInfoResponse("city format is error");
        }

        Optional<LoginInfo> op = loginInfoDao.findById(account);
        if (op.isPresent()) {
            return new LoginInfoResponse("account already exist");
        }


        loginInfoDao.save(loginInfo);

        return new LoginInfoResponse(loginInfo.getName(), "Sign up successfully");//return 使用者帳號 名稱 , 註冊成功
    }
    @Override
    public LoginInfoResponse active(LoginInfoRequest request) {

        String account = request.getAccount();
        String pwd = request.getPwd();
        String name = request.getName();

        if (!StringUtils.hasText(account)){
            return new LoginInfoResponse("account is null");
        }
        Optional<LoginInfo> op = loginInfoDao.findById(account);
        if (!op.isPresent()){
            return new LoginInfoResponse("invalid account ");//沒這個account拉
        }

        if (!name.equals(op.get().getName())) {
            return new LoginInfoResponse("name error"); //name第一個if
        }
        if (!account.equals(op.get().getAccount())) {
            return new LoginInfoResponse("account error");
        }
        if (!pwd.equals(op.get().getPwd())) {
            return new LoginInfoResponse("password error");
        }
        op.get().setActive(true);

//        if (account.equals(op.get().getAccount()) &&
//                    pwd.equals(op.get().getPwd()) &&
//                    name.equals(op.get().getName())) {
//                op.get().setActive(true);
//            }
        loginInfoDao.save(op.get());
        //------------------------------------------------
//        List<LoginInfo> dbInfo = loginInfoDao.findAll();
//        for (LoginInfo item : dbInfo) {
//            if (account.equals(item.getAccount()) &&
//                    pwd.equals(item.getPwd()) &&
//                    name.equals(item.getName())) {
//                item.setActive(true);
//            }
//        }
//        loginInfoDao.saveAll(dbInfo);

//        if (account.equals(op.getAccount()) &&
//                    pwd.equals(op.getPwd()) &&
//                    name.equals(op.getName())) {
//                op.setActive(true);
//            }
//        loginInfoDao.save(op);
//        List<LoginInfo> dbInfo = loginInfoDao.findAll();
//        for (LoginInfo item : dbInfo) {
//            if (account.equals(item.getAccount()) &&
//                    pwd.equals(item.getPwd()) &&
//                    name.equals(item.getName())) {
//                item.setActive(true);
//            }
//        }
//        loginInfoDao.saveAll(dbInfo);
        return new LoginInfoResponse(request.getName() , "active successfully" );//return message (active successfully)
    }
    @Override
    public LoginInfoResponse login(LoginInfoRequest request) {//先抓出request 裡面的
        if (request == null) {
            return new LoginInfoResponse("WTFFFFFFFFFFF?");
        }
        if (!StringUtils.hasText(request.getName())){
            return new LoginInfoResponse("name error error");
        }

        String name = request.getName();
        String account = request.getAccount();
        String pwd = request.getPwd();

//        List<LoginInfo> dbInfo = loginInfoDao.findAll();//資料全抓出來

        LoginInfo correctUserInfo = loginInfoDao.findByName(name);

        if (correctUserInfo == null ) {
            return new LoginInfoResponse("correctUserInfo is null");
        }

        if (!name.equals(correctUserInfo.getName())) {
            return new LoginInfoResponse("name error"); //name第一個if
        }
        if (!account.equals(correctUserInfo.getAccount())) {
            return new LoginInfoResponse("account error");
        }
        if (!pwd.equals(correctUserInfo.getPwd())) {
            return new LoginInfoResponse("password error");
        }
        if (correctUserInfo.isActive() == false) {
            return new LoginInfoResponse("You didn't active");
        }

//        List<String> dbInfoName = new ArrayList<>();--------------------------------phase3
//
//        for (LoginInfo item :dbInfo){
//            dbInfoName.add(item.getName());
//        }
//        if (!dbInfoName.contains(name)){
//            return new LoginInfoResponse("There is no user in DB");
//        }
//
//        Optional<LoginInfo> correctUserInfo = loginInfoDao.findById(name);
//        if (!correctUserInfo.isPresent()){
//            return new LoginInfoResponse("correctUserInfo is null");
//        }
//
//        if (!name.equals(correctUserInfo.get().getName())){
//            return new LoginInfoResponse("name error") ; //name第一個if
//        }
//        if (!account.equals(correctUserInfo.get().getAccount()))  {
//            return new LoginInfoResponse("account error");
//        }
//        if (!pwd.equals(correctUserInfo.get().getPwd())){
//            return  new LoginInfoResponse("password error");
//        }
//        if ( correctUserInfo.get().isActive() == false){
//            return new LoginInfoResponse("You didn't active");
//        }-------------------------------------------------------------------phase3
    /*// -----------------------------------------------------------phase2
        for (LoginInfo item : dbInfo){
            if (!item.getName().contains(name)){
                return new LoginInfoResponse("There is no user in DB");
            }
            correctNameList.add(name);
        }
        List<LoginInfo> validUser = loginInfoDao.findAllById(correctNameList);
        for (LoginInfo item : validUser){
            if (!name.equals(item.getName())){
                return new LoginInfoResponse("name error") ; //name第一個if
            }
            if (!account.equals(item.getAccount()))  {
                return new LoginInfoResponse("account error");
            }
            if (!pwd.equals(item.getPwd())){
                return  new LoginInfoResponse("password error");
            }
            if ( item.isActive() == false){
                return new LoginInfoResponse("You didn't active");
            }
        }
         -----------------------------------------------------------phase2      */
//---------------------------------------------------------phase1
//        for (LoginInfo item : dbInfo) {
//            if (!name.equals(item.getName())){
//                return new LoginInfoResponse("There is no user in DB") ; //name第一個if
//            }
//            if (!account.equals(item.getAccount()))  {
//                return new LoginInfoResponse("account error");
//            }
//            if (!pwd.equals(item.getPwd())){
//                return  new LoginInfoResponse("password error");
//            }
//            if ( item.isActive() == false){
//                return new LoginInfoResponse("You didn't active");
//            }
//        }------------------------------------------------------phase1
            return new LoginInfoResponse(request.getName(), "Login successfully");
        }

    @Override      //居住在某個城市的使用者搜尋，Response 不包含密碼    含排序，照年齡(Dao 要新增方法 )
    public LoginInfoResponse getUserInfoByCity(String city) {

        if (!StringUtils.hasText(city)){
            return new LoginInfoResponse("city format is error");
        }
        //去Dao定義 find City 的方法 要把包含 這個 city的資料全部抓出來
        List<ProjectionTest> result = loginInfoDao.findByCityContainingOrderByAge(city);
        //把全部資料撈出來 然後放到另外一個地方 一欄一欄放進去另外一個 容器 只要不放密碼 最後return 沒有密碼的那個容器

        return new LoginInfoResponse(result,"successful");
    }
}
