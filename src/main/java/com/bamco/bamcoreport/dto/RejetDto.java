package com.bamco.bamcoreport.dto;

import com.bamco.bamcoreport.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(value = "Rejet", description = "Rejet Properties")
public class RejetDto {

    @ApiModelProperty(hidden = true)
    private long id;
    private String flowType;
    private String rejectNature;
    private String entity;
    private String agencyCode;
    private long userRegistrationNumber;
    private String bu;
    private String su;
    private String regionalDelegation;
    private String subDelegationType;
    private String subDelegationName;
    private String cliFileCode;
    private String clientCode;
    private String gravity;
    private String zoneCode;
    private boolean isWrongField;
    private String errorCode;
    private String errorLabel;
    private boolean isRequestTaken;
    private String actionDetail;
    @ApiModelProperty(hidden = true)
    private String file;
    private UserEntity TakenBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public String getRejectNature() {
        return rejectNature;
    }

    public void setRejectNature(String rejectNature) {
        this.rejectNature = rejectNature;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public long getUserRegistrationNumber() {
        return userRegistrationNumber;
    }

    public void setUserRegistrationNumber(long userRegistrationNumber) {
        this.userRegistrationNumber = userRegistrationNumber;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public String getRegionalDelegation() {
        return regionalDelegation;
    }

    public void setRegionalDelegation(String regionalDelegation) {
        this.regionalDelegation = regionalDelegation;
    }

    public String getSubDelegationType() {
        return subDelegationType;
    }

    public void setSubDelegationType(String subDelegationType) {
        this.subDelegationType = subDelegationType;
    }

    public String getSubDelegationName() {
        return subDelegationName;
    }

    public void setSubDelegationName(String subDelegationName) {
        this.subDelegationName = subDelegationName;
    }

    public String getCliFileCode() {
        return cliFileCode;
    }

    public void setCliFileCode(String cliFileCode) {
        this.cliFileCode = cliFileCode;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public boolean getWrongField() {
        return isWrongField;
    }

    public void setWrongField(boolean wrongField) {
        isWrongField = wrongField;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(String errorLabel) {
        this.errorLabel = errorLabel;
    }

    public boolean getRequestTaken() {
        return isRequestTaken;
    }

    public void setRequestTaken(boolean requestTaken) {
        isRequestTaken = requestTaken;
    }

    public String getActionDetail() {
        return actionDetail;
    }

    public void setActionDetail(String actionDetail) {
        this.actionDetail = actionDetail;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @JsonProperty(value="TakenBy")
    public UserEntity getTakenBy() {
        return TakenBy;
    }

    @JsonProperty(value="TakenBy")
    public void setTakenBy(UserEntity takenBy) {
        TakenBy = takenBy;
    }

    @Override
    public String toString() {
        return "RejetDto{" +
                "id=" + id +
                ", flowType='" + flowType + '\'' +
                ", rejectNature='" + rejectNature + '\'' +
                ", entity='" + entity + '\'' +
                ", agencyCode='" + agencyCode + '\'' +
                ", userRegistrationNumber=" + userRegistrationNumber +
                ", bu='" + bu + '\'' +
                ", su='" + su + '\'' +
                ", regionalDelegation='" + regionalDelegation + '\'' +
                ", subDelegationType='" + subDelegationType + '\'' +
                ", subDelegationName='" + subDelegationName + '\'' +
                ", cliFileCode='" + cliFileCode + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", gravity='" + gravity + '\'' +
                ", zoneCode='" + zoneCode + '\'' +
                ", isWrongField=" + isWrongField +
                ", errorCode='" + errorCode + '\'' +
                ", errorLabel='" + errorLabel + '\'' +
                ", isRequestTaken=" + isRequestTaken +
                ", actionDetail='" + actionDetail + '\'' +
                ", file='" + file + '\'' +
                ", TakenBy=" + TakenBy +
                '}';
    }
}
