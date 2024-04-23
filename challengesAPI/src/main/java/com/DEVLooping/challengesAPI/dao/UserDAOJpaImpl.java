package com.DEVLooping.challengesAPI.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.DEVLooping.challengesAPI.entity.User;
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
    public User findByEmail(String theEmail) {
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User WHERE email=:email", User.class);
        theQuery.setParameter("email", theEmail);

        try {
            return theQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User loginUser(String theEmail, String thePassword) {
        // Encriptar la contraseña antes de compararla con la base de datos
        TypedQuery<User> theQuery = entityManager
                .createQuery("FROM User WHERE email=:email AND password=:password AND status='active'", User.class);
        theQuery.setParameter("email", theEmail);
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
