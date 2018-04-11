package com.fiberhome.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorPageController {

    @RequestMapping( value = "404")
    public String error404(){
        return "404";
    }

    @RequestMapping( value = "500")
    public String error500(){
        return "500";
    }
}
