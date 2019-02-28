package com.fenjin.fjtms.core.domain.common;

import com.fenjin.fjtms.core.domain.products.Manufacturer;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "equipment")
public class Equipment {
    private String id;
    private String name;
    private String code;
    private String warehouseId;
    private String testCenterId;
    private String equipmentTypeId;
    private boolean auto;
    private boolean isMeasuring;
    private String manufacturerId;
    private String specification;
    private String measuringRange;
    private String accuracyValue;
    private String uncertainty;
    private String calibrationMechanism;
    private Date validityDate;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;
    private EquipmentType equipmentType;
    private Manufacturer manufacturer;

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
    @Column(name = "WarehouseId")
    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Basic
    @Column(name = "TestCenterId")
    public String getTestCenterId() {
        return testCenterId;
    }

    public void setTestCenterId(String testCenterId) {
        this.testCenterId = testCenterId;
    }

    @Basic
    @Column(name = "equipmentTypeId")
    public String getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(String EquipmentTypeId) {
        this.equipmentTypeId = EquipmentTypeId;
    }

    @Basic
    @Column(name = "Auto")
    public boolean getAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    @Basic
    @Column(name = "IsMeasuring")
    public boolean getIsMeasuring() {
        return isMeasuring;
    }

    public void setIsMeasuring(boolean isMeasuring) {
        this.isMeasuring = isMeasuring;
    }

    @Basic
    @Column(name = "ManufacturerId")
    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Basic
    @Column(name = "Specification")
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "MeasuringRange")
    public String getMeasuringRange() {
        return measuringRange;
    }

    public void setMeasuringRange(String measuringRange) {
        this.measuringRange = measuringRange;
    }

    @Basic
    @Column(name = "AccuracyValue")
    public String getAccuracyValue() {
        return accuracyValue;
    }

    public void setAccuracyValue(String accuracyValue) {
        this.accuracyValue = accuracyValue;
    }

    @Basic
    @Column(name = "Uncertainty")
    public String getUncertainty() {
        return uncertainty;
    }

    public void setUncertainty(String uncertainty) {
        this.uncertainty = uncertainty;
    }

    @Basic
    @Column(name = "CalibrationMechanism")
    public String getCalibrationMechanism() {
        return calibrationMechanism;
    }

    public void setCalibrationMechanism(String calibrationMechanism) {
        this.calibrationMechanism = calibrationMechanism;
    }

    @Basic
    @Column(name = "ValidityDate")
    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
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
        Equipment that = (Equipment) o;
        return published == that.published &&
                deleted == that.deleted &&
                displayOrder == that.displayOrder &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(warehouseId, that.warehouseId) &&
                Objects.equals(testCenterId, that.testCenterId) &&
                Objects.equals(equipmentTypeId, that.equipmentTypeId) &&
                Objects.equals(auto, that.auto) &&
                Objects.equals(isMeasuring, that.isMeasuring) &&
                Objects.equals(manufacturerId, that.manufacturerId) &&
                Objects.equals(specification, that.specification) &&
                Objects.equals(measuringRange, that.measuringRange) &&
                Objects.equals(accuracyValue, that.accuracyValue) &&
                Objects.equals(uncertainty, that.uncertainty) &&
                Objects.equals(calibrationMechanism, that.calibrationMechanism) &&
                Objects.equals(validityDate, that.validityDate) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, warehouseId, testCenterId, equipmentTypeId, auto, isMeasuring, manufacturerId, specification, measuringRange, accuracyValue, uncertainty, calibrationMechanism, validityDate, published, deleted, displayOrder, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "equipmentTypeId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    @ManyToOne
    @JoinColumn(name = "ManufacturerId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
