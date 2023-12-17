package com.raifmirza.passwordapp.dao;

import com.raifmirza.passwordapp.entity.Passwords;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class PasswordDaoImpl implements PasswordDao{
    private EntityManager entityManager;
    @Autowired
    public PasswordDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void addPassword(Passwords password) {
        entityManager.persist(password);
    }

    @Override
    @Transactional
    public void deletePassword(int id) {
        entityManager.remove(entityManager.find(Passwords.class,id));
    }

    @Override
    public void deleteByName(String name) {
        TypedQuery<Passwords> query = entityManager.createQuery("from Passwords where passwordName=:name",Passwords.class);
        query.setParameter("name",name);
        entityManager.remove(query.getSingleResult());
    }

    @Override
    public List<Passwords> listPasswords() {
        TypedQuery<Passwords> query = entityManager.createQuery("from Passwords",Passwords.class);
        return query.getResultList();
    }

}
