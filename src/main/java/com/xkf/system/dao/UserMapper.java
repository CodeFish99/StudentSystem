package com.xkf.system.dao;

import com.xkf.system.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author xukefei
 * @create 2021-08-02 下午4:09
 */
public interface UserMapper {
    @Results(id = "userResultMap", value = {
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "user_pwd", property = "password")
    })
    @Select("select * from user_info")
    List<User> getUserList();

    @ResultMap("userResultMap")
    @Select("select * from user_info where user_name = #{name}")
    List<User> findUserByName(String name);

    @ResultMap("userResultMap")
    @Select("select * from user_info where user_name = #{name} and user_pwd = #{password}")
    List<User> findUserByNameAndPassword(Map<String, Object> map);

    @Insert("insert into user_info set user_name = #{userName}, user_pwd = #{password}")
    int addUser(User user);
}
