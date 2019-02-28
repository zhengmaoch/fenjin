package com.fenjin.fjtms.core.domain.products;

import com.fenjin.fjtms.core.domain.inventory.Warehouse;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    private String id;
    private String name;
    private String rfid;
    private String categoryId;
    private String warehouseId;
    private String manufacturerId;
    private String specification;
    private String voltageLevelId;
    private Date testDate;
    private Date nexTestDate;
    private String status;
    private String stockStatus;
    private boolean isMaster;
    private String groupId;
    private String scrapReason;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private Category category;
    private Warehouse warehouse;
    private Manufacturer manufacturer;
    private VoltageLevel voltageLevel;

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
    @Column(name = "RFID")
    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    @Basic
    @Column(name = "CategoryId")
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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
    @Column(name = "VoltageLevelId")
    public String getVoltageLevelId() {
        return voltageLevelId;
    }

    public void setVoltageLevelId(String voltageLevelId) {
        this.voltageLevelId = voltageLevelId;
    }

    @Basic
    @Column(name = "TestDate")
    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    @Basic
    @Column(name = "NexTestDate")
    public Date getNexTestDate() {
        return nexTestDate;
    }

    public void setNexTestDate(Date nexTestDate) {
        this.nexTestDate = nexTestDate;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "StockStatus")
    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Basic
    @Column(name = "IsMaster")
    public boolean getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(boolean isMaster) {
        this.isMaster = isMaster;
    }

    @Basic
    @Column(name = "GroupId")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "ScrapReason")
    public String getScrapReason() {
        return scrapReason;
    }

    public void setScrapReason(String scrapReason) {
        this.scrapReason = scrapReason;
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
        Product Product = (Product) o;
        return deleted == Product.deleted &&
                Objects.equals(id, Product.id) &&
                Objects.equals(name, Product.name) &&
                Objects.equals(rfid, Product.rfid) &&
                Objects.equals(categoryId, Product.categoryId) &&
                Objects.equals(warehouseId, Product.warehouseId) &&
                Objects.equals(manufacturerId, Product.manufacturerId) &&
                Objects.equals(specification, Product.specification) &&
                Objects.equals(voltageLevelId, Product.voltageLevelId) &&
                Objects.equals(testDate, Product.testDate) &&
                Objects.equals(nexTestDate, Product.nexTestDate) &&
                Objects.equals(status, Product.status) &&
                Objects.equals(stockStatus, Product.stockStatus) &&
                Objects.equals(isMaster, Product.isMaster) &&
                Objects.equals(groupId, Product.groupId) &&
                Objects.equals(scrapReason, Product.scrapReason) &&
                Objects.equals(createdTime, Product.createdTime) &&
                Objects.equals(updatedTime, Product.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rfid, categoryId, warehouseId, manufacturerId, specification, voltageLevelId, testDate, nexTestDate, status, stockStatus, isMaster, groupId, scrapReason, deleted, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category CategoryByCategoryId) {
        this.category = CategoryByCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "WarehouseId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse WarehouseByWarehouseId) {
        this.warehouse = WarehouseByWarehouseId;
    }

    @ManyToOne
    @JoinColumn(name = "ManufacturerId", referencedColumnName = "Id", insertable = false, updatable = false)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer ManufacturerByManufacturerId) {
        this.manufacturer = ManufacturerByManufacturerId;
    }

    @ManyToOne
    @JoinColumn(name = "VoltageLevelId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public VoltageLevel getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(VoltageLevel VoltageLevelByVoltageLevelId) {
        this.voltageLevel = VoltageLevelByVoltageLevelId;
    }
}
