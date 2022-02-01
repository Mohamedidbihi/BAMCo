package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.ProfileDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/profile"})
public class ProfileController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ProfileDto> getProfile(@PathVariable Long id) {
        ProfileDto profileDto = this.appService.findProfileById(id);
        return new ResponseEntity(profileDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<ProfileDto>> getAllProfiles() {
        List<ProfileDto> profiles = appService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @PostMapping
    public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profileRequest) throws Exception {

        ProfileDto createProfile = this.appService.addProfile(profileRequest);
        return new ResponseEntity(createProfile, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    public ResponseEntity<ProfileDto> updateProfile(@RequestBody ProfileDto profileRequest, @PathVariable Long id) {

        ProfileDto updatedProfile = this.appService.updateProfile(profileRequest,id);
        return new ResponseEntity(updatedProfile, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> deleteProfile(@PathVariable Long id) {
        this.appService.deleteProfile(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
