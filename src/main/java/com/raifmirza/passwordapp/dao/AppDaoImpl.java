package com.raifmirza.passwordapp.dao;

import com.raifmirza.passwordapp.entity.Passwords;
import com.raifmirza.passwordapp.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
public class AppDaoImpl implements AppDao{

    public EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public void addUser(User theUser) {

    }

    @Override
    public void deleteUser(User theUser) {

    }

    @Override
    public void updateUser(User theUser) {

    }

    @Override
    public void addPassword(Passwords password) {

    }

    @Override
    public void deletePassword(Passwords passwords) {

    }

    @Override
    public void updatePassword(Passwords passwords) {

    }
}
