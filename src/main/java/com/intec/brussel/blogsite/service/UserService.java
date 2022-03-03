package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.User;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Service
public interface UserService {

//    Optional<User> findByUsername(String username);
//    User getUserById(Long id);
  List<User> getAll();
    Optional<User> getUserById(Long id);
    void saveNewUser(User user) ;
    void deactivateUser(Long id);
    void search(Long id);

}
