package com.security.org.service;

import com.security.org.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getCustomerList();
    public boolean save(User user);
    public User showById(Long id);
    public void update(User user, Long id);
    public void delete( Long id);
}
