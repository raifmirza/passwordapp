package com.raifmirza.passwordapp.dao;

import com.raifmirza.passwordapp.entity.User;

import java.util.List;

public interface UserDao {

    void save(User theUser) ;
    void delete(int id);
    User findByUserName(String userName);
    User findUserById(int id);
    List<User> findUsers();

}
