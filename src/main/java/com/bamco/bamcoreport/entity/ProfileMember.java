package com.bamco.bamcoreport.entity;

import javax.persistence.*;

@Entity(name = "profileMember")
public class ProfileMember {
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

}
