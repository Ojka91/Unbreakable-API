package com.unbreakable.unbreakable.persistance;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Activities {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "users")
    private Users users;

    @OneToMany(mappedBy = "activity")
    private Set<Calendar> calendars;

    private String name;

    private String description;

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
    public Activities(Users users, String name, String description) {
        this.users = users;
        this.name = name;
        this.description = description;
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
}
