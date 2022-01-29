package com.bamco.bamcoreport.dto;

import com.bamco.bamcoreport.entity.UserEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserDto  {

    private long id;
    private boolean enable = false;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String title;
    private String jobTitle;
    private UserEntity manageruserid;
    private UserEntity createdby;
    private LocalDateTime createdat;
    private LocalDateTime updatedat;

    public UserDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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