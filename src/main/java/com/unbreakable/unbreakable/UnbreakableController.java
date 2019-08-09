package com.unbreakable.unbreakable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UnbreakableController {

    @Autowired
    Exercices_CalisthenicsRepository exercices_calisthenicsRepository;

    @Autowired
    Exercises_AthleticsRepository exercises_athleticsRepository;

    @Autowired
    Exercises_ParkourRepository exercises_parkourRepository;
    
    @Autowired
    private UnbreakableService unbreakableService;

    @Autowired
    DisciplinesRepository disciplinesRepository;

    @Autowired
    ElementsRepository elementsRepository;




    @RequestMapping("/{discipline}")
    public List getExercices(@PathVariable String discipline) {
       if(discipline.equals("calisthenics")) {
        return exercices_calisthenicsRepository.findAll();
       }
        if(discipline.equals("athletics")) {
            return exercises_athleticsRepository.findAll();
        }
        if(discipline.equals("parkour")){
            return exercises_parkourRepository.findAll();
        }
           return null;
    }

    @RequestMapping("/{discipline}/group/{group}")
    public List getExercicesGroup(@PathVariable String group, @PathVariable String discipline) {
        if(discipline.equals("calisthenics")){
        return exercices_calisthenicsRepository.findAll()
                .stream()
                .filter(el->el.getGroup().equals(group))
                .collect(Collectors.toList());
        }
        if(discipline.equals("athletics")){
            return exercises_athleticsRepository.findAll()
                    .stream()
                    .filter(el->el.getGroup().equals(group))
                    .collect(Collectors.toList());
        }
        if(discipline.equals("parkour")){
            return exercises_parkourRepository.findAll()
                    .stream()
                    .filter(el->el.getGroup().equals(group))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @RequestMapping("/calisthenics/level/{lvl}")
    public List getExercicesLevel(@PathVariable String lvl){
        final int diff;
        if (lvl.equals("beginner")){
            diff = 0;
            return exercices_calisthenicsRepository.findAll()
                    .stream()
                    .filter(el->el.getLevel()==diff || el.getLevel() == diff+1)
                    .collect(Collectors.toList());
        }
        if (lvl.equals("advanced")){
            diff = 3;
            return exercices_calisthenicsRepository.findAll()
                    .stream()
                    .filter(el->el.getLevel()==diff || el.getLevel() == diff+1 || el.getLevel() == diff-1)
                    .collect(Collectors.toList());
        }
        if(lvl.equals("master")){
            diff = 6;
            return exercices_calisthenicsRepository.findAll()
                    .stream()
                    .filter(el->el.getLevel()==diff || el.getLevel() == diff-1)
                    .collect(Collectors.toList());
        }

        return exercices_calisthenicsRepository.findAll();

    }


    @RequestMapping("/{discipline}/{group}/{level}")
    public List getEx(@PathVariable String discipline, @PathVariable List<String> group, @PathVariable List<Integer> level){
        return unbreakableService.getExercices(discipline, group, level);
    }

    @RequestMapping("/disciplines")
    public List getDisciplines(){
        return disciplinesRepository.findAll();
    }

    @RequestMapping("/elements")
    public List getElements(){
        return elementsRepository.findAll();
    }

}
