package com.raifmirza.passwordapp.service;

import com.raifmirza.passwordapp.entity.Passwords;
import java.util.List;
public interface PasswordService {
    void add(Passwords password);
    void deleteById(int id);
    void deleteByName(String name);
    List<Passwords> listPasswords();
}
