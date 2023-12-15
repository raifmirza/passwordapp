package com.raifmirza.passwordapp.dao;

import com.raifmirza.passwordapp.entity.Passwords;
import com.raifmirza.passwordapp.entity.User;

public interface AppDao {
    void addUser(User theUser);
    void deleteUser(User theUser);
    void updateUser(User theUser);
    void addPassword(Passwords password);
    void deletePassword(Passwords passwords);
    void updatePassword(Passwords passwords);
}
