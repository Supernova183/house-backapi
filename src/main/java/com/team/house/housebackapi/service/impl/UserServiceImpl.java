package com.team.house.housebackapi.service.impl;

import com.team.house.housebackapi.entity.Users;
import com.team.house.housebackapi.entity.UsersExample;
import com.team.house.housebackapi.mapper.UsersMapper;
import com.team.house.housebackapi.service.UserService;
import com.team.house.housebackapi.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Override
    public int regUser(Users users) {
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users Login(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria=usersExample.createCriteria();
        //设置条件
        criteria.andNameEqualTo(username);
        //加密后与加密码的内容相比
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list=usersMapper.selectByExample(usersExample);
        if(list!=null && list.size()==1){
            return list.get(0);  //返回第一个对象
        }
        else
            return null;

    }
}
