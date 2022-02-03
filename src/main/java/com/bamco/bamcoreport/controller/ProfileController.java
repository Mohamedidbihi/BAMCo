package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.ProfileDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Profiles", description = "Users Profiles")
@RestController
@RequestMapping({"/profile"})
public class ProfileController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Get profile by ID",
            notes = "Provide an ID to look a specific profile from BAMCo database"
    )
    public ResponseEntity<ProfileDto> getProfile(@PathVariable Long id) {
        ProfileDto profileDto = this.appService.findProfileById(id);
        return new ResponseEntity(profileDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    @ApiOperation(
            value = "Get all profiles",
            notes = "Get all users profiles from BAMCo database"
    )
    public ResponseEntity<List<ProfileDto>> getAllProfiles() {
        List<ProfileDto> profiles = appService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @PostMapping
    @ApiOperation(
            value = "Create a new profile",
            notes = "Create a new profile and save it to BAMCo database"
    )
    public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profileRequest) throws Exception {

        ProfileDto createProfile = this.appService.addProfile(profileRequest);
        return new ResponseEntity(createProfile, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Update profile by ID",
            notes = "Provide an ID to update a specific profile from BAMCo database"
    )
    public ResponseEntity<ProfileDto> updateProfile(@RequestBody ProfileDto profileRequest, @PathVariable Long id) {

        ProfileDto updatedProfile = this.appService.updateProfile(profileRequest,id);
        return new ResponseEntity(updatedProfile, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Delete profile by ID",
            notes = "Provide an ID to delete a specific profile from BAMCo database"
    )
    public ResponseEntity<Object> deleteProfile(@PathVariable Long id) {
        this.appService.deleteProfile(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
