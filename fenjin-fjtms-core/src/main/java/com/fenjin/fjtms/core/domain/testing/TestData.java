package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.users.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "testdata")
public class TestData {
    private String id;
    private String rfid;
    private Integer rfidSource;
    private String projectId;
    private String projectCategoryId;
    private double rateVoltage;
    private double withstandVoltage;
    private int pressurizationTimes;
    private double maxLeakageCurrent;
    private int length;
    private int staticTension;
    private String position;
    private int duration;
    private String testValue;
    private double leakageVoltage;
    private double leakageCurrent;
    private int leakageTime;
    private double sectionalArea;
    private double shielding;
    private int speed;
    private String pictureId;
    private double temperature;
    private double humidity;
    private double pressure;
    private double altitude;
    private boolean isPass;
    private String userId;
    private String testCenterId;
    private Date createdTime;
    private Date updatedTime;
    private Project project;
    private ProjectCategory projectCategory;
    private User user;
    private TestCenter testCenter;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "RFIDSource")
    public Integer getRfidSource() {
        return rfidSource;
    }

    public void setRfidSource(Integer rfidSource) {
        this.rfidSource = rfidSource;
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
    @Column(name = "ProjectCategoryId")
    public String getProjectCategoryId() {
        return projectCategoryId;
    }

    public void setProjectCategoryId(String projectCategoryId) {
        this.projectCategoryId = projectCategoryId;
    }

    @Basic
    @Column(name = "RateVoltage")
    public double getRateVoltage() {
        return rateVoltage;
    }

    public void setRateVoltage(double rateVoltage) {
        this.rateVoltage = rateVoltage;
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
    @Column(name = "Length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Basic
    @Column(name = "StaticTension")
    public int getStaticTension() {
        return staticTension;
    }

    public void setStaticTension(int staticTension) {
        this.staticTension = staticTension;
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
    @Column(name = "Duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
    @Column(name = "PictureId")
    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    @Basic
    @Column(name = "Temperature")
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "Humidity")
    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Basic
    @Column(name = "Pressure")
    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @Basic
    @Column(name = "Altitude")
    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
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
    @Column(name = "UserId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "TestCenterId")
    public String getTestCenterId() {
        return testCenterId;
    }

    public void setTestCenterId(String testCenterId) {
        this.testCenterId = testCenterId;
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
        TestData Testdata = (TestData) o;
        return Double.compare(Testdata.rateVoltage, rateVoltage) == 0 &&
                Double.compare(Testdata.withstandVoltage, withstandVoltage) == 0 &&
                pressurizationTimes == Testdata.pressurizationTimes &&
                Double.compare(Testdata.maxLeakageCurrent, maxLeakageCurrent) == 0 &&
                length == Testdata.length &&
                staticTension == Testdata.staticTension &&
                duration == Testdata.duration &&
                Double.compare(Testdata.leakageVoltage, leakageVoltage) == 0 &&
                Double.compare(Testdata.leakageCurrent, leakageCurrent) == 0 &&
                leakageTime == Testdata.leakageTime &&
                Double.compare(Testdata.sectionalArea, sectionalArea) == 0 &&
                Double.compare(Testdata.shielding, shielding) == 0 &&
                speed == Testdata.speed &&
                Double.compare(Testdata.temperature, temperature) == 0 &&
                Double.compare(Testdata.humidity, humidity) == 0 &&
                Double.compare(Testdata.pressure, pressure) == 0 &&
                Double.compare(Testdata.altitude, altitude) == 0 &&
                isPass == Testdata.isPass &&
                Objects.equals(id, Testdata.id) &&
                Objects.equals(rfid, Testdata.rfid) &&
                Objects.equals(rfidSource, Testdata.rfidSource) &&
                Objects.equals(projectId, Testdata.projectId) &&
                Objects.equals(projectCategoryId, Testdata.projectCategoryId) &&
                Objects.equals(position, Testdata.position) &&
                Objects.equals(testValue, Testdata.testValue) &&
                Objects.equals(pictureId, Testdata.pictureId) &&
                Objects.equals(userId, Testdata.userId) &&
                Objects.equals(testCenterId, Testdata.testCenterId) &&
                Objects.equals(createdTime, Testdata.createdTime) &&
                Objects.equals(updatedTime, Testdata.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rfid, rfidSource, projectId, projectCategoryId, rateVoltage, withstandVoltage, pressurizationTimes, maxLeakageCurrent, length, staticTension, position, duration, testValue, leakageVoltage, leakageCurrent, leakageTime, sectionalArea, shielding, speed, pictureId, temperature, humidity, pressure, altitude, isPass, userId, testCenterId, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "ProjectId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Project getProject() {
        return project;
    }

    public void setProject(Project ProjectByProjectId) {
        this.project = ProjectByProjectId;
    }

    @ManyToOne
    @JoinColumn(name = "ProjectCategoryId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public ProjectCategory getProjectCategoryByProjectCategoryId() {
        return projectCategory;
    }

    public void setProjectCategoryByProjectCategoryId(ProjectCategory projectCategory) {
        this.projectCategory = projectCategory;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "TestCenterId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public TestCenter getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(TestCenter testCenter) {
        this.testCenter = testCenter;
    }
}
