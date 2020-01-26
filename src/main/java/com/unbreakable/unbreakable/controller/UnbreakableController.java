package com.unbreakable.unbreakable.controller;

import com.unbreakable.unbreakable.persistance.Activities;
import com.unbreakable.unbreakable.persistance.repositories.ActivitiesRespository;
import com.unbreakable.unbreakable.persistance.repositories.UsersRepository;
import com.unbreakable.unbreakable.service.UnbreakableService;
import com.unbreakable.unbreakable.persistance.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UnbreakableController {

    @Autowired
    private UnbreakableService unbreakableService;

    //test api connection
    @RequestMapping("")
    public String apiOk(){
        return "Ok";
    }

    //return list of discipline exercices
    @RequestMapping("/{discipline}")
    public List getDiscipline(@PathVariable String discipline) {
       return unbreakableService.getDiscipline(discipline);
    }


    //return list of exercices filtereds
    @RequestMapping("/{discipline}/{group}/{level}")
    public List getEx(@PathVariable String discipline, @PathVariable List<String> group, @PathVariable List<Integer> level){
        return unbreakableService.getExercices(discipline, group, level);
    }

    //return list of different disciplines name
    @RequestMapping("/disciplines")
    public List getDisciplines(){
        return unbreakableService.getDisciplines();
    }

    //return routine with 5 exercices
    @RequestMapping("/getRoutine/{discipline}/{group}/{level}")
    public List getRoutine(@PathVariable String discipline, @PathVariable List<String> group, @PathVariable List<Integer> level){
        return unbreakableService.getRoutine(discipline, group, level);
    }

    //return list of elements
    @RequestMapping("/elements")
    public List getElements(){
        return unbreakableService.getElements();
    }

    //create user method (name, password)
    @RequestMapping(path = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody Users users){
        return unbreakableService.createUser(users);
    }

    //get list of users
    @RequestMapping("/users")
    public List getUsers(){
       return unbreakableService.getUsers();
    }

    //get user info
    @RequestMapping("/users/{userName}")
    public Map<String, Object> getUser(@PathVariable String userName){
        return unbreakableService.getUserInfo(userName);
    }

    //update user info
    @RequestMapping(path = "/users/{userName}", method = RequestMethod.POST)
    public ResponseEntity<Object> updateProfile(@PathVariable String userName, @RequestParam Integer pushUp, @RequestParam
            Integer pullUp, @RequestParam Integer hsHold, @RequestParam Integer hsPushUp, @RequestParam Integer frontLever,
                                                @RequestParam Integer backLever, Authentication authentication){
        return unbreakableService.updateUserInfo(userName, pushUp, pullUp, hsHold, hsPushUp, frontLever, backLever, authentication);
    }

    //delete user
    @RequestMapping(path = "/deleteUser", method = RequestMethod.POST)
    public ResponseEntity<Object> deleteUser(@RequestBody Users users){
        return unbreakableService.deleteUser(users);
    }


    @RequestMapping("/getActivities")
    public Set<Activities> getActivities(Authentication authentication){
        return unbreakableService.getActivities(authentication);
    }

    @RequestMapping(path = "/addActivity", method = RequestMethod.POST)
    public ResponseEntity<Object> addActivity(@RequestBody String nameActivity, String description, Authentication authentication){
        return unbreakableService.addActivity(nameActivity, description, authentication);
    }
}
