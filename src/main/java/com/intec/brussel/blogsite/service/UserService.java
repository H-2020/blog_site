package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.User;

import java.util.List;

public interface UserService {


    List<User> getAll();

    User getUserById(Long id);

    void saveNewUser(User user);

    void deactivateUser(Long id);


    User getUserByUserNameAndPassword(String userName, String password);
}
