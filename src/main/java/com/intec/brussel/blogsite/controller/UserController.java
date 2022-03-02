package com.intec.brussel.blogsite.controller;

import com.intec.brussel.blogsite.model.User;
import com.intec.brussel.blogsite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Principal principal) {
        // Just curious  what if we get username from Principal instead of SecurityContext
        if (principal != null) {
            return "redirect:/";
            // if user already logged in redirect back to root context
        } else {

            return "login";
        }
    }

    @GetMapping("/signup")
    public String getRegisterForm(Model model) {
        // create new BlogUser instance and pass it to registerForm view template
        User user = new User();
        model.addAttribute("blogUser", user);
        return "registerForm";
    }
    @PostMapping("/register")
    public String saveEmployee(@ModelAttribute("user")User user){
        //save user to database
        userService.saveNewUser(user);
        return "redirect:/";
    }

}
