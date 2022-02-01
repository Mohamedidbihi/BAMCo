package com.bamco.bamcoreport.dto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

public class UserDto  {

    private long id;
    private boolean enabled ;
    private String username;
    private String encryptedpassword;
    private String firstname;
    private String lastname;
    private String title;
    private String jobtitle;
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

    public String getEncryptedpassword() {
        return encryptedpassword;
    }

    public void setEncryptedpassword(String encryptedpassword) {
        this.encryptedpassword = encryptedpassword;
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