package com.intec.brussel.blogsite.controller;

import com.intec.brussel.blogsite.model.Post;
import com.intec.brussel.blogsite.model.User;
import com.intec.brussel.blogsite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "users")
public class UserController {

    private final UserService userService;






    @PostMapping("/create")
    public String createNewUser(@ModelAttribute User user) {
        this.userService.saveNewUser(user);
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup-form";
    }

    @GetMapping("/update/{id}")
    public String editUser(@PathVariable(value="id") Long id, Model model) {
        Optional<User> optionalUser= userService.getUserById(id);
        if (optionalUser.isPresent()) {
            User user= optionalUser.get();
            model.addAttribute("user", optionalUser);
        }
        return "updateuser";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable(value="id") Long id) {
        Optional<User> optionalUser= userService.getUserById(id);
        if (optionalUser.isPresent()) {
            User user= optionalUser.get();
            this.userService.deactivateUser(id);
        }
        return "redirect:/";
    }



    @GetMapping("login")
    public String goToLoginPage(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("loggedInUser")==null) {
            model.addAttribute("user", new User(" ", " "));
            return "login";
        }
        else
            return "redirect:/";
    }

    @PostMapping("login")
    public String login(@ModelAttribute("user") User userReceived, HttpSession httpSession) {
        System.out.println(userReceived.getUserName());
        System.out.println(userReceived.getPassword());

        User foundUser = userService.getUserByUserNameAndPassword(userReceived.getUserName(), userReceived.getPassword());

        if(foundUser==null){            System.out.println("no valid stuff");
            return "sign-up";
        }
        else {
            System.out.println("welcome");
            httpSession.setAttribute("loggedInUser", userReceived.getUserName());
            return "redirect/";
        }

    }
    @PostMapping("logout")
    public String logout(HttpSession httpSession){
        httpSession.setAttribute("loggedInUser", null);
        return "redirect:login";
    }

}
