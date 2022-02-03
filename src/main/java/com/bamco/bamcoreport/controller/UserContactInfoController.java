package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.UserContactInfoDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Contact Info", description = "Users Contact Information")
@RestController
@RequestMapping({"/contactInfo"})
public class UserContactInfoController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Get contact info by ID",
            notes = "Provide an ID to look a specific user contact info from BAMCo database"
    )
    public ResponseEntity<UserContactInfoDto> getUserContactInfo(@PathVariable Long id) {
        UserContactInfoDto userContactInfo = this.appService.findUserContactInfoById(id);
        return new ResponseEntity(userContactInfo, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    @ApiOperation(
            value = "Get all contact info",
            notes = "Get all contact info of all users from BAMCo database"
    )
    public ResponseEntity<List<UserContactInfoDto>> getAllUserContactInfo() {
        List<UserContactInfoDto> UserContactInfo = appService.getAllUserContactInfo();
        return ResponseEntity.ok(UserContactInfo);
    }

    @PostMapping
    @ApiOperation(
            value = "Create contact info",
            notes = "Create contact info for a specific user from BAMCo database"
    )
    public ResponseEntity<UserContactInfoDto> createUserContactInfo(@RequestBody UserContactInfoDto userContactInfoRequest) throws Exception {

        UserContactInfoDto createUserContactInfo = this.appService.addUserContactInfo(userContactInfoRequest);
        return new ResponseEntity(createUserContactInfo, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Update contact info by ID",
            notes = "Provide an ID to update a specific user contact info from BAMCo database"
    )
    public ResponseEntity<UserContactInfoDto> updateUserContactInfo(@RequestBody UserContactInfoDto userContactInfoRequest, @PathVariable Long id) {

        UserContactInfoDto updateUserContactInfo = this.appService.updateUserContactInfo(userContactInfoRequest,id);
        return new ResponseEntity(updateUserContactInfo, HttpStatus.ACCEPTED);
    }
}
