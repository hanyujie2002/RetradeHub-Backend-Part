package com.example.usedrecycling.user;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into users (username, email, passwd) values(#{username}, #{email}, #{passwd})")
    void insertUser(UserRegisterPostRequest userRegisterPostRequest);

    @Select("SELECT * FROM users where email = #{email} and passwd = #{passwd}")
    User getUserByEmailAndPwd(UserLoginPostRequest userLoginPostRequest);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(Integer id);

    @Update("UPDATE users SET username = #{username} WHERE id = #{id}")
    void setUsername(String username, Integer id);

    @Update("UPDATE users SET passwd = #{passwd} WHERE id = #{id}")
    void setPasswd(String passwd, Integer id);
}
