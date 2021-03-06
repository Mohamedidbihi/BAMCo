package com.bamco.bamcoreport.dto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(value = "User", description = "User Properties")
public class UserDto  {
    @ApiModelProperty(hidden = true)
    private long id;
    private boolean enabled ;
    @ApiModelProperty(notes = "The username should be unique")
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String title;
    private String jobtitle;
    private UserEntity manageruserid;
    private UserEntity createdby;
    @ApiModelProperty(hidden = true)
    private LocalDateTime createdat;
    @ApiModelProperty(hidden = true)
    private LocalDateTime updatedat;

    public UserDto() {

    }

    public UserDto(boolean enabled, String username, String password, String firstname, String lastname, String title, String jobtitle, UserEntity manageruserid, UserEntity createdby) {
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.jobtitle = jobtitle;
        this.manageruserid = manageruserid;
        this.createdby = createdby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public UserEntity getManageruserid() {
        return manageruserid;
    }

    public void setManageruserid(UserEntity manageruserid) {
        this.manageruserid = manageruserid;
    }


    public UserEntity getCreatedby() {
        return createdby;
    }

    public void setCreatedby(UserEntity createdby) {
        this.createdby = createdby;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }
}