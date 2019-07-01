package com.example.demo.rest;

import com.example.demo.dao.model.Department;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.exception.JsonException;
import com.example.demo.service.DepartmentBusinessService;
import com.example.demo.validation.DepartmentValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/api")
public class DepartmentRestService {

    @Autowired
    private DepartmentBusinessService departmentBusinessService;

    @Autowired
    private DepartmentValidation departmentValidation;

    @PostMapping(consumes = "application/json")
    public ResponseEntity add(@RequestBody List<Department> departments) throws JsonException {
        departmentValidation.createDepartmentParams(departments);
        departmentBusinessService.add(departments);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json", path = "/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable String id) throws DepartmentNotFoundException {
        departmentValidation.validateGetParams(id);
        DepartmentDto departmentDto = departmentBusinessService.get(Integer.valueOf(id));
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Department> getAllDepartments() {
        List<Department> departments = departmentBusinessService.getAll();
        return new ResponseEntity(departments, HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity update(@RequestBody List<DepartmentDto> departmentDtoList) throws JsonException, DepartmentNotFoundException {
        departmentValidation.updateDepartmentParams(departmentDtoList);
        departmentBusinessService.update(departmentDtoList);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
