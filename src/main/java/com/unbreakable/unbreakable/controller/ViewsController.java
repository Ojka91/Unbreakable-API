package com.unbreakable.unbreakable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewsController {

    @RequestMapping("/test")
    public String menu(){
        return "menu.html";
    }

    @RequestMapping("")
    public String index() {
        return "index.html";
    }
}
