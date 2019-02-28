package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.products.VoltageLevel;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "project")
public class Project {
    private String id;
    private String name;
    private String standardId;
    private String projectTypeId;
    private String projectCategoryId;
    private String voltageLevelId;
    private double withstandVoltage;
    private int length;
    private int duration;
    private int pressurizationTimes;
    private double maxLeakageCurrent;
    private double sectionalArea;
    private double resistance;
    private double shielding;
    private int ratedLoad;
    private int testLoad;
    private int ratedPressure;
    private int speed;
    private String position;
    private int cycle;
    private int depth;
    private String requirement;
    private String description;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;
    private Standard standard;
    private ProjectType projectType;
    private ProjectCategory projectCategory;
    private VoltageLevel voltageLevel;

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
    @Column(name = "StandardId")
    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    @Basic
    @Column(name = "projectTypeId")
    public String getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(String ProjectTypeId) {
        this.projectTypeId = ProjectTypeId;
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
    @Column(name = "VoltageLevelId")
    public String getVoltageLevelId() {
        return voltageLevelId;
    }

    public void setVoltageLevelId(String voltageLevelId) {
        this.voltageLevelId = voltageLevelId;
    }

    @Basic
    @Column(name = "WithstandVoltage")
    public double getWithstandVoltage() {
        return withstandVoltage;
    }

    public void setWithstandVoltage(double withstandVoltage) {
        this.withstandVoltage = withstandVoltage;
    }

    @Basic
    @Column(name = "Length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Basic
    @Column(name = "Duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "PressurizationTimes")
    public int getPressurizationTimes() {
        return pressurizationTimes;
    }

    public void setPressurizationTimes(int pressurizationTimes) {
        this.pressurizationTimes = pressurizationTimes;
    }

    @Basic
    @Column(name = "MaxLeakageCurrent")
    public double getMaxLeakageCurrent() {
        return maxLeakageCurrent;
    }

    public void setMaxLeakageCurrent(double maxLeakageCurrent) {
        this.maxLeakageCurrent = maxLeakageCurrent;
    }

    @Basic
    @Column(name = "SectionalArea")
    public double getSectionalArea() {
        return sectionalArea;
    }

    public void setSectionalArea(double sectionalArea) {
        this.sectionalArea = sectionalArea;
    }

    @Basic
    @Column(name = "Resistance")
    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    @Basic
    @Column(name = "Shielding")
    public double getShielding() {
        return shielding;
    }

    public void setShielding(double shielding) {
        this.shielding = shielding;
    }

    @Basic
    @Column(name = "RatedLoad")
    public int getRatedLoad() {
        return ratedLoad;
    }

    public void setRatedLoad(int ratedLoad) {
        this.ratedLoad = ratedLoad;
    }

    @Basic
    @Column(name = "TestLoad")
    public int getTestLoad() {
        return testLoad;
    }

    public void setTestLoad(int testLoad) {
        this.testLoad = testLoad;
    }

    @Basic
    @Column(name = "RatedPressure")
    public int getRatedPressure() {
        return ratedPressure;
    }

    public void setRatedPressure(int ratedPressure) {
        this.ratedPressure = ratedPressure;
    }

    @Basic
    @Column(name = "Speed")
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "Position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "Cycle")
    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    @Basic
    @Column(name = "Depth")
    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Basic
    @Column(name = "Requirement")
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
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
        Project Project = (Project) o;
        return Double.compare(Project.withstandVoltage, withstandVoltage) == 0 &&
                length == Project.length &&
                duration == Project.duration &&
                pressurizationTimes == Project.pressurizationTimes &&
                Double.compare(Project.maxLeakageCurrent, maxLeakageCurrent) == 0 &&
                Double.compare(Project.sectionalArea, sectionalArea) == 0 &&
                Double.compare(Project.resistance, resistance) == 0 &&
                Double.compare(Project.shielding, shielding) == 0 &&
                ratedLoad == Project.ratedLoad &&
                testLoad == Project.testLoad &&
                ratedPressure == Project.ratedPressure &&
                speed == Project.speed &&
                cycle == Project.cycle &&
                depth == Project.depth &&
                published == Project.published &&
                deleted == Project.deleted &&
                displayOrder == Project.displayOrder &&
                Objects.equals(id, Project.id) &&
                Objects.equals(name, Project.name) &&
                Objects.equals(standardId, Project.standardId) &&
                Objects.equals(projectTypeId, Project.projectTypeId) &&
                Objects.equals(projectCategoryId, Project.projectCategoryId) &&
                Objects.equals(voltageLevelId, Project.voltageLevelId) &&
                Objects.equals(position, Project.position) &&
                Objects.equals(requirement, Project.requirement) &&
                Objects.equals(description, Project.description) &&
                Objects.equals(createdTime, Project.createdTime) &&
                Objects.equals(updatedTime, Project.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, standardId, projectTypeId, projectCategoryId, voltageLevelId, withstandVoltage, length, duration, pressurizationTimes, maxLeakageCurrent, sectionalArea, resistance, shielding, ratedLoad, testLoad, ratedPressure, speed, position, cycle, depth, requirement, description, published, deleted, displayOrder, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "StandardId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @ManyToOne
    @JoinColumn(name = "projectTypeId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    @ManyToOne
    @JoinColumn(name = "ProjectCategoryId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public ProjectCategory getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(ProjectCategory projectCategory) {
        this.projectCategory = projectCategory;
    }

    @ManyToOne
    @JoinColumn(name = "VoltageLevelId", referencedColumnName = "Id", insertable = false, updatable = false)
    public VoltageLevel getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(VoltageLevel voltageLevel) {
        this.voltageLevel = voltageLevel;
    }
}
