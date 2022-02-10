package com.santosh.springbootjpa.controller;

import com.santosh.springbootjpa.builder.BaseResponseBuilder;
import com.santosh.springbootjpa.dto.request.ProjectRequest;
import com.santosh.springbootjpa.dto.response.BaseResponse;
import com.santosh.springbootjpa.dto.response.ProjectResponse;
import com.santosh.springbootjpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {

        List<ProjectResponse> projects = projectService.getAllProjects();

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> addProject(@RequestBody ProjectRequest projectRequest) {

        projectService.addProject(projectRequest);

        return new ResponseEntity<>(BaseResponseBuilder.successResponse("Project added successfully"), HttpStatus.CREATED);
    }
}
