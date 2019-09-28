package com.unbreakable.unbreakable.persistance;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Elements {

    @Id
    private int id;
    private String name;
    private String sphere;
    private String description;

    public Elements(){

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

    public String getSphere() {
        return sphere;
    }

    public void setSphere(String sphere) {
        this.sphere = sphere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
