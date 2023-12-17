package com.raifmirza.passwordapp.service;

import com.raifmirza.passwordapp.dao.PasswordDaoImpl;
import com.raifmirza.passwordapp.entity.Passwords;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PasswordServiceImpl implements PasswordService{
    private PasswordDaoImpl passwordDao;
    @Autowired
    public PasswordServiceImpl(PasswordDaoImpl thePasswordDao){
        this.passwordDao = thePasswordDao;
    }
    @Override
    public void add(Passwords password) {
        passwordDao.addPassword(password);
    }

    @Override
    public void deleteById(int id) {
        passwordDao.deletePassword(id);
    }

    @Override
    public void deleteByName(String name) {
        passwordDao.deleteByName(name);
    }

    @Override
    public List<Passwords> listPasswords() {
        return null;
    }
}
