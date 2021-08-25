package com.security.org.service;

import com.security.org.dao.UserDao;
import com.security.org.entity.Role;
import com.security.org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    

    public List<User> getCustomerList() {
        return userDao.getCustomerList();
    }



    public boolean save(User user) {
        System.out.println("service");
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
       userDao.save(user);
        return true;
    }


    public User showById(Long id) {
        return userDao.showById(id);
    }


    public void update(User user, Long id) {
        userDao.update(user, id);
    }


    public void delete( Long id) {
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
        return user;
    }

}
