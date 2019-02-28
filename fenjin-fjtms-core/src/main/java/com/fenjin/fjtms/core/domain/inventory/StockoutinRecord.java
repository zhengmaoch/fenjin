package com.fenjin.fjtms.core.domain.inventory;

import com.fenjin.fjtms.core.domain.products.Product;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "stockoutinrecord")
public class StockoutinRecord {
    private String id;
    private String stockOutInId;
    private String productId;
    private String rfid;
    private boolean isStockOut;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private Stockoutin stockoutin;
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
    @Column(name = "StockOutInId")
    public String getStockOutInId() {
        return stockOutInId;
    }

    public void setStockOutInId(String stockOutInId) {
        this.stockOutInId = stockOutInId;
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
    @Column(name = "IsStockOut")
    public boolean getIsStockOut() {
        return isStockOut;
    }

    public void setIsStockOut(boolean isStockOut) {
        this.isStockOut = isStockOut;
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
        StockoutinRecord that = (StockoutinRecord) o;
        return isStockOut == that.isStockOut &&
                deleted == that.deleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(stockOutInId, that.stockOutInId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(rfid, that.rfid) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stockOutInId, productId, rfid, isStockOut, deleted, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "StockOutInId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Stockoutin getStockoutin() {
        return stockoutin;
    }

    public void setStockoutin(Stockoutin stockoutin) {
        this.stockoutin = stockoutin;
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
