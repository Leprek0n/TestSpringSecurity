package com.security.org.dao;

import com.security.org.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getCustomerList() {
        List<User> resultList = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return resultList;
    }


    @Override
    @Transactional
    public void save(User user) {

        User managed = entityManager.merge(user);
        entityManager.persist(managed);
    }

    @Override
    public User showById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void update(User user, Long id) {
        User user1 = entityManager.find(User.class, id);
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        entityManager.merge(user1);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user1 = entityManager.find(User.class, id);
        entityManager.remove(user1);
    }

    @Override
    public User getUserByName(String name) {
        User user = entityManager.createQuery("Select u From User u where u.username = :username", User.class)
                .setParameter("username", name)
                .getSingleResult();
        return user;
    }
}
