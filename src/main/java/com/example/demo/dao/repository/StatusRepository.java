package com.example.demo.dao.repository;

import com.example.demo.dao.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Integer> {
}
