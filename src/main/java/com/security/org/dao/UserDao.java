package com.security.org.dao;

import com.security.org.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getCustomerList();
    public void save(User user);
    public User showById(int id);
    public void update(User user, int id);
    public void delete( int id);
    public User getUserByName(String name);
}
