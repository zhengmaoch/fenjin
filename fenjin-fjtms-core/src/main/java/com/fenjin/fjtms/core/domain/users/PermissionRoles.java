package com.fenjin.fjtms.core.domain.users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "permissionroles")
public class PermissionRoles implements Serializable {
    private String permissionId;
    private String roleId;

    @Id
    @Column(name = "Permission_Id")
    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Id
    @Column(name = "Role_Id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionRoles that = (PermissionRoles) o;
        return Objects.equals(permissionId, that.permissionId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, roleId);
    }

}
