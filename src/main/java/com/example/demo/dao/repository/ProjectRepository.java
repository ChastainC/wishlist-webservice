package com.example.demo.dao.repository;

import com.example.demo.dao.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
