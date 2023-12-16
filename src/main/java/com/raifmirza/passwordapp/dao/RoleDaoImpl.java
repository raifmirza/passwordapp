package com.raifmirza.passwordapp.dao;

import com.raifmirza.passwordapp.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    private EntityManager entityManager;
    @Autowired
    public RoleDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public Role findRoleByName(String roleName) {
        TypedQuery<Role> theQuery = entityManager.createQuery("from Role where name=:roleName", Role.class);
        theQuery.setParameter("roleName",roleName);
        Role theRole = null;
        try {
            theRole = theQuery.getSingleResult();
        }catch (Exception e){
            theRole = null;
        }
        return theRole;
    }
}
