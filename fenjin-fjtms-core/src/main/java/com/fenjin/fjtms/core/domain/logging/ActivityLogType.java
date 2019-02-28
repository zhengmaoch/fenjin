package com.fenjin.fjtms.core.domain.logging;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "activitylogtype")
public class ActivityLogType implements Serializable {
    private String id;
    private String systemKeyword;
    private String name;
    private boolean enabled;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SystemKeyword")
    public String getSystemKeyword() {
        return systemKeyword;
    }

    public void setSystemKeyword(String systemKeyword) {
        this.systemKeyword = systemKeyword;
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
    @Column(name = "Enabled")
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityLogType that = (ActivityLogType) o;
        return enabled == that.enabled &&
                Objects.equals(id, that.id) &&
                Objects.equals(systemKeyword, that.systemKeyword) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, systemKeyword, name, enabled);
    }
}
