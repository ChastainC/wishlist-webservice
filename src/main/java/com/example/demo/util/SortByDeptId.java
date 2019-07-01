package com.example.demo.util;

import com.example.demo.dao.model.Department;

import java.util.Comparator;

public class SortByDeptId implements Comparator<Department> {

    @Override
    public int compare(Department o1, Department o2) {
        return o2.getDept_id() - o1.getDept_id();
    }
}
