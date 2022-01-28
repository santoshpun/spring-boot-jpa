package com.santosh.springbootjpa.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private int id;
    private String username;
    private String password;
    private String name;
    private int departmentId;
}
