package com.unbreakable.unbreakable.persistance;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private Integer pushup;
    private Integer pullup;
    private Integer handstandhold;
    private Integer handstandpushup;
    private Integer frontlever;
    private Integer backlever;

    @OneToMany(mappedBy = "users")
    private Set<Activities> activities;

    @OneToMany(mappedBy = "user")
    private Set<Calendar> calendars;

    public Users(){

    }

    public Users(String username, String password, String email){
        this.username=username;
        this.password=password;
        this.email=email;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPushup() {
        return pushup;
    }

    public void setPushup(Integer pushup) {
        this.pushup = pushup;
    }

    public Integer getPullup() {
        return pullup;
    }

    public void setPullup(Integer pullup) {
        this.pullup = pullup;
    }

    public Integer getHandstandhold() {
        return handstandhold;
    }

    public void setHandstandhold(Integer handstandhold) {
        this.handstandhold = handstandhold;
    }

    public Integer getHandstandpushup() {
        return handstandpushup;
    }

    public void setHandstandpushup(Integer handstandpushup) {
        this.handstandpushup = handstandpushup;
    }

    public Integer getFrontlever() {
        return frontlever;
    }

    public void setFrontlever(Integer frontlever) {
        this.frontlever = frontlever;
    }

    public Integer getBacklever() {
        return backlever;
    }

    public void setBacklever(Integer backlever) {
        this.backlever = backlever;
    }

    public Set<Activities> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activities> activities) {
        this.activities = activities;
    }

    public void addActivity(Activities activity){
        this.activities.add(activity);
    }

    public Set<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(Set<Calendar> calendars) {
        this.calendars = calendars;
    }

    public void addToCalendar(Calendar calendar){
        this.calendars.add(calendar);
    }
}
