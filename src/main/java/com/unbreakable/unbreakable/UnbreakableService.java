package com.unbreakable.unbreakable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnbreakableService {

    @Autowired
    Exercices_CalisthenicsRepository exercices_calisthenicsRepository;

    @Autowired
    Exercises_AthleticsRepository exercises_athleticsRepository;

    @Autowired
    Exercises_ParkourRepository exercises_parkourRepository;



    public List getExercices(String discipline, List<String> group, List<Integer> level){
        if(discipline.equals("calisthenics")){
            if(!group.equals("all")){

                return exercices_calisthenicsRepository.findAll()
                        .stream()
                        .filter(el->group.contains(el.getGroup()) && level.contains(el.getLevel()))
                        .collect(Collectors.toList());
            } else{
                return exercices_calisthenicsRepository.findAll()
                        .stream()
                        .filter(el->level.contains(el.getLevel()))
                        .collect(Collectors.toList());
            }
        }
        if(discipline.equals("athletics")){
            return exercises_athleticsRepository.findAll()
                    .stream()
                    .filter(el->group.contains(el.getGroup()))
                    .collect(Collectors.toList());

        }
        if(discipline.equals("parkour")){
            if(!group.equals("all")){

                return exercises_parkourRepository.findAll()
                        .stream()
                        .filter(el->group.contains(el.getGroup()) && level.contains(el.getLevel()))
                        .collect(Collectors.toList());
            } else{
                return exercises_parkourRepository.findAll()
                        .stream()
                        .filter(el->level.contains(el.getLevel()))
                        .collect(Collectors.toList());
            }
        }

        return null;
    }
}
