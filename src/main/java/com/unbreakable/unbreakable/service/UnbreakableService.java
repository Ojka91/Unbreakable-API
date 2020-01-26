package com.unbreakable.unbreakable.service;

import com.unbreakable.unbreakable.persistance.*;
import com.unbreakable.unbreakable.persistance.repositories.*;
import com.unbreakable.unbreakable.security.SecurityConfig;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.undo.AbstractUndoableEdit;
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

    @Autowired
    ActivitiesRespository activitiesRespository;

    @Autowired
    SecurityConfig securityConfig;

    //generic method to return a map
    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    //DTO to show public user info
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


    //create new user (username, password)
    public ResponseEntity<Object> createUser(Users user){
        if(usersRepository.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<>(makeMap("error", "User Already Exist"), HttpStatus.FORBIDDEN);
        }
        if(usersRepository.findByEmail(user.getEmail()) != null){
            return new ResponseEntity<>(makeMap("error", "Email Already Exist"), HttpStatus.FORBIDDEN);
        }
        if(user.getPassword().equals("") || user.getUsername().equals("")){
            return new ResponseEntity<>(makeMap("error","Username and Password are required"), HttpStatus.FORBIDDEN);
        }
            securityConfig.saveNewUser(user.getUsername(), user.getPassword(), user.getEmail());
            return new ResponseEntity<>(makeMap("correct", "created user: "+ user.getUsername()), HttpStatus.CREATED);
    }


    //delete user
    public ResponseEntity<Object> deleteUser(Users users){
        if(users.getPassword().equals(usersRepository.findByUsername(users.getUsername()).getPassword()) ||
        users.getPassword().equals("deleteThisUser")){
            usersRepository.deleteByUsername(users.getUsername());
            return new ResponseEntity<>(makeMap("correct", "user: " + users.getUsername() + " deleted"), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(makeMap("error", "password for: " + users.getUsername() + " is wrong"), HttpStatus.FORBIDDEN);
        }
    }

    //return public users info
    public List getUsers(){
        List<Map> info = new ArrayList<>();
        for (Users user:usersRepository.findAll()) {
            info.add(playersDTO(user));
        }
        return info;
    }

    //return public user info
    public Map<String, Object> getUserInfo(String userName){
        return playersDTO(usersRepository.findByUsername(userName));
    }

    public Users isAuth(Authentication authentication) {
        return usersRepository.findByUsername(authentication.getName());

    }

    //update user info
    public ResponseEntity<Object> updateUserInfo(String userName, Integer pushUp, Integer pullUp, Integer hsHold,
                                                 Integer hsPushUp, Integer frontLever, Integer backLever, Authentication authentication){
        Users user = usersRepository.findByUsername(userName);
        if(isAuth(authentication).getUsername().equals(userName)){
           if(pullUp!=null) user.setPullup(pullUp);
           if(backLever!=null) user.setBacklever(backLever);
           if(pushUp != null) user.setPushup(pushUp);
           if(frontLever != null) user.setFrontlever(frontLever);
           if(hsHold != null) user.setHandstandhold(hsHold);
           if(hsPushUp != null) user.setHandstandpushup(hsPushUp);
            usersRepository.save(user);
            return new ResponseEntity<>(makeMap("correct", "Profile Updated"), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(makeMap("ko", "You are not this user"), HttpStatus.FORBIDDEN);
        }
    }

    //return routine. Not filtered implemented yet, just return randoom exercices for different levels
    public List getRoutine(String discipline, List<String> group, List<Integer> level){
        List exercices = new ArrayList<>();
        List routine = new ArrayList<>();
        exercices = (exercices_calisthenicsRepository.findAll()
                .stream()
                .filter(el->level.contains(el.getLevel()))
                .collect(Collectors.toList()));
        Random rand = new Random();
        int random1 = rand.nextInt(exercices.size());
        int random2 = rand.nextInt(exercices.size());
        int random3 = rand.nextInt(exercices.size());
        int random4 = rand.nextInt(exercices.size());
        int random5 = rand.nextInt(exercices.size());

        routine.add(exercices.get(random1));
        routine.add(exercices.get(random2));
        routine.add(exercices.get(random3));
        routine.add(exercices.get(random4));
        routine.add(exercices.get(random5));

        return routine;
    }



    //return filtered exercices
    public List getExercices(String discipline, List<String> group, List<Integer> level){
        if(discipline.equals("calisthenics")){
            if(!group.contains("all")){
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

    //return discipline info
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

    //return disciplines name
    public List getDisciplines(){
        return disciplinesRepository.findAll();
    }

    //return elements name
    public List getElements(){
        return elementsRepository.findAll();
    }

    public Set<Activities> getActivities(Authentication authentication){
        Users user = isAuth(authentication);
        return user.getActivities();
    }

    public ResponseEntity<Object> addActivity(String name, String description, Authentication authentication) {
        Users users = usersRepository.findByUsername(authentication.getName());
        if (name != null && !name.equals("")) {
            List<String> activitiesName = new ArrayList<>();
            for (Activities activity :
                    users.getActivities()) {
                activitiesName.add(activity.getName().trim().toUpperCase());
            }
            if (!activitiesName.contains(name)) {
                Activities activityToSave = new Activities(users, name, description);
                activitiesRespository.save(activityToSave);
                return new ResponseEntity<>(makeMap("correct", "Activity " + name +
                        " created"), HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(makeMap("KO", "Activity " + name +
                " already exist"), HttpStatus.FORBIDDEN);

    }
}
