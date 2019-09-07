package com.unbreakable.unbreakable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UnbreakableService {

    @Autowired
    Exercices_CalisthenicsRepository exercices_calisthenicsRepository;

    @Autowired
    Exercises_AthleticsRepository exercises_athleticsRepository;

    @Autowired
    Exercises_ParkourRepository exercises_parkourRepository;

    @Autowired
    DisciplinesRepository disciplinesRepository;

    @Autowired
    ElementsRepository elementsRepository;

    @Autowired
    UsersRepository usersRepository;

    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }



    public ResponseEntity<Object> createUser(Users user){
        if(usersRepository.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<>(makeMap("error", "User Already Exist"), HttpStatus.FORBIDDEN);
        }
            usersRepository.save(new Users(user.getUsername()));
            return new ResponseEntity<>(makeMap("created user", user.getUsername()), HttpStatus.CREATED);
    }

    public List getUsers(){
        return usersRepository.findAll();
    }

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

        return exercices_calisthenicsRepository.findAll();
    }

    public List getDiscipline(String discipline){
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

    public List getDisciplines(){
        return disciplinesRepository.findAll();
    }

    public List getElements(){
        return elementsRepository.findAll();
    }
}
