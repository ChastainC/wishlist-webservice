package com.example.demo.service.implementation;

import com.example.demo.dao.model.Department;
import com.example.demo.dao.repository.DepartmentRepository;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.DepartmentBusinessService;
import com.example.demo.util.SortByDeptId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentBusinessServiceImpl implements DepartmentBusinessService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void add(List<Department> departments) {
        List<Department> departmentFromDb = (List<Department>)departmentRepository.findAll();
        departmentFromDb.sort(new SortByDeptId());
        departments.forEach(department -> {
            department.setDept_id(departmentFromDb.get(0).getDept_id()+1);
        });
        departmentRepository.saveAll(departments);
    }

    @Override
    public DepartmentDto get(int id) {
        Optional<Department> optional = departmentRepository.findById(id);
        return departmentMapper.convertDepartmentToDto(optional.get());
    }

    @Override
    public void update(List<DepartmentDto> departmentDtoList) throws DepartmentNotFoundException {
        for (DepartmentDto departmentDto : departmentDtoList){
            Optional<Department> department = departmentRepository.findById(departmentDto.getId());
            if (!department.isPresent()){
                throw new DepartmentNotFoundException();
            }

            else {
                department.get().setName(departmentDto.getName());
                departmentRepository.save(department.get());
            }
        }
    }

    @Override
    public List<Department> getAll() {
        return (List<Department>)departmentRepository.findAll();
    }
}
