package com.fenjin.fjtms.core.domain.configuration;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "setting")
public class Setting {
    private String id;
    private String name;
    private String value;

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
    @Column(name = "Value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Setting Setting = (Setting) o;
        return Objects.equals(id, Setting.id) &&
                Objects.equals(name, Setting.name) &&
                Objects.equals(value, Setting.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value);
    }
}
