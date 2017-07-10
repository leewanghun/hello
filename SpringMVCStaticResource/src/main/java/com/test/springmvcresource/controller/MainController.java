package com.test.springmvcresource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
 
    @RequestMapping(value = "/staticResourceTest")
    public String staticResource(Model model) {
        return "staticResourceTest";
    }
    
    // Đường dẫn này không còn sử dụng nữa.
    // Nó sẽ bị chuyển hướng bởi OldLoginInterceptor
    @Deprecated
    @RequestMapping(value = { "/admin/oldLogin" })
    public String oldLogin(Model model) {
   
        // Code ở đây không bao giờ được chạy.
   
        return "oldLogin";
    }
   
    @RequestMapping(value = { "/admin/login" })
    public String login(Model model) {
   
        System.out.println("\n-------- MainController.login --- ");
   
        System.out.println(" ** You are in Controller ** ");
   
        return "login";
    }
}