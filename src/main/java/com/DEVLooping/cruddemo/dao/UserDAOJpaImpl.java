package com.DEVLooping.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.DEVLooping.cruddemo.entity.User;

import java.util.List;

@Repository
public class UserDAOJpaImpl implements UserDAO {

    private EntityManager entityManager;

    public UserDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User", User.class);
        return theQuery.getResultList();
    }

    @Override
    public User findById(int theId) {
        return entityManager.find(User.class, theId);
    }

    @Override
    public User findByUsername(String theUsername) {
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User WHERE username=:username", User.class);
        theQuery.setParameter("username", theUsername);

        try {
            return theQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User loginUser(String theUsername, String thePassword) {
        TypedQuery<User> theQuery = entityManager
                .createQuery("FROM User WHERE username=:username AND password=:password", User.class);
        theQuery.setParameter("username", theUsername);
        theQuery.setParameter("password", thePassword);

        try {
            return theQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User save(User theUser) {
        return entityManager.merge(theUser);
    }

    @Override
    public void deleteById(int theId) {
        User dbUser = entityManager.find(User.class, theId);
        entityManager.remove(dbUser);
    }
}
