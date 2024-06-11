package com.example.ioc.service;

import com.example.ioc.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> getAll(){
        User user = new User();
        user.setAge(7L);
        user.setName("Mubeen");
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }
}
