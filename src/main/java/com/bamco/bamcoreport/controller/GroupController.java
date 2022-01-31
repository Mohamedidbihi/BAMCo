package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.GroupDto;
import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import com.bamco.bamcoreport.service.UserSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/groups"})

public class GroupController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<GroupDto> getGroup(@PathVariable Long id) {
        GroupDto groupDto = this.appService.findGroupById(id);
        return new ResponseEntity(groupDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<GroupDto>> getAllUsers() {
        List<GroupDto> groups = appService.findAllGroups();
        return ResponseEntity.ok(groups);
    }

    @PostMapping
    public ResponseEntity<GroupDto> createUser(@RequestBody GroupDto groupRequest) throws Exception {

        GroupDto createGroup = this.appService.addGroup(groupRequest);
        return new ResponseEntity(createGroup, HttpStatus.CREATED);

    }

    @PatchMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<GroupDto> updateUser(@PathVariable Long id, @RequestBody GroupDto groupDto) {

        GroupDto updateGroup = this.appService.updateGroup(groupDto,id);
        return new ResponseEntity(updateGroup, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        this.appService.deleteGroup(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
