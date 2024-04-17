package com.DEVLooping.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.DEVLooping.cruddemo.entity.User;

import java.util.List;

@Repository
public class UserDAOJpaImpl implements UserDAO {

    // definir campo para entityManager

    private EntityManager entityManager;

    // asignar inyeccion de constructor

    public UserDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {

        // crear una consulta
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User", User.class);

        // ejecutar la consulta y obtener resultados
        List<User> users = theQuery.getResultList();


        return users;
    }

    @Override
    public User findById(int theId) {

        User user = entityManager.find(User.class, theId);
        return user;
    }

    @Override
    public User save(User theUser) {

        User dbUser = entityManager.merge(theUser);

        return dbUser;
    }

    @Override
    public void deleteById(int theId) {

        User dbUser = entityManager.find(User.class, theId);

        entityManager.remove(dbUser);

    }
}
