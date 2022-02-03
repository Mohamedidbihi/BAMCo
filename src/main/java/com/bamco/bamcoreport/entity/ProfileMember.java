package com.bamco.bamcoreport.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "Profile Membership Entity", description = "This entity is just a representation of the profile membership table in the BAMCo database")
@Entity(name = "profileMember")
public class ProfileMember implements Serializable {

    private static final long serialVersionUID = 5314426306497526106L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profileid")
    private Profile profileId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "groupid")
    private Group groupId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid")
    private Role roleId;

    public ProfileMember() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "ProfileMember{" +
                "id=" + id +
                ", profileId=" + profileId +
                ", userId=" + userId +
                ", groupId=" + groupId +
                ", roleId=" + roleId +
                '}';
    }
}
