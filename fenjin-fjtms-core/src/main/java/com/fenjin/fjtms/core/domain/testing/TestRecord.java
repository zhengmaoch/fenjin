package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.common.Equipment;
import com.fenjin.fjtms.core.domain.products.Product;
import com.fenjin.fjtms.core.domain.users.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "testrecord")
public class TestRecord {
    private String id;
    private String testId;
    private String productId;
    private String rfid;
    private String projectId;
    private String equipmentId;
    private boolean isPass;
    private Date testTime;
    private Date nexTestTime;
    private int cycle;
    private String testValue;
    private int duration;
    private int pressurizationTimes;
    private double leakageVoltage;
    private double leakageCurrent;
    private int leakageTime;
    private double sectionalArea;
    private double shielding;
    private int speed;
    private String testDataPictureId;
    private String userId;
    private String certificateId;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;
    private Test test;
    private Product product;
    private Project project;
    private Equipment equipment;
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
    @Column(name = "TestId")
    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "ProductId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "RFID")
    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    @Basic
    @Column(name = "ProjectId")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "EquipmentId")
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Basic
    @Column(name = "IsPass")
    public boolean getIsPass() {
        return isPass;
    }

    public void setIsPass(boolean isPass) {
        this.isPass = isPass;
    }

    @Basic
    @Column(name = "TestTime")
    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    @Basic
    @Column(name = "NexTestTime")
    public Date getNexTestTime() {
        return nexTestTime;
    }

    public void setNexTestTime(Date nexTestTime) {
        this.nexTestTime = nexTestTime;
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
    @Column(name = "TestValue")
    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
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
    @Column(name = "LeakageVoltage")
    public double getLeakageVoltage() {
        return leakageVoltage;
    }

    public void setLeakageVoltage(double leakageVoltage) {
        this.leakageVoltage = leakageVoltage;
    }

    @Basic
    @Column(name = "LeakageCurrent")
    public double getLeakageCurrent() {
        return leakageCurrent;
    }

    public void setLeakageCurrent(double leakageCurrent) {
        this.leakageCurrent = leakageCurrent;
    }

    @Basic
    @Column(name = "LeakageTime")
    public int getLeakageTime() {
        return leakageTime;
    }

    public void setLeakageTime(int leakageTime) {
        this.leakageTime = leakageTime;
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
    @Column(name = "Shielding")
    public double getShielding() {
        return shielding;
    }

    public void setShielding(double shielding) {
        this.shielding = shielding;
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
    @Column(name = "TestDataPictureId")
    public String getTestDataPictureId() {
        return testDataPictureId;
    }

    public void setTestDataPictureId(String testDataPictureId) {
        this.testDataPictureId = testDataPictureId;
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
    @Column(name = "CertificateId")
    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
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
        TestRecord that = (TestRecord) o;
        return cycle == that.cycle &&
                duration == that.duration &&
                pressurizationTimes == that.pressurizationTimes &&
                Double.compare(that.leakageVoltage, leakageVoltage) == 0 &&
                Double.compare(that.leakageCurrent, leakageCurrent) == 0 &&
                leakageTime == that.leakageTime &&
                Double.compare(that.sectionalArea, sectionalArea) == 0 &&
                Double.compare(that.shielding, shielding) == 0 &&
                speed == that.speed &&
                deleted == that.deleted &&
                displayOrder == that.displayOrder &&
                Objects.equals(id, that.id) &&
                Objects.equals(testId, that.testId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(rfid, that.rfid) &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(equipmentId, that.equipmentId) &&
                Objects.equals(isPass, that.isPass) &&
                Objects.equals(testTime, that.testTime) &&
                Objects.equals(nexTestTime, that.nexTestTime) &&
                Objects.equals(testValue, that.testValue) &&
                Objects.equals(testDataPictureId, that.testDataPictureId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(certificateId, that.certificateId) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testId, productId, rfid, projectId, equipmentId, isPass, testTime, nexTestTime, cycle, testValue, duration, pressurizationTimes, leakageVoltage, leakageCurrent, leakageTime, sectionalArea, shielding, speed, testDataPictureId, userId, certificateId, deleted, displayOrder, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "TestId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @ManyToOne
    @JoinColumn(name = "ProductId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "ProjectId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @ManyToOne
    @JoinColumn(name = "EquipmentId", referencedColumnName = "Id", insertable = false, updatable = false)
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
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
