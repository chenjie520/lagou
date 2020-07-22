package com.lagou.pojo;

/**
 *@Author chen_jie
 *@Version 1.0
 *@time 2020/7/22
 **/
public class User {

    private Integer id;
    private String username;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}

