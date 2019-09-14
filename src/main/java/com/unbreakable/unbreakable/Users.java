package com.unbreakable.unbreakable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
    private Integer pushup;
    private Integer pullup;
    private Integer handstandhold;
    private Integer handstandpushup;
    private Integer frontlever;
    private Integer backlever;


    public Users(){

    }

    public Users(String username, String password){
        this.username=username;
        this.password=password;
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
}
