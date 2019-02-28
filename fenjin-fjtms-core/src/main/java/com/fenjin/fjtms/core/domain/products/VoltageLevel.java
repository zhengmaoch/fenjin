package com.fenjin.fjtms.core.domain.products;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "voltagelevel")
public class VoltageLevel implements Serializable {
    private String id;
    private String name;
    private String code;
    private String extensionCode;
    private double rateVoltage;
    private int voltageTypeId;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "ExtensionCode")
    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode;
    }

    @Basic
    @Column(name = "RateVoltage")
    public double getRateVoltage() {
        return rateVoltage;
    }

    public void setRateVoltage(double rateVoltage) {
        this.rateVoltage = rateVoltage;
    }

    @Basic
    @Column(name = "VoltageTypeId")
    public int getVoltageTypeId() {
        return voltageTypeId;
    }

    public void setVoltageTypeId(int voltageTypeId) {
        this.voltageTypeId = voltageTypeId;
    }

    @Basic
    @Column(name = "Published")
    public boolean getPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Basic
    @Column(name = "Deleted")
    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "DisplayOrder")
    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Basic
    @Column(name = "CreatedTime")
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "UpdatedTime")
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoltageLevel that = (VoltageLevel) o;
        return Double.compare(that.rateVoltage, rateVoltage) == 0 &&
                voltageTypeId == that.voltageTypeId &&
                published == that.published &&
                deleted == that.deleted &&
                displayOrder == that.displayOrder &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(extensionCode, that.extensionCode) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, extensionCode, rateVoltage, voltageTypeId, published, deleted, displayOrder, createdTime, updatedTime);
    }
}
