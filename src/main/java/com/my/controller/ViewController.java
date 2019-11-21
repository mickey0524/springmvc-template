package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class ViewController {

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/hello";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
