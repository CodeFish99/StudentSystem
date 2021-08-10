package com.xkf.system.bean;

/**
 * @author xukefei
 * @create 2021-08-02 上午10:49
 */
public class User {
    private int userId;
    private String userName;
    private String password;
    /* 用户类型 */
    private String type;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
