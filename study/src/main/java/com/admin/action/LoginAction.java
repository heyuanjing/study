package com.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.entity.User;
import com.admin.service.UserService;

@Controller
public class LoginAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.html")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    @RequestMapping("/schema.html")
    public String schema(HttpServletRequest request, HttpServletResponse response, Model model) {
        User user = userService.getUserById(1);
        System.out.println(user.getUser_name());
        return "schema";
    }
}
