package com.fenjin.fjtms.core.domain.testing;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "standard")
public class Standard {
    private String id;
    private String code;
    private String name;
    private int standardTypeId;
    private Date publishDate;
    private String publisher;
    private Date effectiveDate;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "StandardTypeId")
    public int geStandardTypeId() {
        return standardTypeId;
    }

    public void seStandardTypeId(int standardTypeId) {
        this.standardTypeId = standardTypeId;
    }

    @Basic
    @Column(name = "PublishDate")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "Publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "EffectiveDate")
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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
        Standard Standard = (Standard) o;
        return standardTypeId == Standard.standardTypeId &&
                published == Standard.published &&
                deleted == Standard.deleted &&
                displayOrder == Standard.displayOrder &&
                Objects.equals(id, Standard.id) &&
                Objects.equals(code, Standard.code) &&
                Objects.equals(name, Standard.name) &&
                Objects.equals(publishDate, Standard.publishDate) &&
                Objects.equals(publisher, Standard.publisher) &&
                Objects.equals(effectiveDate, Standard.effectiveDate) &&
                Objects.equals(createdTime, Standard.createdTime) &&
                Objects.equals(updatedTime, Standard.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, standardTypeId, publishDate, publisher, effectiveDate, published, deleted, displayOrder, createdTime, updatedTime);
    }

}
