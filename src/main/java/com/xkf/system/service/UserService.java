package com.xkf.system.service;

import com.xkf.system.bean.ResultObject;
import com.xkf.system.bean.User;
import com.xkf.system.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xukefei
 * @create 2021-08-03 下午3:47
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public ResultObject getUserList() {
        return ResultObject.success("读取成功", userMapper.getUserList());
    }

    public ResultObject register(User user) {
        List<User> users = userMapper.findUserByName(user.getUserName());
        if (users.size() != 0) {
            return ResultObject.error("用户名已存在", null);
        }
        userMapper.addUser(user);
        return ResultObject.success("注册成功", null);
    }

    public ResultObject login(User user, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getUserName());
        map.put("password", user.getPassword());
        List<User> users = userMapper.findUserByNameAndPassword(map);
        if (users.size() != 0) {
            session.setAttribute("user", user);
            return ResultObject.success("登录成功", null);
        } else {
            return ResultObject.error("登录失败", null);
        }

    }
}
