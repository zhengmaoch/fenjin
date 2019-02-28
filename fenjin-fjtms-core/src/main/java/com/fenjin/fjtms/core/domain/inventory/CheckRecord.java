package com.fenjin.fjtms.core.domain.inventory;

import com.fenjin.fjtms.core.domain.products.Product;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "CheckRecord")
public class CheckRecord {
    private String id;
    private String checkId;
    private String productId;
    private String rfid;
    private String description;
    private boolean status;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private Check check;
    private Product product;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CheckId")
    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "ProductId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Status")
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        CheckRecord that = (CheckRecord) o;
        return status == that.status &&
                deleted == that.deleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(checkId, that.checkId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(rfid, that.rfid) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkId, productId, rfid, description, status, deleted, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "CheckId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    @ManyToOne
    @JoinColumn(name = "ProductId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
