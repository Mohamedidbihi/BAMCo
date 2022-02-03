package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.ProfileMemberDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Profile Memberships", description = "Profile Memberships")
@RestController
@RequestMapping({"/profileMember"})
public class ProfileMemberController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Get profile membership by ID",
            notes = "Provide an ID to look a specific profile membership from BAMCo database"
    )
    public ResponseEntity<ProfileMemberDto> getProfileMember(@PathVariable Long id) {
        ProfileMemberDto profileMemberDto = this.appService.findProfileMemberById(id);
        return new ResponseEntity(profileMemberDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    @ApiOperation(
            value = "Get all profile memberships",
            notes = "Get all profile memberships from BAMCo database"
    )
    public ResponseEntity<List<ProfileMemberDto>> getAllProfileMembers() {
        List<ProfileMemberDto> profileMembers = appService.getAllProfileMembers();
        return ResponseEntity.ok(profileMembers);
    }

    @PostMapping
    @ApiOperation(
            value = "Create a new profile membership",
            notes = "Create a new profile membership and save it to BAMCo database"
    )
    public ResponseEntity<ProfileMemberDto> createProfileMember(@RequestBody ProfileMemberDto profileMemberRequest) throws Exception {

        ProfileMemberDto createdProfileMember = this.appService.addProfileMember(profileMemberRequest);
        return new ResponseEntity(createdProfileMember, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Update profile membership by ID",
            notes = "Provide an ID to update a specific profile membership from BAMCo database"
    )
    public ResponseEntity<ProfileMemberDto> updateProfileMember( @RequestBody ProfileMemberDto profileMemberRequest, @PathVariable Long id) {

        ProfileMemberDto updateProfileMember = this.appService.updateProfileMember(profileMemberRequest,id);
        return new ResponseEntity(updateProfileMember, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    @ApiOperation(
            value = "delete profile membership by ID",
            notes = "Provide an ID to delete a specific profile membership from BAMCo database"
    )
    public ResponseEntity<Object> deleteProfileMember(@PathVariable Long id) {
        this.appService.deleteProfileMember(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
