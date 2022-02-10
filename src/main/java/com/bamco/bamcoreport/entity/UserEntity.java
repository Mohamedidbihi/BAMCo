package com.bamco.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@ApiModel(value = "User Entity", description = "This entity is just a representation of the users table in the BAMCo database")
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
    private Boolean enabled ;

    @JsonIgnore
    @OneToOne(targetEntity = UserContactInfo.class, mappedBy = "userid")
    private UserContactInfo userContactInfo;

    @JsonIgnore
    @OneToMany(targetEntity = Rejet.class, mappedBy = "TakenBy", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rejet> rejets;

    @Column(
            nullable = false,
            length = 255,
            unique = true
    )
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    @ManyToOne()
    @JoinColumn(
            name = "manageruserid"
    )
    private UserEntity manageruserid;

    @ManyToOne()
    @JoinColumn(
            name = "createdby"
    )
    private UserEntity createdby;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "createdat", updatable = false)
    private LocalDateTime createdat;

    @JsonIgnore
    @UpdateTimestamp
    @Column(name = "updatedat")
    private LocalDateTime updatedat;


    public UserEntity(){

    }

    public UserEntity(long id, Boolean enabled, UserContactInfo userContactInfo, String username, String encryptedpassword, String firstname, String lastname, String title, String jobtitle, UserEntity manageruserid, UserEntity createdby, LocalDateTime createdat, LocalDateTime updatedat) {
        this.id = id;
        this.enabled = enabled;
        this.userContactInfo = userContactInfo;
        this.username = username;
        this.encryptedpassword = encryptedpassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.jobtitle = jobtitle;
        this.manageruserid = manageruserid;
        this.createdby = createdby;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public UserEntity(long id, Boolean enabled, String username, String encryptedpassword, String firstname, String lastname, String title, String jobtitle, UserEntity manageruserid, UserEntity createdby, LocalDateTime createdat, LocalDateTime updatedat) {
        this.id = id;
        this.enabled = enabled;
        this.username = username;
        this.encryptedpassword = encryptedpassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.jobtitle = jobtitle;
        this.manageruserid = manageruserid;
        this.createdby = createdby;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public UserEntity(long id, Boolean enabled, String username, String encryptedpassword, String firstname, String lastname, String title, String jobtitle, UserEntity manageruserid, UserEntity createdby) {
        this.id = id;
        this.enabled = enabled;
        this.username = username;
        this.encryptedpassword = encryptedpassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.jobtitle = jobtitle;
        this.manageruserid = manageruserid;
        this.createdby = createdby;
    }

    public UserEntity(long id) {
        this.id = id;
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

    public List<Rejet> getRejets() {
        return rejets;
    }

    public void setRejets(List<Rejet> rejets) {
        this.rejets = rejets;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", userContactInfo=" + userContactInfo +
                ", username='" + username + '\'' +
                ", encryptedpassword='" + encryptedpassword + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", title='" + title + '\'' +
                ", jobtitle='" + jobtitle + '\'' +
                ", manageruserid=" + manageruserid +
                ", createdby=" + createdby +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                '}';
    }
}
