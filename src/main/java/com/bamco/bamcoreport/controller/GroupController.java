package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.GroupDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Groups", description = "Users Groups")
@RestController
@RequestMapping({"/groups"})

public class GroupController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Get group by ID",
            notes = "Provide an ID to look a specific group from BAMCo database"
    )
    public ResponseEntity<GroupDto> getGroup(@PathVariable Long id) {
        GroupDto groupDto = this.appService.findGroupById(id);
        return new ResponseEntity(groupDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    @ApiOperation(
            value = "Get all groups",
            notes = "Get all groups from BAMCo database"
    )
    public ResponseEntity<List<GroupDto>> getAllGroups() {
        List<GroupDto> groups = this.appService.findAllGroups();
        return ResponseEntity.ok(groups);
    }

    @PostMapping
    @ApiOperation(
            value = "Update group by ID",
            notes = "Provide an ID to update a specific group from BAMCo database"
    )
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupRequest) throws Exception {
        GroupDto createGroup = this.appService.addGroup(groupRequest);
        return new ResponseEntity(createGroup, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    @ApiOperation(
            value = "update group by ID",
            notes = "Provide an ID to update a specific group from BAMCo database"
    )
    public ResponseEntity<GroupDto> updateGroup(@PathVariable Long id, @RequestBody GroupDto groupDto) {
        GroupDto updateGroup = this.appService.updateGroup(groupDto,id);
        return new ResponseEntity(updateGroup, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Delete group by ID",
            notes = "Provide an ID to delete a specific group from BAMCo database"
    )
    public ResponseEntity<Object> deleteGroup(@PathVariable Long id) {
        this.appService.deleteGroup(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
