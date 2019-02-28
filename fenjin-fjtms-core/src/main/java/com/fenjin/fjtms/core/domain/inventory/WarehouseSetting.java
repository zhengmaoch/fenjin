package com.fenjin.fjtms.core.domain.inventory;

import com.fenjin.fjtms.core.domain.products.Category;
import com.fenjin.fjtms.core.domain.products.VoltageLevel;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "warehousesetting")
public class WarehouseSetting {
    private String id;
    private String warehouseTypeId;
    private String categoryId;
    private String voltageLevelId;
    private int count;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;
    private WarehouseType warehouseType;
    private Category category;
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
    @Column(name = "WarehouseTypeId")
    public String getWarehouseTypeId() {
        return warehouseTypeId;
    }

    public void setWarehouseTypeId(String warehouseTypeId) {
        this.warehouseTypeId = warehouseTypeId;
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
    @Column(name = "VoltageLevelId")
    public String getVoltageLevelId() {
        return voltageLevelId;
    }

    public void setVoltageLevelId(String voltageLevelId) {
        this.voltageLevelId = voltageLevelId;
    }

    @Basic
    @Column(name = "Count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
        WarehouseSetting that = (WarehouseSetting) o;
        return count == that.count &&
                published == that.published &&
                deleted == that.deleted &&
                displayOrder == that.displayOrder &&
                Objects.equals(id, that.id) &&
                Objects.equals(warehouseTypeId, that.warehouseTypeId) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(voltageLevelId, that.voltageLevelId) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, warehouseTypeId, categoryId, voltageLevelId, count, published, deleted, displayOrder, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "WarehouseTypeId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public WarehouseType getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(WarehouseType warehouseType) {
        this.warehouseType = warehouseType;
    }

    @ManyToOne
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "VoltageLevelId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public VoltageLevel getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(VoltageLevel voltageLevel) {
        this.voltageLevel = voltageLevel;
    }
}
