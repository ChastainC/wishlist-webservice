package com.example.demo.dao.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Project extends BaseEntity implements Serializable {

    private String description;
    private User user;
    private Department department;
    private Integer priority;
    private Integer estimated_hours;
    private Timestamp submit_date;
    private Date development_date;
    private Status status;

    public Project(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEstimated_hours() {
        return estimated_hours;
    }

    public void setEstimated_hours(Integer estimated_hours) {
        this.estimated_hours = estimated_hours;
    }

    public Timestamp getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(Timestamp submit_date) {
        this.submit_date = submit_date;
    }

    public Date getDevelopment_date() {
        return development_date;
    }

    public void setDevelopment_date(Date development_date) {
        this.development_date = development_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
