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

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @PostMapping("/registration")
    public String createNewUser(@ModelAttribute ("signupform") User user) {
        System.out.println(user);
        this.userService.saveNewUser(user);
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new User());

        return "redirect:/users/login";
    }

    @PostMapping("/login")
    public String registration(@ModelAttribute("signupform") User userForm, HttpSession httpSession) {

        User foundUser = userService.getUserByUserNameAndPassword(userForm.getUserName(), userForm.getPassword());

        if(foundUser==null){            System.out.println("no valid stuff");
            return "sign-up";
        }
        else {
            System.out.println("welcome");
            httpSession.setAttribute("loggedInUser", userForm.getUserName());
            return "profile";
        }

    }



    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model){

        User user= userService.getUserById(id);

        model.addAttribute("editform", user);

        return "profile";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable(value="id") Long id) {
        User user= userService.getUserById(id);

            this.userService.deactivateUser(id);

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


    
    @PostMapping("logout")
    public String logout(HttpSession httpSession){
        httpSession.setAttribute("loggedInUser", null);
        return "redirect:/";
    }



}
