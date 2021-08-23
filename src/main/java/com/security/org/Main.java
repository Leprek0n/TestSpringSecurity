package com.security.org;

import com.security.org.dao.UserDao;
import com.security.org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

public class Main {
    @Autowired
    private static UserDao userDetailsService;
    public static void main(String[] args) {
        User user = userDetailsService.showById(1);
        System.out.println(user.getUsername());
    }
}
