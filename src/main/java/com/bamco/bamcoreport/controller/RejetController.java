package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.RejetDto;
import com.bamco.bamcoreport.dto.CountDayDto;
import com.bamco.bamcoreport.service.IApplicationServiceCrud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(tags = "Rejets", description = "Users Rejets")
@RestController
@RequestMapping(value = {"/rejet"})
public class RejetController {
    @Autowired
    IApplicationServiceCrud appService;

    @GetMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Get rejet by ID",
            notes = "Provide an ID to look a specific rejet from BAMCo database"
    )
    public ResponseEntity<RejetDto> getRejet(@PathVariable Long id) {
        RejetDto rejetDto = this.appService.findRejetById(id);
        return new ResponseEntity(rejetDto, HttpStatus.OK);
    }

    @GetMapping({"/all"})
    @ApiOperation(
            value = "Get all rejets",
            notes = "Get all users rejets from BAMCo database"
    )
    public ResponseEntity<List<RejetDto>> getAllRoles() {
        List<RejetDto> rejets = appService.getAllRejets();
        return ResponseEntity.ok(rejets);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    @ApiOperation(
            value = "Create a new rejet",
            notes = "Create a new rejet and save it to BAMCo database"
    )
    public ResponseEntity<RejetDto> createRejet(@RequestPart RejetDto rejetRequest, @RequestPart MultipartFile file) throws Exception {

        RejetDto createRejet = this.appService.addRejet(rejetRequest, file);
        return new ResponseEntity(createRejet, HttpStatus.CREATED);

    }

    @PatchMapping(path = {"/{id}"}, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    @ApiOperation(
            value = "Update rejet by ID",
            notes = "Provide an ID to update a specific rejet from BAMCo database"
    )
    public ResponseEntity<RejetDto> updateRejet(@RequestPart RejetDto rejetRequest, @RequestPart MultipartFile file, @PathVariable Long id) {

        RejetDto updateRejet = this.appService.updateRejet(rejetRequest, id, file);
        return new ResponseEntity(updateRejet, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = {"/{id}"})
    @ApiOperation(
            value = "Delete rejet by ID",
            notes = "Provide an ID to delete a specific rejet from BAMCo database"
    )
    public ResponseEntity<Object> deleteRejet(@PathVariable Long id) {
        this.appService.deleteRejet(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping({"/count"})
    @ApiOperation(
            value = "Get count of rejets",
            notes = "Get total number of rejets from BAMCo database"
    )
    public ResponseEntity<String> getRejetsCount() {
        String count = String.valueOf(appService.getRejetsCount());
        return ResponseEntity.ok(count);
    }

    @GetMapping({"/daily"})
    @ApiOperation(
            value = "Get rejets by day",
            notes = "Get total number of rejets by day from BAMCo database"
    )
    public ResponseEntity<List<CountDayDto>> getRejetsByDay() {
        List<CountDayDto> rejets = appService.getRejetsByDay();
        return ResponseEntity.ok(rejets);
    }

    @GetMapping({"/daily/{id}"})
    @ApiOperation(
            value = "Get rejets by user",
            notes = "Get total number of rejets by user from BAMCo database"
    )
    public ResponseEntity<List<CountDayDto>> getRejetsByUser(@PathVariable Long id) {
        List<CountDayDto> rejets = appService.getRejetsByUser(id);
        return ResponseEntity.ok(rejets);
    }
}
