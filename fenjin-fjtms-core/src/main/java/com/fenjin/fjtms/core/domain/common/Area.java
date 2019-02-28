package com.fenjin.fjtms.core.domain.common;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "area")
public class Area {
    private String id;
    private String name;
    private String code;
    private String extensionCode;
    private String number;
    private String parentAreaId;
    private Integer level;
    private Double longitude;
    private Double latitude;
    private Double altitude;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;
    private Area area;
    private Collection<Area> areas;

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
    @Column(name = "Number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "ParentAreaId")
    public String getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(String parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    @Basic
    @Column(name = "Level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "Longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "Latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "Altitude")
    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
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
        Area Area = (Area) o;
        return published == Area.published &&
                deleted == Area.deleted &&
                displayOrder == Area.displayOrder &&
                Objects.equals(id, Area.id) &&
                Objects.equals(name, Area.name) &&
                Objects.equals(code, Area.code) &&
                Objects.equals(extensionCode, Area.extensionCode) &&
                Objects.equals(number, Area.number) &&
                Objects.equals(parentAreaId, Area.parentAreaId) &&
                Objects.equals(level, Area.level) &&
                Objects.equals(longitude, Area.longitude) &&
                Objects.equals(latitude, Area.latitude) &&
                Objects.equals(altitude, Area.altitude) &&
                Objects.equals(createdTime, Area.createdTime) &&
                Objects.equals(updatedTime, Area.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, extensionCode, number, parentAreaId, level, longitude, latitude, altitude, published, deleted, displayOrder, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "ParentAreaId", referencedColumnName = "Id", insertable = false, updatable = false)
    public Area getArea() {
        return area;
    }

    public void setArea(Area AreaByParentAreaId) {
        this.area = AreaByParentAreaId;
    }

    @OneToMany(mappedBy = "area")
    public Collection<Area> getAreas() {
        return areas;
    }

    public void setAreas(Collection<Area> AreasById) {
        this.areas = AreasById;
    }
}
