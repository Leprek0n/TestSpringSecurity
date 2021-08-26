package com.security.org.dao;

import com.security.org.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getCustomerList();

    public void save(User user);

    public User showById(Long id);

    public void update(User user, Long id);

    public void delete(Long id);

    public User getUserByName(String name);
}
