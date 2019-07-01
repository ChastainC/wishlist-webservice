package com.example.demo.dao.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Department extends BaseEntity implements Serializable {

    private int dept_id;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
}
