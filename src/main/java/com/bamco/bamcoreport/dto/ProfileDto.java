package com.bamco.bamcoreport.dto;

import com.bamco.bamcoreport.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(value = "Profile", description = "Profile Properties")
public class ProfileDto {
    @ApiModelProperty(hidden = true)
    private Long id;
    private boolean isDefault;
    private String name;
    private String description;
    private UserEntity createdBy;
    private UserEntity lastUpdateBy;
    @ApiModelProperty(hidden = true)
    private LocalDateTime createdAt;
    @ApiModelProperty(hidden = true)
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserEntity getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(UserEntity lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
}
