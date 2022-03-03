package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.User;
import com.intec.brussel.blogsite.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;



//    @Override
//    public Optional<User> findByUsername(String username) {
//        return userRepo.findByUsername(username);
//    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> optionalUser=userRepo.findById(id);
        User user=null;
        if(optionalUser.isPresent()){
           user=optionalUser.get();
        }else{
            throw new RuntimeException("User not found for id::" +id);
        }
        return Optional.of(user);
    }

    @Override
    public List<User> getAll() {

        return userRepo.findAll();
    }

    @Override
    public void saveNewUser(User user) {

        this.userRepo.save(user);
    }


    @Override
    public void deactivateUser(Long id) {

        this.userRepo.deleteById(id);
    }

    public List<User> search(String firstName, String lastName) {
        return this.userRepo.findAllByFirstNameIsLikeOrLastNameIsLike(firstName,lastName);

    }

    @Override
    public User getUserByFirstNameAndPassword(String firstName, String password){
        return userRepo.findByFirstNameAndPassword(firstName,password);
    }
}
