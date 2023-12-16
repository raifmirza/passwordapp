package com.raifmirza.passwordapp.dao;

import com.raifmirza.passwordapp.entity.User;

import java.util.List;

public interface UserDao {

    void save(User theUser) ;

    User findByUserName(String userName);

    List<User> findUsers();
}
