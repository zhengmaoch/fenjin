package com.fenjin.fjtms.core.domain.products;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "departmentusers")
public class DepartmentUsers implements Serializable {
    private String id;
    private String userId;
    private String departmentId;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;

    @Basic
    @Column(name = "Id")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "UserId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        DepartmentUsers that = (DepartmentUsers) o;
        return deleted == that.deleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, departmentId, deleted, createdTime, updatedTime);
    }

}
