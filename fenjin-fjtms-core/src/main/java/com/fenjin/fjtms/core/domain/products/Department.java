package com.fenjin.fjtms.core.domain.products;

import com.fenjin.fjtms.core.domain.common.Area;
import com.fenjin.fjtms.core.domain.users.User;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "fjtms")
public class Department implements Serializable {
    private String id;
    private String name;
    private String code;
    private String extensionCode;
    private String parentDepartmentId;
    private String level;
    private String areaId;
    private Integer departmentType;
    private String manager;
    private String phoneNumber;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;
    private Department parentDepartment;
    private Area area;

    @ManyToMany(mappedBy = "User")
    private List<User> users;

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
    @Column(name = "ExtensionCode")
    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode;
    }

    @Basic
    @Column(name = "ParentDepartmentId")
    public String getParentDepartmentId() {
        return parentDepartmentId;
    }

    public void setParentDepartmentId(String parentDepartmentId) {
        this.parentDepartmentId = parentDepartmentId;
    }

    @Basic
    @Column(name = "Level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "AreaId")
    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "DepartmentType")
    public Integer getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(Integer departmentType) {
        this.departmentType = departmentType;
    }

    @Basic
    @Column(name = "Manager")
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Basic
    @Column(name = "PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        Department that = (Department) o;
        return published == that.published &&
                deleted == that.deleted &&
                displayOrder == that.displayOrder &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(extensionCode, that.extensionCode) &&
                Objects.equals(parentDepartmentId, that.parentDepartmentId) &&
                Objects.equals(level, that.level) &&
                Objects.equals(areaId, that.areaId) &&
                Objects.equals(departmentType, that.departmentType) &&
                Objects.equals(manager, that.manager) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, extensionCode, parentDepartmentId, level, areaId, departmentType, manager, phoneNumber, published, deleted, displayOrder, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "ParentDepartmentId", referencedColumnName = "Id", insertable = false, updatable = false)
    public Department getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Department department) {
        this.parentDepartment = department;
    }

    @ManyToOne
    @JoinColumn(name = "AreaId", referencedColumnName = "Id", insertable = false, updatable = false)
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
