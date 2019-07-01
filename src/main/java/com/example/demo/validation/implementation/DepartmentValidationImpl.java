package com.example.demo.validation.implementation;

import com.example.demo.dao.model.Department;
import com.example.demo.dao.repository.DepartmentRepository;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.exception.JsonException;
import com.example.demo.validation.DepartmentValidation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("departmentValidation")
public class DepartmentValidationImpl implements DepartmentValidation {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void createDepartmentParams(List<Department> departments) throws JsonException {
        if (departments == null || departments.isEmpty()){
            throw new JsonException();
        }

        for (Department department : departments){
            if (department.getDept_id() != 0){
                throw new JsonException();
            }
        }
    }

    @Override
    public void validateGetParams(String id) throws DepartmentNotFoundException {
        if (!StringUtils.isNumeric(id)){
            throw new DepartmentNotFoundException();
        }
        else {
            Optional<Department> department = departmentRepository.findById(Integer.valueOf(id));
            if (!department.isPresent()) {
                throw new DepartmentNotFoundException();
            }
        }
    }

    @Override
    public void updateDepartmentParams(List<DepartmentDto> departmentDtoList) throws JsonException {
        for (DepartmentDto departmentDto : departmentDtoList){
            if (departmentDto.getDept_id() != 0){
                throw new JsonException();
            }

            if (departmentDto.getId() == 0){
                throw new JsonException();
            }
        }
    }
}
