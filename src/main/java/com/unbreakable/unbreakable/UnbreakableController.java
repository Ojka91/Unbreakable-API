package com.unbreakable.unbreakable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
