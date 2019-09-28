package com.unbreakable.unbreakable.persistance;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exercises_Athletics {

    @Id
    private int id;
    private String group;
    private String variation;
    private int upper_body;
    private int core;
    private int lower_body;

    Exercises_Athletics(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public int getUpper_body() {
        return upper_body;
    }

    public void setUpper_body(int upper_body) {
        this.upper_body = upper_body;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public int getLower_body() {
        return lower_body;
    }

    public void setLower_body(int lower_body) {
        this.lower_body = lower_body;
    }
}
