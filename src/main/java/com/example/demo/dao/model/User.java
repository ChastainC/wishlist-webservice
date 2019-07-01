package com.example.demo.dao.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class User extends BaseEntity implements Serializable {

    private int user_id;
    private String password;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
