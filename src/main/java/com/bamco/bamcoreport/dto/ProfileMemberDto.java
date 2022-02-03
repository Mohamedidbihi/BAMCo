package com.bamco.bamcoreport.dto;

import com.bamco.bamcoreport.entity.Group;
import com.bamco.bamcoreport.entity.Profile;
import com.bamco.bamcoreport.entity.Role;
import com.bamco.bamcoreport.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Profile Membership", description = "Profile Membership Properties")
public class ProfileMemberDto {
    @ApiModelProperty(hidden = true)
    private long id;
    private Profile profileId;
    private UserEntity userId;
    private Group groupId;
    private Role roleId;

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
}
