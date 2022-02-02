package com.bamco.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(
        name = "usercontactinfo"
)
public class UserContactInfo implements Serializable {

    private static final long serialVersionUID = 4191294345580846535L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @JsonIgnore
    @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(
            name = "userid",
            nullable = false,
            referencedColumnName = "id"
    )
    private UserEntity userid;

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

    public UserContactInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userid;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userid = userEntity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getPersonal() {
        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    @Override
    public String toString() {
        return "UserContactInfo{" +
                "id=" + id +
                ", userEntity=" + userid +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", number='" + number + '\'' +
                ", fax='" + fax + '\'' +
                ", building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", adress='" + adress + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", website='" + website + '\'' +
                ", personal=" + personal +
                '}';
    }
}
