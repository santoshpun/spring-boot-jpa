package com.santosh.springbootjpa.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentRequest {
    private int id;
    private String name;
}
