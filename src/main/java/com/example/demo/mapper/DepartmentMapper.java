package com.example.demo.mapper;

import com.example.demo.dao.model.Department;
import com.example.demo.dto.DepartmentDto;
import org.springframework.stereotype.Component;

@Component("departmentMapper")
public class DepartmentMapper {

    public DepartmentDto convertDepartmentToDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDept_id(department.getDept_id());
        departmentDto.setName(department.getName());
        return departmentDto;
    }
}
