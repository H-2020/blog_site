package com.intec.brussel.blogsite.controller;

import com.intec.brussel.blogsite.model.User;
import com.intec.brussel.blogsite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/blogsite")
public class UserController {

    private final UserService userService;


    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listUsers",userService.getAll());
        return "index";
    }
    @GetMapping("/showNewUserForm")
    public String showNewEmployeeForm(Model model){
        //create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }
    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("employee") User user){
        //save employee to database
        userService.saveNewUser(user);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model){

        //get employee from the services
        User user =  userService.getUserById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id){
        //call delete employee method
        this.userService.deactivateUser(id);
        return  "redirect:/";
    }




//    @GetMapping("/login")
//    public String login(Principal principal) {
//        // Just curious  what if we get username from Principal instead of SecurityContext
//        if (principal != null) {
//            return "redirect:/";
//            // if user already logged in redirect back to root context
//        } else {
//
//            return "login";
//        }
//    }
//
//    @GetMapping("/signup")
//    public String getRegisterForm(Model model) {
//        // create new BlogUser instance and pass it to registerForm view template
//        User user = new User();
//        model.addAttribute("user", user);
//        return "registration";
//    }
//
//    @PostMapping("/register")
//    public String registerNewUser(@RequestBody User user) {
//        userService.saveNewUser(user);
//        return "redirect:/";
//    }
//
//    @DeleteMapping(path = "{id}")
//    public void deleteStudent(@PathVariable("id") Long id) {
//        userService.deactivateUser(id);
//    }
//
//    @GetMapping("/show")
//    public String showRegistrationForm() {
//        return "registration";
//
//    }
//
//    @ModelAttribute("user")
//    public User user(){
//        return new User();
//    }
}
