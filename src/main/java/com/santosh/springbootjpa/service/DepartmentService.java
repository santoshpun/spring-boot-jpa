package com.santosh.springbootjpa.service;


import com.santosh.springbootjpa.dto.request.DepartmentRequest;
import com.santosh.springbootjpa.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    boolean saveDepartment(DepartmentRequest createDepartmentRequest);

    boolean updateDepartment(DepartmentRequest createDepartmentRequest);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartment(int id);

    boolean deleteDepartment(int id);
}
