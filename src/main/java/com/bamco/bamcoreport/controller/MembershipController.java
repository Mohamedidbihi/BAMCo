package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.MembershipDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Memberships", description = "Users Memberships")
@RestController
@RequestMapping({"/membership"})
public class MembershipController {

    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Get membership by ID",
            notes = "Provide an ID to look a specific membership from BAMCo database"
    )
    public ResponseEntity<MembershipDto> getMembership(@PathVariable Long id) {
        MembershipDto membershipDto = this.appService.findMembershipById(id);
        return new ResponseEntity(membershipDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    @ApiOperation(
            value = "Get all memberships",
            notes = "Get all users memberships from BAMCo database"
    )
    public ResponseEntity<List<MembershipDto>> getAllMemberships() {
        List<MembershipDto> memberships = appService.getAllMemberships();
        return ResponseEntity.ok(memberships);
    }

    @PostMapping
    @ApiOperation(
            value = "Create a new membership",
            notes = "Create a new membership and save it to BAMCo database"
    )
    public ResponseEntity<MembershipDto> createMembership(@RequestBody MembershipDto membershipRequest) throws Exception {

        MembershipDto createdMembership = this.appService.addMembership(membershipRequest);
        return new ResponseEntity(createdMembership, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Update membership by ID",
            notes = "Provide an ID to update a specific membership from BAMCo database"
    )
    public ResponseEntity<MembershipDto> updateMembership(@RequestBody MembershipDto membershipRequest, @PathVariable Long id) {

        MembershipDto updatedMembership = this.appService.updateMembership(membershipRequest,id);
        return new ResponseEntity(updatedMembership, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Delete membership by ID",
            notes = "Provide an ID to delete a specific membership from BAMCo database"
    )
    public ResponseEntity<Object> deleteMembership(@PathVariable Long id) {
        this.appService.deleteMembership(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
