package com.fenjin.fjtms.core.domain.products;

import com.fenjin.fjtms.core.domain.testing.ProjectCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    private String id;
    private String name;
    private String alias;
    private String code;
    private String specifications;
    private String extensionCode;
    private String description;
    private String parentCategoryId;
    private String projectCategoryId;
    private String pictureId;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;
    private Category parentCategory;
    private ProjectCategory projectCategory;

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
    @Column(name = "Alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
    @Column(name = "Specifications")
    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
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
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ParentCategoryId")
    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    @Basic
    @Column(name = "ProjectCategoryId")
    public String getProjectCategoryId() {
        return projectCategoryId;
    }

    public void setProjectCategoryId(String projectCategoryId) {
        this.projectCategoryId = projectCategoryId;
    }

    @Basic
    @Column(name = "PictureId")
    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
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
        Category Category = (Category) o;
        return published == Category.published &&
                deleted == Category.deleted &&
                displayOrder == Category.displayOrder &&
                Objects.equals(id, Category.id) &&
                Objects.equals(name, Category.name) &&
                Objects.equals(alias, Category.alias) &&
                Objects.equals(code, Category.code) &&
                Objects.equals(specifications, Category.specifications) &&
                Objects.equals(extensionCode, Category.extensionCode) &&
                Objects.equals(description, Category.description) &&
                Objects.equals(parentCategoryId, Category.parentCategoryId) &&
                Objects.equals(projectCategoryId, Category.projectCategoryId) &&
                Objects.equals(pictureId, Category.pictureId) &&
                Objects.equals(createdTime, Category.createdTime) &&
                Objects.equals(updatedTime, Category.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, alias, code, specifications, extensionCode, description, parentCategoryId, projectCategoryId, pictureId, published, deleted, displayOrder, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "ParentCategoryId", referencedColumnName = "Id", insertable = false, updatable = false)
    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category CategoryByParentCategoryId) {
        this.parentCategory = CategoryByParentCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "ProjectCategoryId", referencedColumnName = "Id", insertable = false, updatable = false)
    public ProjectCategory getProjectCategoryByProjectCategoryId() {
        return projectCategory;
    }

    public void setProjectCategoryByProjectCategoryId(ProjectCategory projectCategory) {
        this.projectCategory = projectCategory;
    }

}
