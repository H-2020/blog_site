package com.intec.brussel.blogsite.controller;

import com.intec.brussel.blogsite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
@Controller
@RequiredArgsConstructor
public class LoginController {

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
}
