package com.example.demo.service;

import com.example.demo.dao.model.Department;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentBusinessService {

    public void add(List<Department> departments);

    public DepartmentDto get(int id);

    public void update(List<DepartmentDto> departmentDtoList) throws DepartmentNotFoundException;

    public List<Department> getAll();
}
