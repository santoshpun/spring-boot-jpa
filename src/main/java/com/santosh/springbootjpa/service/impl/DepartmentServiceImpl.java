package com.santosh.springbootjpa.service.impl;


import com.santosh.springbootjpa.builder.DepartmentBuilder;
import com.santosh.springbootjpa.dto.request.DepartmentRequest;
import com.santosh.springbootjpa.dto.response.DepartmentResponse;
import com.santosh.springbootjpa.model.Department;
import com.santosh.springbootjpa.repository.DepartmentRepository;
import com.santosh.springbootjpa.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public boolean saveDepartment(DepartmentRequest departmentRequest) {
        Department department = DepartmentBuilder.convertToDepartment(departmentRequest);

        departmentRepository.save(department);

        return true;
    }

    @Override
    public boolean updateDepartment(DepartmentRequest departmentRequest) {
        Department department = DepartmentBuilder.convertToDepartment(departmentRequest);

        departmentRepository.save(department);

        return true;
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return DepartmentBuilder.convertToDepartmentResponse(departments);
    }

    @Override
    public DepartmentResponse getDepartment(int id) {
        Department department = departmentRepository.findById(id).get();
        return DepartmentBuilder.convertToDepartmentResponse(department);
    }

    @Override
    public boolean deleteDepartment(int id) {

        departmentRepository.deleteById(id);

        return true;
    }
}
