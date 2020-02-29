package com.unbreakable.unbreakable.persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Calendar {

    @Id
    private int id;

    private LocalDate date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name ="activity_id")
    private Activities activity;

    private String color;

    private String textcolor;

    public Calendar(){

    }

    public Calendar(LocalDate date, Users user, Activities activity) {
        this.date = date;
        this.user = user;
        this.activity = activity;
        if(!activity.getColor().equals(null)){
            setColor(activity.getColor());
        }
        if(!activity.getTextcolor().equals(null)){
           setTextcolor(activity.getTextcolor());
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Activities getActivity() {
        return activity;
    }

    public void setActivity(Activities activity) {
        this.activity = activity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextcolor() {
        return textcolor;
    }

    public void setTextcolor(String textcolor) {
        this.textcolor = textcolor;
    }
}
