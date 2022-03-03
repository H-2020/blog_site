package com.intec.brussel.blogsite.controller;

import com.intec.brussel.blogsite.model.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface IUseController {

    String goToLoginPage(Model model, HttpSession httpSession);
    String login(User userReceived, HttpSession httpSession);
}
