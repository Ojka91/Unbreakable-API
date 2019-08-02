package com.unbreakable.unbreakable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disciplines {

    @Id
    private int id;
    private String name;

    public Disciplines (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
