package com.example.demo.dao.repository;

import com.example.demo.dao.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
