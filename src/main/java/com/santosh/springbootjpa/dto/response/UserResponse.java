package com.santosh.springbootjpa.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private int id;
    private String username;
    private String name;
    private int departmentId;
}
