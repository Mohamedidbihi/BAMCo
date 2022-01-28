package com.bamco.bamcoreport.entity;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "userMembership")
public class UserMembership implements Serializable {
    private static final long serialVersionUID = -6232065926835235823L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private UserEntity userid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid")
    private Role roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupid")
    private Group groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignedby")
    private UserEntity assignedBy;

    @CreationTimestamp
    @Column(name = "assigneddate")
    private LocalDateTime assignedDate;

    public UserMembership(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userId) {
        this.userid = userId;
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

    public LocalDateTime getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDateTime assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Override
    public String toString() {
        return "UserMembership{" +
                "id=" + id +
                ", userId=" + userid +
                ", roleId=" + roleId +
                ", groupId=" + groupId +
                ", assignedBy=" + assignedBy +
                ", assignedDate=" + assignedDate +
                '}';
    }
}
