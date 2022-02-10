package com.santosh.springbootjpa.service;

import com.santosh.springbootjpa.dto.request.ProjectRequest;
import com.santosh.springbootjpa.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectResponse> getAllProjects();

    boolean addProject(ProjectRequest projectRequest);
}
