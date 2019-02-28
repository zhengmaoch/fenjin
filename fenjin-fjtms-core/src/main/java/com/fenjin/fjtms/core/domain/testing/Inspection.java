package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.products.Department;
import com.fenjin.fjtms.core.domain.users.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "inspection")
public class Inspection {
    private String id;
    private String testCenterId;
    private String departmentId;
    private String entrustmentDepartment;
    private String consignerSignaturePictureId;
    private String consignerPhoneNumber;
    private String sendeeSignaturePictureId;
    private String status;
    private Double totalPrice;
    private Double off;
    private String reportCode;
    private String inspectionDownloadId;
    private String userId;
    private boolean isPost;
    private boolean isSendSms;
    private String expressName;
    private String trackingNumber;
    private String description;
    private boolean deleted;
    private Date testedTime;
    private Date sendTime;
    private Date createdTime;
    private Date updatedTime;
    private TestCenter testCenter;
    private Department department;
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
    @Column(name = "EntrustmentDepartment")
    public String getEntrustmentDepartment() {
        return entrustmentDepartment;
    }

    public void setEntrustmentDepartment(String entrustmentDepartment) {
        this.entrustmentDepartment = entrustmentDepartment;
    }

    @Basic
    @Column(name = "ConsignerSignaturePictureId")
    public String getConsignerSignaturePictureId() {
        return consignerSignaturePictureId;
    }

    public void setConsignerSignaturePictureId(String consignerSignaturePictureId) {
        this.consignerSignaturePictureId = consignerSignaturePictureId;
    }

    @Basic
    @Column(name = "ConsignerPhoneNumber")
    public String getConsignerPhoneNumber() {
        return consignerPhoneNumber;
    }

    public void setConsignerPhoneNumber(String consignerPhoneNumber) {
        this.consignerPhoneNumber = consignerPhoneNumber;
    }

    @Basic
    @Column(name = "SendeeSignaturePictureId")
    public String getSendeeSignaturePictureId() {
        return sendeeSignaturePictureId;
    }

    public void setSendeeSignaturePictureId(String sendeeSignaturePictureId) {
        this.sendeeSignaturePictureId = sendeeSignaturePictureId;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "TotalPrice")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "Off")
    public Double getOff() {
        return off;
    }

    public void setOff(Double off) {
        this.off = off;
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
    @Column(name = "InspectionDownloadId")
    public String getInspectionDownloadId() {
        return inspectionDownloadId;
    }

    public void setInspectionDownloadId(String inspectionDownloadId) {
        this.inspectionDownloadId = inspectionDownloadId;
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
    @Column(name = "IsPost")
    public boolean getIsPost() {
        return isPost;
    }

    public void setIsPost(boolean isPost) {
        this.isPost = isPost;
    }

    @Basic
    @Column(name = "IsSendSms")
    public boolean getIsSendSms() {
        return isSendSms;
    }

    public void setIsSendSms(boolean isSendSms) {
        this.isSendSms = isSendSms;
    }

    @Basic
    @Column(name = "ExpressName")
    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    @Basic
    @Column(name = "TrackingNumber")
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
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
    @Column(name = "TestedTime")
    public Date geTestedTime() {
        return testedTime;
    }

    public void seTestedTime(Date testedTime) {
        this.testedTime = testedTime;
    }

    @Basic
    @Column(name = "SendTime")
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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
        Inspection that = (Inspection) o;
        return isPost == that.isPost &&
                isSendSms == that.isSendSms &&
                deleted == that.deleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(testCenterId, that.testCenterId) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(entrustmentDepartment, that.entrustmentDepartment) &&
                Objects.equals(consignerSignaturePictureId, that.consignerSignaturePictureId) &&
                Objects.equals(consignerPhoneNumber, that.consignerPhoneNumber) &&
                Objects.equals(sendeeSignaturePictureId, that.sendeeSignaturePictureId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(off, that.off) &&
                Objects.equals(reportCode, that.reportCode) &&
                Objects.equals(inspectionDownloadId, that.inspectionDownloadId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(expressName, that.expressName) &&
                Objects.equals(trackingNumber, that.trackingNumber) &&
                Objects.equals(description, that.description) &&
                Objects.equals(testedTime, that.testedTime) &&
                Objects.equals(sendTime, that.sendTime) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testCenterId, departmentId, entrustmentDepartment, consignerSignaturePictureId, consignerPhoneNumber, sendeeSignaturePictureId, status, totalPrice, off, reportCode, inspectionDownloadId, userId, isPost, isSendSms, expressName, trackingNumber, description, deleted, testedTime, sendTime, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "TestCenterId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public TestCenter getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(TestCenter TestcenterbooleanstCenterId) {
        this.testCenter = TestcenterbooleanstCenterId;
    }

    @ManyToOne
    @JoinColumn(name = "DepartmentId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department DepartmentByDepartmentId) {
        this.department = DepartmentByDepartmentId;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User UserByUserId) {
        this.user = UserByUserId;
    }

}
