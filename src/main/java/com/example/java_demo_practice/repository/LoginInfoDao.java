package com.example.java_demo_practice.repository;

import com.example.java_demo_practice.entity.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

///居住在某個城市的使用者搜尋，Response 不包含密碼    含排序，照年齡(Dao 要新增方法 )
//去Dao定義 find City 的方法 要把包含 這個 city的資料全部抓出來
@Repository
public interface LoginInfoDao extends JpaRepository<LoginInfo,String> {
//    public interface UserRepository extends JpaRepository<User, Long> {

//        @Query("SELECT new com.example.java_demo_practice.repository.Projection(l.account,l.name,l.city,l.registerTime,l.isActive)FROM LoginInfo l Where l.city=city")
//
//        public Projection findByCityWithoutPwd(@Param("city") String city);

    public List<ProjectionTest> findByCityContainingOrderByAge(String city);

    public  LoginInfo findByName(String name);

    public  LoginInfo findByAccount(String account);

//    public List<LoginInfo> findByCityWithoutPwd(String city);
}
