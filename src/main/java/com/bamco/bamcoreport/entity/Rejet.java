package com.bamco.bamcoreport.entity;

import com.bamco.bamcoreport.dto.CountDayDto;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@ApiModel(value = "Rejet Entity", description = "This entity is just a representation of the rejets table in the BAMCo database")
@NamedNativeQuery
        (name = "Rejet.getDailyCount",
        query = "SELECT date_trunc('day', declaration_date) AS day, COUNT(*) FROM rejet GROUP BY date_trunc('day', declaration_date)",
        resultSetMapping = "Mapping.CountDayDto"
        )
@SqlResultSetMapping
        (name = "Mapping.CountDayDto",
        classes = @ConstructorResult
                (targetClass = CountDayDto.class,
                columns = {@ColumnResult(name = "day", type=String.class), @ColumnResult(name = "count", type=int.class)}
                )
        )
@NamedNativeQuery
        (name = "Rejet.getRejetsByUser",
                query = "SELECT date_trunc('day', declaration_date) AS day, COUNT(*) FROM rejet WHERE takenby = :user_id GROUP BY date_trunc('day', declaration_date)",
                resultSetMapping = "Mapping.CountDayDto"
        )
@SqlResultSetMapping
        (name = "Mapping.getRejetsByUser",
                classes = @ConstructorResult
                        (targetClass = CountDayDto.class,
                                columns = {@ColumnResult(name = "day", type=String.class), @ColumnResult(name = "count", type=int.class)}
                        )
        )
@Entity(name = "Rejet")
public class Rejet implements Serializable {

    private static final long serialVersionUID = 7160711990803479745L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(
            nullable = false,
            length = 255
    )
    private String flowType;

    @Column(
            nullable = false,
            length = 255
    )
    private String rejectNature;

    @Column(
            nullable = false,
            length = 255
    )
    private String entity;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime declarationDate;

    @Column(
            nullable = false,
            length = 255
    )
    private String agencyCode;

    @Column(
            nullable = false,
            length = 500
    )
    private long userRegistrationNumber;

    @Column(
            nullable = false,
            length = 255
    )
    private String bu;

    @Column(
            nullable = false,
            length = 255
    )
    private String su;

    @Column(
            nullable = false,
            length = 255
    )
    private String regionalDelegation;

    @Column(
            nullable = false,
            length = 255
    )
    private String subDelegationType;

    @Column(
            nullable = false,
            length = 255
    )
    private String subDelegationName;

    @Column(
            nullable = false,
            length = 255
    )
    private String cliFileCode;

    @Column(
            nullable = false,
            length = 255
    )
    private String clientCode;

    @Column(
            nullable = false,
            length = 255
    )
    private String gravity;

    @Column(
            nullable = false,
            length = 255
    )
    private String zoneCode;

    @Column(
            nullable = false
    )
    private Boolean isWrongField;

    @Column(
            nullable = false,
            length = 255
    )
    private String errorCode;

    @Column(
            nullable = false,
            length = 255
    )
    private String errorLabel;

    @Column(
            nullable = false
    )
    private Boolean isRequestTaken;

    @Column(
            nullable = false,
            length = 255
    )
    private String actionDetail;

    @Column(
            nullable = false,
            length = 255
    )
    private String file;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "takenby", nullable = true, referencedColumnName = "id")
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

    public LocalDateTime getDeclarationDate() {
        return declarationDate;
    }

    public void setDeclarationDate(LocalDateTime declarationDate) {
        this.declarationDate = declarationDate;
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

    public Boolean getWrongField() {
        return isWrongField;
    }

    public void setWrongField(Boolean wrongField) {
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

    public Boolean getRequestTaken() {
        return isRequestTaken;
    }

    public void setRequestTaken(Boolean requestTaken) {
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

    public UserEntity getTakenBy() {
        return TakenBy;
    }

    public void setTakenBy(UserEntity takenBy) {
        TakenBy = takenBy;
    }

    @Override
    public String toString() {
        return "Rejet{" +
                "id=" + id +
                ", flowType='" + flowType + '\'' +
                ", rejectNature='" + rejectNature + '\'' +
                ", entity='" + entity + '\'' +
                ", declarationDate=" + declarationDate +
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
