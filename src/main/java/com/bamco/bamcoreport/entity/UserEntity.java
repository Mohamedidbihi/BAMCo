package com.bamco.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Entity(
        name = "users"
)
public class UserEntity implements Serializable {

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
    @OneToOne(targetEntity = UserContactInfo.class, mappedBy = "userEntity")
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
    private String encryptedPassword;

    @Column(
            nullable = false,
            length = 255
    )
    private String firstName;

    @Column(
            nullable = false,
            length = 255
    )
    private String lastName;

    @Column(
            nullable = false,
            length = 255
    )
    private String title;

    @Column(
            nullable = false,
            length = 255
    )
    private String jobTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "manageruserid",
            nullable = true
    )
    private UserEntity managerUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "created_by",
            nullable = false
    )
    private UserEntity createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
