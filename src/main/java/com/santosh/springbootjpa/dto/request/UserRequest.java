package com.santosh.springbootjpa.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequest {
    private int id;
    private String username;
    private String password;
    private String name;
    private int departmentId;
}
