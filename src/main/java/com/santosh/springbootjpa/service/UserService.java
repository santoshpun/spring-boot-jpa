package com.santosh.springbootjpa.service;


import com.santosh.springbootjpa.dto.request.UserRequest;
import com.santosh.springbootjpa.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    boolean addUser(UserRequest userRequest);

    boolean updateUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUser(int id);

    boolean deleteUser(int id);
}
