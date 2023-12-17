package com.raifmirza.passwordapp.dao;

import com.raifmirza.passwordapp.entity.Passwords;

import java.util.List;

public interface PasswordDao {
    void addPassword(Passwords password);
    void deletePassword(int id);
    void deleteByName(String name);
    List<Passwords> listPasswords();
}
