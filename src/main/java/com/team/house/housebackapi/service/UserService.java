package com.team.house.housebackapi.service;


import com.team.house.housebackapi.entity.Users;

public interface UserService {
    //注册业务
    public int regUser(Users users);
    //登录业务
    public Users Login(String username,String password);
}
