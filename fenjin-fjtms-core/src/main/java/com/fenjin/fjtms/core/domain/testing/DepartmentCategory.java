package com.fenjin.fjtms.core.domain.testing;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "departmentcategory")
public class DepartmentCategory {
    private String id;
    private String name;
    private String testCenterId;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;
    private TestCenter testCenter;

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
    @Column(name = "TestCenterId")
    public String getTestCenterId() {
        return testCenterId;
    }

    public void setTestCenterId(String testCenterId) {
        this.testCenterId = testCenterId;
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
        DepartmentCategory that = (DepartmentCategory) o;
        return published == that.published &&
                deleted == that.deleted &&
                displayOrder == that.displayOrder &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(testCenterId, that.testCenterId) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, testCenterId, published, deleted, displayOrder, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "TestCenterId", referencedColumnName = "Id", insertable = false, updatable = false)
    public TestCenter getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(TestCenter testCenter) {
        this.testCenter = testCenter;
    }
}
