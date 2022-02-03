package com.bamco.bamcoreport.dto;

import com.bamco.bamcoreport.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@ApiModel(value = "Group", description = "Group Properties")
public class GroupDto {
    @ApiModelProperty(hidden = true)
    private  long id;
    private String name;
    private String parentPath;
    @ApiModelProperty(notes = "The display name should be unique")
    private String displayName;
    private String description;
    private UserEntity createdby;
    @ApiModelProperty(hidden = true)
    private LocalDateTime createdat;
    @ApiModelProperty(hidden = true)
    private LocalDateTime updatedat;

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

    public String getParentpath() {
        return parentPath;
    }

    public void setParentpath(String parentpath) {
        this.parentPath = parentpath;
    }

    public String getDisplayname() {
        return displayName;
    }

    public void setDisplayname(String displayname) {
        this.displayName = displayname;
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
}
