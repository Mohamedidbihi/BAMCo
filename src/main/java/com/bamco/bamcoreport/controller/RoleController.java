package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.RoleDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/role"})
public class RoleController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<RoleDto> getRole(@PathVariable Long id) {
        RoleDto roleDto = this.appService.findRoleById(id);
        return new ResponseEntity(roleDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        List<RoleDto> roles = appService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleRequest) throws Exception {

        RoleDto createRole = this.appService.addRole(roleRequest);
        return new ResponseEntity(createRole, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    public ResponseEntity<RoleDto> updateRole( @RequestBody RoleDto roleRequest, @PathVariable Long id) {

        RoleDto updateRole = this.appService.updateRole(roleRequest,id);
        return new ResponseEntity(updateRole, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        this.appService.deleteRole(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
