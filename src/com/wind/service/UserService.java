package com.wind.service;

import com.wind.domain.User;
import com.wind.error.MsgException;

public interface UserService {
    User loginUser(User user);
    void regist(User user) throws MsgException;
}
