package com.unbreakable.unbreakable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exercises_Parkour {

    @Id
    private int id;
    private String group;
    private String variation;
    private int level;
    private int freerunning;

    Exercises_Parkour(){

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFreerunning() {
        return freerunning;
    }

    public void setFreerunning(int freerunning) {
        this.freerunning = freerunning;
    }
}
