package com.unbreakable.unbreakable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
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
        if(user.getPassword().equals("") || user.getUsername().equals("")){
            return new ResponseEntity<>(makeMap("error","Username and Password are required"), HttpStatus.FORBIDDEN);
        }
            usersRepository.save(new Users(user.getUsername(), user.getPassword()));
            return new ResponseEntity<>(makeMap("correct", "created user: "+ user.getUsername()), HttpStatus.CREATED);
    }

    private Map<String, Object> playersDTO(Users user) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("name", user.getUsername());
        dto.put("PushUps", user.getPushup());
        dto.put("PullUps", user.getPullup());
        dto.put("HandstandHold", user.getHandstandhold());
        dto.put("HandstandPushUp", user.getHandstandpushup());
        dto.put("FrontLever", user.getFrontlever());
        dto.put("BackLever", user.getBacklever());
        return dto;
    }

    public List getUsers(){
        List<Map> info = new ArrayList<>();
        for (Users user:usersRepository.findAll()) {
            info.add(playersDTO(user));
        }
        return info;
    }

    public Map<String, Object> getUserInfo(String userName){
        return playersDTO(usersRepository.findByUsername(userName));
    }

    public ResponseEntity<Object> updateUserInfo(String userName, Integer pushUp, Integer pullUp, Integer hsHold,
                                                 Integer hsPushUp, Integer frontLever, Integer backLever){
        Users user = usersRepository.findByUsername(userName);
        user.setPullup(pullUp);
        user.setBacklever(backLever);
        user.setPushup(pushUp);
        user.setFrontlever(frontLever);
        user.setHandstandhold(hsHold);
        user.setHandstandpushup(hsPushUp);
       usersRepository.save(user);
        return new ResponseEntity<>(makeMap("correct", "Info Updated"), HttpStatus.CREATED);

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
