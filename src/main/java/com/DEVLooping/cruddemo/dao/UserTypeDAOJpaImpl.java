package com.DEVLooping.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.DEVLooping.cruddemo.entity.UserType;

import java.util.List;

@Repository
public class UserTypeDAOJpaImpl implements UserTypeDAO {

    // definir campo para entityManager

    private EntityManager entityManager;

    // asignar inyeccion de constructor

    public UserTypeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<UserType> findAll() {

        // crear una consulta
        TypedQuery<UserType> theQuery = entityManager.createQuery("FROM user_type", UserType.class);

        // ejecutar la consulta y obtener resultados
        List<UserType> userTypes = theQuery.getResultList();


        return userTypes;
    }

    @Override
    public UserType findById(int theId) {

        UserType userType = entityManager.find(UserType.class, theId);
        return userType;
    }

    @Override
    public UserType save(UserType theUserType) {

        UserType dbUserType = entityManager.merge(theUserType);

        return dbUserType;
    }

    @Override
    public void deleteById(int theId) {

        UserType dbUserType = entityManager.find(UserType.class, theId);

        entityManager.remove(dbUserType);

    }
}
