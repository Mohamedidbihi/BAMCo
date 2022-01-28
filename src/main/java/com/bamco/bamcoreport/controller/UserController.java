package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.request.UserRequest;
import com.bamco.bamcoreport.response.UserResponse;
import com.bamco.bamcoreport.service.UserSevice;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping({"/users"})
public class UserController {
    @Autowired
    UserSevice userService;
    public UserController() {
    }

    @GetMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        UserDto userDto = this.userService.getUserById(id);
        ModelMapper modelMapper = new ModelMapper();
        UserResponse userResponse = (UserResponse)modelMapper.map(userDto, UserResponse.class);
        return new ResponseEntity(userResponse, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDto = userService.getAllUsers();
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserResponse userRequest) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userDto = (UserEntity)modelMapper.map(userRequest, UserEntity.class);
        UserEntity createUser = this.userService.createUser(userDto);
        UserResponse userRes = (UserResponse)modelMapper.map(createUser, UserResponse.class);
        return new ResponseEntity(userRes, HttpStatus.CREATED);
    }

    @PatchMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);
        UserDto updateUser = this.userService.updateUser(id, userDto);
        UserResponse userRes = new UserResponse();
        BeanUtils.copyProperties(updateUser, userRes);
        return new ResponseEntity(userRes, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}