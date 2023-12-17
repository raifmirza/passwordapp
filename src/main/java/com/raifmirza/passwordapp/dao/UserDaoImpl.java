package com.raifmirza.passwordapp.dao;

import com.raifmirza.passwordapp.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;
    @Autowired
    public UserDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(User theUser) {
        entityManager.merge(theUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class,id));
    }

    @Override
    public User findByUserName(String userName) {
        TypedQuery<User> query = entityManager.createQuery("from User where userName=:username", User.class);
        query.setParameter("username",userName);
        User theUser = null;
        try {
            theUser = query.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> findUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User",User.class);
        return query.getResultList();
    }
}
