package com.example.usedrecycling.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public void registerUser(UserRegisterPostRequest userRegisterPostRequest) {
        userMapper.insertUser(userRegisterPostRequest);
    }

    public User loginUser(UserLoginPostRequest userLoginPostRequest) {
        return userMapper.getUserByEmailAndPwd(userLoginPostRequest);
    }

    public User currentUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    public void logoutUser(HttpSession session) {
        session.removeAttribute("user");
    }

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public void setUsername(String username, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        user.setUsername(username);
        userMapper.setUsername(username, id);
    }

    public void setPassword(String password, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        user.setPasswd(password);
        userMapper.setPasswd(password, id);
    }
}
