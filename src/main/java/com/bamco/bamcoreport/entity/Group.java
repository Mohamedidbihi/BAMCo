package com.bamco.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@ApiModel(value = "Group Entity", description = "This entity is just a representation of the groups table in the BAMCo database")
@Entity (name = "groups")
public class Group implements Serializable {
    private static final long serialVersionUID = -5051985663615982848L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Column(
            nullable = false,
            length = 255,
            unique = true
    )
    private String name;

    @Column(
            nullable = false,
            length = 255,
            name = "parenthpath"
    )
    private String parentPath;

    @Column(
            nullable = false,
            length = 255,
            unique = true,
            name = "displayname"
    )
    private String displayName;

    @Column(
            nullable = false,
            length = 255
    )
    private String description;

    @ManyToOne()
    @JoinColumn(
            name = "createdby",
            nullable = false
    )
    private UserEntity createdby;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "createdat", updatable = false)
    private LocalDateTime createdat;

    @JsonIgnore
    @UpdateTimestamp
    @Column(name = "updatedat")
    private LocalDateTime updatedat;

    public Group() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getCreatedby() {
        return createdby;
    }

    public void setCreatedby(UserEntity createdby) {
        this.createdby = createdby;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentPath='" + parentPath + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", createdby=" + createdby +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                '}';
    }
}
