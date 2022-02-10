package com.santosh.springbootjpa.builder;

import com.santosh.springbootjpa.dto.request.UserRequest;
import com.santosh.springbootjpa.dto.response.DepartmentResponse;
import com.santosh.springbootjpa.dto.response.UserResponse;
import com.santosh.springbootjpa.model.Department;
import com.santosh.springbootjpa.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class UserBuilder {

    public static User convertToUser(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.getId());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setName(userRequest.getName());
        user.setAddedDate(new Date());
        user.setDepartment(new Department(userRequest.getDepartmentId()));
        return user;
    }

    public static UserResponse convertToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setName(user.getName());

        DepartmentResponse departmentResponse = DepartmentResponse.builder()
                .id(user.getDepartment().getId())
                .name(user.getDepartment().getName())
                .build();

        userResponse.setDepartment(departmentResponse);
        return userResponse;
    }

    public static List<UserResponse> convertToUserResponse(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            userResponses.add(convertToUserResponse(user));
        }
        return userResponses;
    }
}
