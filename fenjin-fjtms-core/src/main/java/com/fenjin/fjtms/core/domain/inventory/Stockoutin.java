package com.fenjin.fjtms.core.domain.inventory;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "stockoutin")
public class Stockoutin {
    private String id;
    private String userId;
    private String warehouseId;
    private String workNumber;
    private boolean process;
    private boolean isStockOut;
    private String description;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private Warehouse warehouse;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UserId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    @Column(name = "WorkNumber")
    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    @Basic
    @Column(name = "Process")
    public boolean getProcess() {
        return process;
    }

    public void setProcess(boolean process) {
        this.process = process;
    }

    @Basic
    @Column(name = "IsStockOut")
    public boolean getIsStockOut() {
        return isStockOut;
    }

    public void setIsStockOut(boolean isStockOut) {
        this.isStockOut = isStockOut;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Stockoutin that = (Stockoutin) o;
        return process == that.process &&
                isStockOut == that.isStockOut &&
                deleted == that.deleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(warehouseId, that.warehouseId) &&
                Objects.equals(workNumber, that.workNumber) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, warehouseId, workNumber, process, isStockOut, description, deleted, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "WarehouseId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

}
