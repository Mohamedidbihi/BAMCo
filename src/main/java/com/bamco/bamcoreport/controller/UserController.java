package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.service.UserSevice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Users", description = "Application users")
@RestController
@RequestMapping({"/users"})
public class UserController {
    @Autowired
    UserSevice userService;
    public UserController() {
    }

    @GetMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Find user by ID",
            notes = "Provide an ID to look a specific user from BAMCo database"
    )
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto userDto = this.userService.getUserById(id);
        ModelMapper modelMapper = new ModelMapper();
        // UserResponse userResponse = (UserResponse)modelMapper.map(userDto, UserResponse.class);
        return new ResponseEntity(userDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    @ApiOperation(
            value = "Get all users",
            notes = "Get all users from BAMCo database"
    )
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDto = userService.getAllUsers();
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    @ApiOperation(
            value = "Create a new user",
            notes = "Create a new user to save to BAMCo database"
    )
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userRequest) throws Exception {

        UserDto createUser = this.userService.createUser(userRequest);
        return new ResponseEntity(createUser, HttpStatus.CREATED);

    }

    @PatchMapping(
            path = {"/{id}"}
    )
    @ApiOperation(
            value = "Update user by ID",
            notes = "Provide an ID to update a specific user from BAMCo database"
    )
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userRequest) {

        UserDto updateUser = this.userService.updateUser(id, userRequest);
        return new ResponseEntity(updateUser, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(
            path = {"/{id}"}
    )
    @ApiOperation(
            value = "Delete user by ID",
            notes = "Provide an ID to delete a specific user from BAMCo database"
    )
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
