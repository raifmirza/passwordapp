package com.raifmirza.passwordapp.service;

import com.raifmirza.passwordapp.User.WebUser;
import com.raifmirza.passwordapp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public User findByUserName(String username);
    void save(WebUser webUser);
    public List<User> findUsers();
}
