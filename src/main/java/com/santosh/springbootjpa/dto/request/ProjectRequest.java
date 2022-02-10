package com.santosh.springbootjpa.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProjectRequest {
    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int ownerId;
    private int projectTypeId;
}
