package com.example.sourcesoffuelresourceapplication.controller;

import com.example.sourcesoffuelresourceapplication.model.User;
import com.example.sourcesoffuelresourceapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {
        userService.save(user);
        RedirectView  redirectView= new RedirectView("/login",true);
        redir.addFlashAttribute("message", "You successfully registered! You can now login");
        return redirectView;
    }
}
