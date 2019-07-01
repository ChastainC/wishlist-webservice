package com.example.demo.validation;

import com.example.demo.dao.model.Department;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.exception.JsonException;

import java.util.List;

public interface DepartmentValidation {

    public void createDepartmentParams(List<Department> departments) throws JsonException;

    public void validateGetParams(String id) throws DepartmentNotFoundException;

    public void updateDepartmentParams(List<DepartmentDto> departmentDtoList) throws JsonException;
}
