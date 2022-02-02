package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.ProfileMemberDto;
import com.bamco.bamcoreport.dto.RoleDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/profileMember"})
public class ProfileMemberController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ProfileMemberDto> getProfileMember(@PathVariable Long id) {
        ProfileMemberDto profileMemberDto = this.appService.findProfileMemberById(id);
        return new ResponseEntity(profileMemberDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<ProfileMemberDto>> getAllRoles() {
        List<ProfileMemberDto> profileMembers = appService.getAllProfileMembers();
        return ResponseEntity.ok(profileMembers);
    }

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody ProfileMemberDto profileMemberRequest) throws Exception {

        ProfileMemberDto createdProfileMember = this.appService.addProfileMember(profileMemberRequest);
        return new ResponseEntity(createdProfileMember, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    public ResponseEntity<ProfileMemberDto> updateProfileMember( @RequestBody ProfileMemberDto profileMemberRequest, @PathVariable Long id) {

        ProfileMemberDto updateProfileMember = this.appService.updateProfileMember(profileMemberRequest,id);
        return new ResponseEntity(updateProfileMember, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> deleteProfileMember(@PathVariable Long id) {
        this.appService.deleteProfileMember(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
