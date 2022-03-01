package com.intec.brussel.blogsite.controller;

import com.intec.brussel.blogsite.model.User;
import com.intec.brussel.blogsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

@Controller
public class SignupController {

    private final UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
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
//    @PostMapping("/register")
//    public String registerNewUser(@Valid @ModelAttribute User user, BindingResult bindingResult, SessionStatus sessionStatus) throws RoleNotFoundException {
//        System.err.println("newUser: " + user);  // for testing debugging purposes
//        // Check if username is available
//        if (userService.findByUsername(user.getFirstName()).isPresent()) {
////            FieldError usernameTakenError = new FieldError("blogUser","username","Username is already registered try other one or go away");
////            bindingResult.addError(usernameTakenError);
//            bindingResult.rejectValue("username", "error.username","Username is already registered try other one or go away");
//            System.err.println("Username already taken error message");
//        }
//        // Validate users fields
//        if (bindingResult.hasErrors()) {
//            System.err.println("New user did not validate");
//            return "registerForm";
//        }
//        // Persist new blog user
//        this.userService.saveNewUser(user);
////        // Create Authentication token and login after registering new blog user
////        Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
////        System.err.println("AuthToken: " + auth);  // for testing debugging purposes
////        SecurityContextHolder.getContext().setAuthentication(auth);
////        System.err.println("SecurityContext Principal: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());  // for testing debugging purposes
////        sessionStatus.setComplete();
//        return "redirect:/";
//    }
}
