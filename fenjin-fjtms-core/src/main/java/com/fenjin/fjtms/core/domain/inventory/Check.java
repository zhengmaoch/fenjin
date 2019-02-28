package com.fenjin.fjtms.core.domain.inventory;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "check")
public class Check {
    private String id;
    private String userId;
    private String warehouseId;
    private int type;
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
    @Column(name = "Type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
        Check Check = (Check) o;
        return type == Check.type &&
                deleted == Check.deleted &&
                Objects.equals(id, Check.id) &&
                Objects.equals(userId, Check.userId) &&
                Objects.equals(warehouseId, Check.warehouseId) &&
                Objects.equals(createdTime, Check.createdTime) &&
                Objects.equals(updatedTime, Check.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, warehouseId, type, deleted, createdTime, updatedTime);
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
