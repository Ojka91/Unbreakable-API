package com.unbreakable.unbreakable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UnbreakableController {

    @Autowired
    private UnbreakableService unbreakableService;

    @RequestMapping("")
    public String apiOk(){
        return "Ok";
    }



    @RequestMapping("/{discipline}")
    public List getDiscipline(@PathVariable String discipline) {
       return unbreakableService.getDiscipline(discipline);
    }


    @RequestMapping("/{discipline}/{group}/{level}")
    public List getEx(@PathVariable String discipline, @PathVariable List<String> group, @PathVariable List<Integer> level){
        return unbreakableService.getExercices(discipline, group, level);
    }

    @RequestMapping("/disciplines")
    public List getDisciplines(){

        return unbreakableService.getDisciplines();
    }

    @RequestMapping("/elements")
    public List getElements(){
        return unbreakableService.getElements();
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody Users users){
        return unbreakableService.createUser(users);
    }

    @RequestMapping("/users")
    public List getUsers(){
       return unbreakableService.getUserInfo();
    }
}
