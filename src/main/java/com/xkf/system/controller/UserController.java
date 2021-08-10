package com.xkf.system.controller;

import com.xkf.system.bean.ResultObject;
import com.xkf.system.bean.User;
import com.xkf.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xukefei
 * @create 2021-08-02 下午4:03
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getusers")
    public ResultObject getUserList() {
        return userService.getUserList();
    }

    @PostMapping("/register")
    public ResultObject register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResultObject login(@RequestBody User user, HttpSession session) {
        return userService.login(user, session);
    }

    @PostMapping("/logout")
    public ResultObject logout(User user, HttpSession session) {
        session.invalidate();
        return ResultObject.success("登出成功", null);
    }

}
