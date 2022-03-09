package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.management.relation.RoleNotFoundException;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> getAll();

    Optional<User> getUserById(Long id);

    void saveNewUser(User user);

    void deactivateUser(Long id);


    User getUserByUserNameAndPassword(String userName, String password);
}
