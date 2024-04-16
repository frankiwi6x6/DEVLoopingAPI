package com.DEVLooping.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.DEVLooping.cruddemo.entity.Post;

import java.util.List;

@Repository
public class PostDAOJpaImpl implements PostDAO {

    // definir campo para entityManager

    private EntityManager entityManager;

    // asignar inyeccion de constructor

    public PostDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Post> findAll() {

        // crear una consulta
        TypedQuery<Post> theQuery = entityManager.createQuery("FROM Post", Post.class);

        // ejecutar la consulta y obtener resultados
        List<Post> posts = theQuery.getResultList();

        // retornar resultados

        return posts;
    }

    @Override
    public Post findById(int theId) {

        Post post = entityManager.find(Post.class, theId);
        return post;
    }

    @Override
    public Post save(Post thePost) {

        Post dbPost = entityManager.merge(thePost);

        return dbPost;
    }

    @Override
    public void deleteById(int theId) {

        Post dbPost = entityManager.find(Post.class, theId);

        entityManager.remove(dbPost);

    }
}
