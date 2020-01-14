package com.wind.mapper;

import com.wind.domain.User;

public interface UserMapper {

    void addUser(User user);

    User findUser(User user);

}
