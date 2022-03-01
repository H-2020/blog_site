package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.User;

import javax.management.relation.RoleNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

//    Optional<User> findByUsername(String username);
    User getUserById(Long id);
    List<User> getAll();
    User saveNewUser(User user) ;
    void deactivateUser(Long id);
    void search(Long id);

}
