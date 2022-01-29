package com.bamco.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Entity(
        name = "users"
)
public class UserEntity  {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Column(
            nullable = true
    )
    private Boolean enabled = true;

    @JsonIgnore
    @OneToOne(targetEntity = UserContactInfo.class, mappedBy = "userid")
    private UserContactInfo userContactInfo;

    @Column(
            nullable = false,
            length = 255,
            unique = true
    )
    private String username;

    @Column(
            nullable = false,
            length = 255
    )
    private String encryptedpassword;

    @Column(
            nullable = false,
            length = 255
    )
    private String firstname;

    @Column(
            nullable = false,
            length = 255
    )
    private String lastname;

    @Column(
            nullable = false,
            length = 255
    )
    private String title;

    @Column(
            nullable = false,
            length = 255
    )
    private String jobtitle;

    @ManyToOne(fetch = FetchType.LAZY, optional=true)
    @JoinColumn(
            name = "manageruserid"
    )
    private UserEntity manageruserid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "createdby",
            nullable = false
    )
    private UserEntity createdby;

    @CreationTimestamp
    @Column(name = "createdat", nullable = false, updatable = false)
    private LocalDateTime createdat;

    @UpdateTimestamp
    @Column(name = "updatedat")
    private LocalDateTime updatedat;


    public UserEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public UserContactInfo getUserContactInfo() {
        return userContactInfo;
    }

    public void setUserContactInfo(UserContactInfo userContactInfo) {
        this.userContactInfo = userContactInfo;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", userContactInfo=" + userContactInfo +
                ", username='" + username + '\'' +
                ", encryptedPassword='" + encryptedpassword + '\'' +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", title='" + title + '\'' +
                ", jobTitle='" + jobtitle + '\'' +
                ", managerUserId=" + manageruserid +
                ", createdBy=" + createdby +
                ", createdAt=" + createdat +
                ", updatedAt=" + updatedat +
                '}';
    }
}
