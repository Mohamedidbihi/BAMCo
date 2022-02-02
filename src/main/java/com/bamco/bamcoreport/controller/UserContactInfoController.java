package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.UserContactInfoDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/contactInfo"})
public class UserContactInfoController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<UserContactInfoDto> getUserContactInfo(@PathVariable Long id) {
        UserContactInfoDto userContactInfo = this.appService.findUserContactInfoById(id);
        return new ResponseEntity(userContactInfo, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<UserContactInfoDto>> getAllUserContactInfo() {
        List<UserContactInfoDto> UserContactInfo = appService.getAllUserContactInfo();
        return ResponseEntity.ok(UserContactInfo);
    }

    @PostMapping
    public ResponseEntity<UserContactInfoDto> createUserContactInfo(@RequestBody UserContactInfoDto userContactInfoRequest) throws Exception {

        UserContactInfoDto createUserContactInfo = this.appService.addUserContactInfo(userContactInfoRequest);
        return new ResponseEntity(createUserContactInfo, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    public ResponseEntity<UserContactInfoDto> updateUserContactInfo( @RequestBody UserContactInfoDto userContactInfoRequest, @PathVariable Long id) {

        UserContactInfoDto updateUserContactInfo = this.appService.updateUserContactInfo(userContactInfoRequest,id);
        return new ResponseEntity(updateUserContactInfo, HttpStatus.ACCEPTED);
    }
}
