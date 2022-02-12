package com.santosh.springbootjpa.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class DepartmentRequest {
    private int id;
    private String name;
}
