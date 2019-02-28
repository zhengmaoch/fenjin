package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.products.Category;
import com.fenjin.fjtms.core.domain.products.VoltageLevel;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "testfee")
public class TestFee {
    private String id;
    private String testCenterId;
    private String categoryId;
    private String voltageLevelId;
    private String specification;
    private double price;
    private String unit;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private TestCenter testCenter;
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
    @Column(name = "TestCenterId")
    public String getTestCenterId() {
        return testCenterId;
    }

    public void setTestCenterId(String testCenterId) {
        this.testCenterId = testCenterId;
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
    @Column(name = "Specification")
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "Price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
        TestFee TestFee = (TestFee) o;
        return Double.compare(TestFee.price, price) == 0 &&
                deleted == TestFee.deleted &&
                Objects.equals(id, TestFee.id) &&
                Objects.equals(testCenterId, TestFee.testCenterId) &&
                Objects.equals(categoryId, TestFee.categoryId) &&
                Objects.equals(voltageLevelId, TestFee.voltageLevelId) &&
                Objects.equals(specification, TestFee.specification) &&
                Objects.equals(unit, TestFee.unit) &&
                Objects.equals(createdTime, TestFee.createdTime) &&
                Objects.equals(updatedTime, TestFee.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testCenterId, categoryId, voltageLevelId, specification, price, unit, deleted, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "TestCenterId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public TestCenter getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(TestCenter testCenter) {
        this.testCenter = testCenter;
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
