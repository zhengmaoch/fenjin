package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.products.Department;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "test")
public class Test {
    private String id;
    private String testCenterId;
    private String departmentId;
    private String entrustDepartment;
    private String entrustUser;
    private String testStatus;
    private int percentageOfComplete;
    private Integer productCount;
    private Date testTime;
    private String tester1;
    private String tester2;
    private Double temperature;
    private Double humidity;
    private Double pressure;
    private String reportCode;
    private String reportDownloadId;
    private Integer score;
    private String suggestion;
    private String description;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private String firstAuditor;
    private String firstApproval;
    private Date firstAuditTime;
    private String checkPerson;
    private String secondAuditor;
    private String secondApproval;
    private Date secondAuditTime;
    private String auditStatus;
    private String rejectReason;
    private TestCenter testCenter;
    private Department department;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "DepartmentId")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "EntrustDepartment")
    public String getEntrustDepartment() {
        return entrustDepartment;
    }

    public void setEntrustDepartment(String entrustDepartment) {
        this.entrustDepartment = entrustDepartment;
    }

    @Basic
    @Column(name = "EntrustUser")
    public String getEntrustUser() {
        return entrustUser;
    }

    public void setEntrustUser(String entrustUser) {
        this.entrustUser = entrustUser;
    }

    @Basic
    @Column(name = "TestStatus")
    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    @Basic
    @Column(name = "PercentageOfComplete")
    public int getPercentageOfComplete() {
        return percentageOfComplete;
    }

    public void setPercentageOfComplete(int percentageOfComplete) {
        this.percentageOfComplete = percentageOfComplete;
    }

    @Basic
    @Column(name = "ProductCount")
    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
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
    @Column(name = "Tester1")
    public String getTester1() {
        return tester1;
    }

    public void setTester1(String tester1) {
        this.tester1 = tester1;
    }

    @Basic
    @Column(name = "Tester2")
    public String getTester2() {
        return tester2;
    }

    public void setTester2(String tester2) {
        this.tester2 = tester2;
    }

    @Basic
    @Column(name = "Temperature")
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "Humidity")
    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @Basic
    @Column(name = "Pressure")
    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    @Basic
    @Column(name = "ReportCode")
    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    @Basic
    @Column(name = "ReportDownloadId")
    public String getReportDownloadId() {
        return reportDownloadId;
    }

    public void setReportDownloadId(String reportDownloadId) {
        this.reportDownloadId = reportDownloadId;
    }

    @Basic
    @Column(name = "Score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Basic
    @Column(name = "Suggestion")
    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
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

    @Basic
    @Column(name = "FirstAuditor")
    public String getFirstAuditor() {
        return firstAuditor;
    }

    public void setFirstAuditor(String firstAuditor) {
        this.firstAuditor = firstAuditor;
    }

    @Basic
    @Column(name = "FirstApproval")
    public String getFirstApproval() {
        return firstApproval;
    }

    public void setFirstApproval(String firstApproval) {
        this.firstApproval = firstApproval;
    }

    @Basic
    @Column(name = "FirstAuditTime")
    public Date getFirstAuditTime() {
        return firstAuditTime;
    }

    public void setFirstAuditTime(Date firstAuditTime) {
        this.firstAuditTime = firstAuditTime;
    }

    @Basic
    @Column(name = "CheckPerson")
    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    @Basic
    @Column(name = "SecondAuditor")
    public String getSecondAuditor() {
        return secondAuditor;
    }

    public void setSecondAuditor(String secondAuditor) {
        this.secondAuditor = secondAuditor;
    }

    @Basic
    @Column(name = "SecondApproval")
    public String getSecondApproval() {
        return secondApproval;
    }

    public void setSecondApproval(String secondApproval) {
        this.secondApproval = secondApproval;
    }

    @Basic
    @Column(name = "SecondAuditTime")
    public Date getSecondAuditTime() {
        return secondAuditTime;
    }

    public void setSecondAuditTime(Date secondAuditTime) {
        this.secondAuditTime = secondAuditTime;
    }

    @Basic
    @Column(name = "AuditStatus")
    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Basic
    @Column(name = "RejectReason")
    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test Test = (Test) o;
        return percentageOfComplete == Test.percentageOfComplete &&
                deleted == Test.deleted &&
                Objects.equals(id, Test.id) &&
                Objects.equals(testCenterId, Test.testCenterId) &&
                Objects.equals(departmentId, Test.departmentId) &&
                Objects.equals(entrustDepartment, Test.entrustDepartment) &&
                Objects.equals(entrustUser, Test.entrustUser) &&
                Objects.equals(testStatus, Test.testStatus) &&
                Objects.equals(productCount, Test.productCount) &&
                Objects.equals(testTime, Test.testTime) &&
                Objects.equals(tester1, Test.tester1) &&
                Objects.equals(tester2, Test.tester2) &&
                Objects.equals(temperature, Test.temperature) &&
                Objects.equals(humidity, Test.humidity) &&
                Objects.equals(pressure, Test.pressure) &&
                Objects.equals(reportCode, Test.reportCode) &&
                Objects.equals(reportDownloadId, Test.reportDownloadId) &&
                Objects.equals(score, Test.score) &&
                Objects.equals(suggestion, Test.suggestion) &&
                Objects.equals(description, Test.description) &&
                Objects.equals(createdTime, Test.createdTime) &&
                Objects.equals(updatedTime, Test.updatedTime) &&
                Objects.equals(firstAuditor, Test.firstAuditor) &&
                Objects.equals(firstApproval, Test.firstApproval) &&
                Objects.equals(firstAuditTime, Test.firstAuditTime) &&
                Objects.equals(checkPerson, Test.checkPerson) &&
                Objects.equals(secondAuditor, Test.secondAuditor) &&
                Objects.equals(secondApproval, Test.secondApproval) &&
                Objects.equals(secondAuditTime, Test.secondAuditTime) &&
                Objects.equals(auditStatus, Test.auditStatus) &&
                Objects.equals(rejectReason, Test.rejectReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testCenterId, departmentId, entrustDepartment, entrustUser, testStatus, percentageOfComplete, productCount, testTime, tester1, tester2, temperature, humidity, pressure, reportCode, reportDownloadId, score, suggestion, description, deleted, createdTime, updatedTime, firstAuditor, firstApproval, firstAuditTime, checkPerson, secondAuditor, secondApproval, secondAuditTime, auditStatus, rejectReason);
    }

    @ManyToOne
    @JoinColumn(name = "TestCenterId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public TestCenter getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(TestCenter testCenter) {
        this.testCenter = testCenter;
    }

    @ManyToOne
    @JoinColumn(name = "DepartmentId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
