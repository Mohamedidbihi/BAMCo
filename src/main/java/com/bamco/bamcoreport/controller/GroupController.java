package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.GroupDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
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
    public ResponseEntity<List<GroupDto>> getAllGroups() {
        List<GroupDto> groups = this.appService.findAllGroups();
        return ResponseEntity.ok(groups);
    }

    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupRequest) throws Exception {

        GroupDto createGroup = this.appService.addGroup(groupRequest);
        return new ResponseEntity(createGroup, HttpStatus.CREATED);

    }

    @PatchMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<GroupDto> updateGroup(@PathVariable Long id, @RequestBody GroupDto groupDto) {
        GroupDto updateGroup = this.appService.updateGroup(groupDto,id);
        return new ResponseEntity(updateGroup, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(
            path = {"/{id}"}
    )
    public ResponseEntity<Object> deleteGroup(@PathVariable Long id) {
        this.appService.deleteGroup(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
