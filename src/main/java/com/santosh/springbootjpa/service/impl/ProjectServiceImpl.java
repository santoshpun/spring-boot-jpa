package com.santosh.springbootjpa.service.impl;

import com.santosh.springbootjpa.builder.ProjectBuilder;
import com.santosh.springbootjpa.dto.request.ProjectRequest;
import com.santosh.springbootjpa.dto.response.ProjectResponse;
import com.santosh.springbootjpa.model.Project;
import com.santosh.springbootjpa.repository.ProjectRepository;
import com.santosh.springbootjpa.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectResponse> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return ProjectBuilder.convertToProjectResponse(projects);
    }

    @Override
    public boolean addProject(ProjectRequest projectRequest) {
        Project project = ProjectBuilder.convertToProject(projectRequest);

        projectRepository.save(project);

        return true;
    }
}
