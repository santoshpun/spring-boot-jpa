package com.santosh.springbootjpa.service.impl;

import com.santosh.springbootjpa.builder.UserBuilder;
import com.santosh.springbootjpa.dto.request.UserRequest;
import com.santosh.springbootjpa.dto.response.UserResponse;
import com.santosh.springbootjpa.model.User;
import com.santosh.springbootjpa.repository.UserRepository;
import com.santosh.springbootjpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean addUser(UserRequest userRequest) {
        User user = UserBuilder.convertToUser(userRequest);

        userRepository.save(user);

        return true;
    }

    @Override
    public boolean updateUser(UserRequest userRequest) {
        User user = UserBuilder.convertToUser(userRequest);

        userRepository.save(user);

        return true;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserBuilder.convertToUserResponse(users);
    }

    @Override
    public UserResponse getUser(int id) {
        User user = userRepository.findById(id).get();
        return UserBuilder.convertToUserResponse(user);
    }

    @Override
    public boolean deleteUser(int id) {

        userRepository.deleteById(id);

        return true;
    }
}
