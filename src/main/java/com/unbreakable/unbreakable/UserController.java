package com.unbreakable.unbreakable;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserTestRepository userTestRepository;



    @RequestMapping("/users")
    public List getUsers(){
        return userTestRepository.findAll();
    }


}
