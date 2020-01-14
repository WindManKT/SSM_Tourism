package com.wind.service;

import com.wind.domain.User;
import com.wind.error.MsgException;
import com.wind.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User loginUser(User user) {
        if (userMapper.findUser(user)==null)throw new MsgException("用户名或密码错误");
        return userMapper.findUser(user);
    }

    @Override
    public void regist(User user) throws MsgException {
       if (userMapper.findUser(new User.createUser().setUsername(user.getUsername()).createUser())!=null){
           throw new MsgException("用户名已被占用");
       }else {
           try{
               userMapper.addUser(user);
           }catch (Exception e){
               throw new MsgException("注册失败，服务器繁忙，请稍后重试");
           }
       }
    }

}
