package com.intec.brussel.blogsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class NavigationController {

    @GetMapping("/")
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

    @GetMapping("/blog")
    public String getBlog(Model model){
        model.addAttribute("activePage", "blog");
        return "blog";
    }
    @GetMapping("/team")
    public String getTeam(Model model){
        model.addAttribute("activePage", "team");
        return "team";
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

    @GetMapping("/write-post")
    public String getCreatePost(Model model){
        model.addAttribute("activePage", "write-post");
        return "write-post";
    }





}
