package com.unbreakable.unbreakable.persistance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Calendar {

    @Id
    private int id;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name ="id", insertable = false, updatable = false)
    private Activities activity;

    public Calendar(){

    }

    public Calendar(Date date, Users user, Activities activity) {
        this.date = date;
        this.user = user;
        this.activity = activity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
