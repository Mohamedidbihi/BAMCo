package com.bamco.bamcoreport.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false)
    private Long id;

    @Column(name = "isdefault",
            columnDefinition = "boolean default false")
    private boolean isDefault;

    @Column(
            nullable = false,
            length = 255,
            unique = true
    )
    private String name;

    @Column(
            name = "description",
            columnDefinition="TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "created_by",
            nullable = false
    )
    private UserEntity createdBy;

    @CreatedDate
    @Column(
            name = "created_at",
            nullable = false,
            updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lastupdateby")
    private UserEntity lastUpdateBy;
}
