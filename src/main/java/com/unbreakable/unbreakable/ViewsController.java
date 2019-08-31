package com.unbreakable.unbreakable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewsController {

    @RequestMapping("/menu")
    public String menu(){
        return "menu.html";
    }
}
