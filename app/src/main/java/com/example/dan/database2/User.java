package com.example.dan.database2;

/**
 * Created by Dan on 11/04/2016.
 */
public class User {
    private int id;
    private String name, email;

    public User(String name, String email) {
//        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}