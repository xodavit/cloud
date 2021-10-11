package com.example.users.repository;

import com.example.users.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
//@RequiredArgsConstructor
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAll() {
        return entityManager.createQuery("select u from User u order by u.id desc", User.class).getResultList();
    }

    public User getById(long id) {
        return entityManager.find(User.class, id);
    }
}
