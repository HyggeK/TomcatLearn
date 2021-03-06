package com.IceCoLa.dao;

import com.IceCoLa.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 用户持久层接口*/
public interface IUserDao {
    //    查询所有对象
//    @Select("select * from user")
    List<User> findAll();

    //    @Insert("insert into user(username,birthday,sex,address)value(#{username},#{birthday},#{sex},#{address})")
//    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = int.class)
    void saveUser(User user);

    //    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    void updateUser(@Param("user") User user);

    //    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer userId);

    //    @Select("select * from user where id = #{id}")
    User findById(@Param("userId") Integer userId);

    //    @Select("select * from user where username like #{username}")//或者如下一句那样写
//    @Select("select * from user where username like '%${value}%'")//这里由于源码绑定了名字value 所以这里只能写value
    List<User> findByName(@Param("username") String username);

    //    @Select("select count(id) from user")
    int findTotal();

    List<User> findByPage(Map map);

    List<User> findByList(@Param("list") List<Integer> list);

    void insUsers(@Param("list") List<User> list);
}
