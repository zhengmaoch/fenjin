package com.fenjin.fjtms.core.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    private String id;
    private String name;
    private boolean active;
    private boolean isSystemRole;
    private String systemName;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private List<Permission> permissions = new ArrayList<>();

    @Id
    @Column(name = "Id")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
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
    @Column(name = "Active")
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "IsSystemRole")
    public boolean getIsSystemRole() {
        return isSystemRole;
    }

    public void setIsSystemRole(boolean isSystemRole) {
        this.isSystemRole = isSystemRole;
    }

    @Basic
    @Column(name = "SystemName")
    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
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
        Role Role = (Role) o;
        return active == Role.active &&
                isSystemRole == Role.isSystemRole &&
                deleted == Role.deleted &&
                Objects.equals(id, Role.id) &&
                Objects.equals(name, Role.name) &&
                Objects.equals(systemName, Role.systemName) &&
                Objects.equals(createdTime, Role.createdTime) &&
                Objects.equals(updatedTime, Role.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active, isSystemRole, systemName, deleted, createdTime, updatedTime);
    }

    @ManyToMany
//    @JsonIgnore
    @JoinTable(name = "RolePermissions",joinColumns=@JoinColumn(name="RoleId"),inverseJoinColumns=@JoinColumn(name="PermissionId"))
    public List<Permission> getPermissions(){
        return permissions;
    }

    public void setPermissions(List<Permission> roles){
        this.permissions = permissions;
    }
}
