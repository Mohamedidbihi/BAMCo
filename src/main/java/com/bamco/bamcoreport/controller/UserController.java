package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.service.UserSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto userDto = this.userService.getUserById(id);
        ModelMapper modelMapper = new ModelMapper();
       // UserResponse userResponse = (UserResponse)modelMapper.map(userDto, UserResponse.class);
        return new ResponseEntity(userDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDto = userService.getAllUsers();
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userRequest) throws Exception {

        UserDto createUser = this.userService.createUser(userRequest);
        return new ResponseEntity(createUser, HttpStatus.CREATED);

    }

    @PatchMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userRequest) {

        UserDto updateUser = this.userService.updateUser(id, userRequest);
        return new ResponseEntity(updateUser, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
