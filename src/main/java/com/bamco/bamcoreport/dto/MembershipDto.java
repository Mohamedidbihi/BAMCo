package com.bamco.bamcoreport.dto;

import com.bamco.bamcoreport.entity.Group;
import com.bamco.bamcoreport.entity.Role;
import com.bamco.bamcoreport.entity.UserEntity;

public class MembershipDto {
    private UserEntity userid;
    private Role roleId;
    private Group groupId;
    private UserEntity assignedBy;

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public UserEntity getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(UserEntity assignedBy) {
        this.assignedBy = assignedBy;
    }
}
