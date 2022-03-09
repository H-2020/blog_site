package com.intec.brussel.blogsite.service;

import com.intec.brussel.blogsite.model.Role;
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
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new RuntimeException("User not found for id::" + id);
        }
        return user;
    }

    @Override
    public List<User> getAll() {

        return userRepo.findAll();
    }

    @Override
    public void saveNewUser(User user) {
        user.setRole(Role.USER);
        this.userRepo.save(user);
    }


    @Override
    public void deactivateUser(Long id) {

        this.userRepo.deleteById(id);
    }

    public List<User> search(String userName, String email) {
        return this.userRepo.findAllByUserNameIsLikeOrEmailIsLike(userName, email);

    }

    @Override
    public User getUserByUserNameAndPassword(String userName, String password) {
        return userRepo.findByUserNameAndPassword(userName, password);
    }
}
