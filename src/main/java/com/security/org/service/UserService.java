package com.security.org.service;

import com.security.org.UserRegistrationDto.UserRegDto;
import com.security.org.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getCustomerList();
    public void save(UserRegDto user);
    public User showById(int id);
    public void update(User user, int id);
    public void delete( int id);
}
