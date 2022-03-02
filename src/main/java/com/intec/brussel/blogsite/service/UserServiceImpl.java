package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.User;
import com.intec.brussel.blogsite.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

//    @Override
//    public Optional<User> findByUsername(String username) {
//        return userRepo.findByUsername(username);
//    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optional=userRepo.findById(id);
        User user=null;
        if(optional.isPresent()){
           user=optional.get();
        }else{
            throw new RuntimeException("User not found for id::" +id);
        }
        return user;
    }

    @Override
    public List<User> getAll() {

        return userRepo.findAll();
    }

    @Override
    public User saveNewUser(User user) {

        return this.userRepo.save(user);
    }

    @Override
    public void deactivateUser(Long id) {

        this.userRepo.deleteById(id);
    }

    @Override
    public void search(Long id) {
        this.userRepo.findById(id);

    }
}
