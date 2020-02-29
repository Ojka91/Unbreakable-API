package com.unbreakable.unbreakable.persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Activities {

    @Id
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "users")
    private Users users;

    @OneToMany(mappedBy = "activity")
    private Set<Calendar> calendars;

    private String name;

    private String description;

    private String color;

    private String textcolor;

    public Activities(){

    }

    public Activities(Users users, String name) {
        this.users = users;
        this.name = name;
    }

    public Activities(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Activities(Users users, String name, String description, String color, String textColor) {
        this.users = users;
        this.name = name;
        this.description = description;
        this.color = color;
        this.textcolor = textColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
