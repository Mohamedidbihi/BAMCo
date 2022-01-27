package com.bamco.bamcoreport.entity;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "userMembership")
public class UserMembership {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private UserEntity userId;

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
}
