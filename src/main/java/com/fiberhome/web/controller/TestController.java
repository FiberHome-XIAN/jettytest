package com.fiberhome.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @RequestMapping( "/index" )
    public String index(){
        return "index";
    }
}
