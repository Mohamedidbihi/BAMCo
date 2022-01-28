package com.bamco.bamcoreport.request;

import com.bamco.bamcoreport.entity.UserEntity;

public class UserRequest {

     private String username;
     private String password;
     private String firstname;
     private String lastname;
     private String title;
     private String jobtitile;
     private UserEntity manageruserid;
     private UserEntity createdby;

     public UserRequest(){

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

     public String getJobtitile() {
          return jobtitile;
     }

     public void setJobtitile(String jobtitile) {
          this.jobtitile = jobtitile;
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
}
