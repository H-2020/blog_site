package com.intec.brussel.blogsite.repository;

import com.intec.brussel.blogsite.model.Post;
import com.intec.brussel.blogsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


    List<User> findAllByFirstNameIsLikeOrLastNameIsLike(String firstName, String lastName);
    User findByFirstNameAndPassword(String firstName, String password);


}
