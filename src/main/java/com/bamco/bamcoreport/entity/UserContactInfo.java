package com.bamco.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(
        name = "usercontactinfo"
)
public class UserContactInfo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;


    @JsonIgnore
    @OneToOne(targetEntity = UserEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "userId",
            nullable = false,
            referencedColumnName = "id"
    )
    private UserEntity userEntity;

    @Column(
            nullable = false,
            length = 255,
            unique = true
    )
    private String email;

    @Column(
            nullable = false,
            length = 50
    )
    private String phone;

    @Column(
            nullable = false,
            length = 50
    )
    private String number;

    @Column(
            nullable = false,
            length = 50
    )
    private String fax;

    @Column(
            nullable = false,
            length = 50
    )
    private String building;

    @Column(
            nullable = false,
            length = 50
    )
    private String room;

    @Column(
            nullable = false,
            length = 255
    )
    private String adress;

    @Column(
            nullable = false,
            length = 50
    )
    private String zipcode;

    @Column(
            nullable = false,
            length = 255
    )
    private String city;

    @Column(
            nullable = false,
            length = 255
    )
    private String state;

    @Column(
            nullable = false,
            length = 255
    )
    private String country;

    @Column(
            nullable = false,
            length = 255
    )
    private String website;

    @Column(
            nullable = true
    )
    private Boolean personal = false;


}
