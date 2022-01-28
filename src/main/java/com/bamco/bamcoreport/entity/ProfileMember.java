package com.bamco.bamcoreport.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "profileMember")
public class ProfileMember implements Serializable {

    private static final long serialVersionUID = 5314426306497526106L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileid")
    private Profile profileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupid")
    private Group groupId;

    @ManyToOne(fetch = FetchType.LAZY)
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
