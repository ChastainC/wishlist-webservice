package com.example.demo.dao.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Status extends BaseEntity implements Serializable {

    private int status_id;

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}
