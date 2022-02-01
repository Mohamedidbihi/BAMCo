package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.MembershipDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/membership"})
public class MembershipController {

    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<MembershipDto> getMembership(@PathVariable Long id) {
        MembershipDto membershipDto = this.appService.findMembershipById(id);
        return new ResponseEntity(membershipDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    public ResponseEntity<List<MembershipDto>> getAllMemberships() {
        List<MembershipDto> memberships = appService.getAllMemberships();
        return ResponseEntity.ok(memberships);
    }

    @PostMapping
    public ResponseEntity<MembershipDto> createMembership(@RequestBody MembershipDto membershipRequest) throws Exception {

        MembershipDto createdMembership = this.appService.addMembership(membershipRequest);
        return new ResponseEntity(createdMembership, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    public ResponseEntity<MembershipDto> updateMembership(@RequestBody MembershipDto membershipRequest, @PathVariable Long id) {

        MembershipDto updatedMembership = this.appService.updateMembership(membershipRequest,id);
        return new ResponseEntity(updatedMembership, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> deleteMembership(@PathVariable Long id) {
        this.appService.deleteMembership(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
