package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.products.Category;
import com.fenjin.fjtms.core.domain.products.VoltageLevel;
import com.fenjin.fjtms.core.domain.users.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "inspectionrecord")
public class InspectionRecord {
    private String id;
    private String inspectionId;
    private String categoryId;
    private String voltageLevelId;
    private String specification;
    private int number;
    private String unit;
    private Double price;
    private String check;
    private String project;
    private String userId;
    private String description;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private Inspection inspection;
    private Category category;
    private VoltageLevel voltageLevel;
    private User user;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "InspectionId")
    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId;
    }

    @Basic
    @Column(name = "CategoryId")
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "VoltageLevelId")
    public String getVoltageLevelId() {
        return voltageLevelId;
    }

    public void setVoltageLevelId(String voltageLevelId) {
        this.voltageLevelId = voltageLevelId;
    }

    @Basic
    @Column(name = "Specification")
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "Number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "Unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "Price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Check")
    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    @Basic
    @Column(name = "Project")
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Basic
    @Column(name = "UserId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        InspectionRecord that = (InspectionRecord) o;
        return number == that.number &&
                deleted == that.deleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(inspectionId, that.inspectionId) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(voltageLevelId, that.voltageLevelId) &&
                Objects.equals(specification, that.specification) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(price, that.price) &&
                Objects.equals(check, that.check) &&
                Objects.equals(project, that.project) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inspectionId, categoryId, voltageLevelId, specification, number, unit, price, check, project, userId, description, deleted, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "InspectionId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Inspection getInspection() {
        return inspection;
    }

    public void setInspection(Inspection inspection) {
        this.inspection = inspection;
    }

    @ManyToOne
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "VoltageLevelId", referencedColumnName = "Id", insertable = false, updatable = false)
    public VoltageLevel getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(VoltageLevel voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
