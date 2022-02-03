package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.RoleDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Roles", description = "Users Roles")
@RestController
@RequestMapping({"/role"})
public class RoleController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Get role by ID",
            notes = "Provide an ID to look a specific role from BAMCo database"
    )
    public ResponseEntity<RoleDto> getRole(@PathVariable Long id) {
        RoleDto roleDto = this.appService.findRoleById(id);
        return new ResponseEntity(roleDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    @ApiOperation(
            value = "Get all roles",
            notes = "Get all users roles from BAMCo database"
    )
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        List<RoleDto> roles = appService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    @ApiOperation(
            value = "Create a new role",
            notes = "Create a new role and save it to BAMCo database"
    )
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleRequest) throws Exception {

        RoleDto createRole = this.appService.addRole(roleRequest);
        return new ResponseEntity(createRole, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Update role by ID",
            notes = "Provide an ID to update a specific role from BAMCo database"
    )
    public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDto roleRequest, @PathVariable Long id) {

        RoleDto updateRole = this.appService.updateRole(roleRequest,id);
        return new ResponseEntity(updateRole, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Delete role by ID",
            notes = "Provide an ID to delete a specific role from BAMCo database"
    )
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        this.appService.deleteRole(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
