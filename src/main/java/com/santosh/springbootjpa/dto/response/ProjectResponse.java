package com.santosh.springbootjpa.dto.response;

import com.santosh.springbootjpa.model.ProjectType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    private int id;
    private String code;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private UserResponse owner;
    private ProjectType projectType;
    private int percentageComplete;
}
