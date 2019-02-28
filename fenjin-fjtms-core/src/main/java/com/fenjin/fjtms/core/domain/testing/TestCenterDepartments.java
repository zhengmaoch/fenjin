package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.products.Department;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "testcenterdepartments")
public class TestCenterDepartments {
    private String id;
    private String testCenterId;
    private String departmentId;
    private String departmentCategoryId;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private TestCenter testCenter;
    private Department department;

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
    @Column(name = "DepartmentId")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "DepartmentCategoryId")
    public String getDepartmentCategoryId() {
        return departmentCategoryId;
    }

    public void setDepartmentCategoryId(String departmentCategoryId) {
        this.departmentCategoryId = departmentCategoryId;
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
        TestCenterDepartments that = (TestCenterDepartments) o;
        return deleted == that.deleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(testCenterId, that.testCenterId) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(departmentCategoryId, that.departmentCategoryId) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testCenterId, departmentId, departmentCategoryId, deleted, createdTime, updatedTime);
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
    @JoinColumn(name = "DepartmentId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
