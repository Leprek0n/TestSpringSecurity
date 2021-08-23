package com.security.org.service;

import com.security.org.UserRegistrationDto.UserRegDto;
import com.security.org.dao.UserDao;
import com.security.org.entity.Role;
import com.security.org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getCustomerList() {
        return userDao.getCustomerList();
    }



    public void save(UserRegDto user) {
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        userDao.save(user);
    }


    public User showById(int id) {
        return userDao.showById(id);
    }


    public void update(User user, int id) {
        userDao.update(user, id);
    }


    public void delete( int id) {
        userDao.delete(id);
    }


    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userDao.getUserByName(name);
        if(user == null) {
            throw new UsernameNotFoundException("No such user");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rolesToAuthority(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> rolesToAuthority(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getUsername())).collect(Collectors.toList());
    }
}
