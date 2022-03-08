package com.intec.brussel.blogsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class NavigationController {

    @GetMapping("/home")
    public String getInfo(Model model){
        model.addAttribute("activePage", "index");
        return "index";
    }

    @GetMapping("/about")
    public String getAbout(Model model){
        model.addAttribute("activePage", "about");
        return "about";
    }

    @GetMapping("/contact")
    public String getContact(Model model){
        model.addAttribute("activePage", "contact");
        return "contact";
    }

    @GetMapping("/team")
    public String getTeam(Model model){
        model.addAttribute("activePage", "team");
        return "team";
    }

    @GetMapping("/write-post")
    public String getCreatePost(Model model){
        model.addAttribute("activePage", "contact");
        return "write-post";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("activePage", "login");
        return "login";
    }

    @GetMapping("/sign-up")
    public String getSignup(Model model){
        model.addAttribute("activePage", "sign-up");
        return "sign-up";
    }

}
