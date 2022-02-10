package com.santosh.springbootjpa.builder;

import com.santosh.springbootjpa.dto.request.ProjectRequest;
import com.santosh.springbootjpa.dto.response.DepartmentResponse;
import com.santosh.springbootjpa.dto.response.ProjectResponse;
import com.santosh.springbootjpa.dto.response.UserResponse;
import com.santosh.springbootjpa.model.Project;
import com.santosh.springbootjpa.model.ProjectType;
import com.santosh.springbootjpa.model.User;
import com.santosh.springbootjpa.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectBuilder {

    public static Project convertToProject(ProjectRequest projectRequest) {
        Project project = new Project();
        project.setCode(RandomGenerator.randomCharacters());
        project.setName(projectRequest.getName());
        project.setDescription(projectRequest.getDescription());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());
        project.setOwner(new User(projectRequest.getOwnerId()));
        project.setProjectType(new ProjectType(projectRequest.getProjectTypeId()));

        project.setPercentageComplete(0);
        project.setAddedDate(new Date());

        return project;
    }

    public static ProjectResponse convertToProjectResponse(Project project) {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setId(project.getId());
        projectResponse.setName(project.getName());
        projectResponse.setDescription(project.getDescription());
        projectResponse.setStartDate(project.getStartDate());
        projectResponse.setEndDate(project.getEndDate());
        projectResponse.setPercentageComplete(project.getPercentageComplete());

        DepartmentResponse departmentResponse = DepartmentResponse.builder()
                .id(project.getOwner().getDepartment().getId())
                .name(project.getOwner().getDepartment().getName())
                .build();

        UserResponse userResponse = UserResponse.builder()
                .id(project.getOwner().getId())
                .username(project.getOwner().getUsername())
                .name(project.getOwner().getName())
                .department(departmentResponse)
                .build();

        projectResponse.setOwner(userResponse);

        projectResponse.setProjectType(project.getProjectType());

        return projectResponse;
    }

    public static List<ProjectResponse> convertToProjectResponse(List<Project> projects) {
        List<ProjectResponse> projectResponses = new ArrayList<>();

        for (Project project : projects) {
            projectResponses.add(convertToProjectResponse(project));
        }
        return projectResponses;
    }
}
