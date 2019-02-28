package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.configuration.SmsMessage;
import com.fenjin.fjtms.core.domain.products.Department;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "testwarning")
public class TestWarning {
    private String id;
    private String departmentId;
    private String toUser;
    private String toPhone;
    private Date testTime;
    private Date sendTime;
    private String smsMessageId;
    private boolean successful;
    private String description;
    private Date createdTime;
    private Date updatedTime;
    private Department department;
    private SmsMessage smsMessage;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "ToUser")
    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    @Basic
    @Column(name = "ToPhone")
    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
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
    @Column(name = "SendTime")
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Basic
    @Column(name = "SmsMessageId")
    public String getSmsMessageId() {
        return smsMessageId;
    }

    public void setSmsMessageId(String smsMessageId) {
        this.smsMessageId = smsMessageId;
    }

    @Basic
    @Column(name = "Successful")
    public boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
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
        TestWarning that = (TestWarning) o;
        return successful == that.successful &&
                Objects.equals(id, that.id) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(toUser, that.toUser) &&
                Objects.equals(toPhone, that.toPhone) &&
                Objects.equals(testTime, that.testTime) &&
                Objects.equals(sendTime, that.sendTime) &&
                Objects.equals(smsMessageId, that.smsMessageId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, toUser, toPhone, testTime, sendTime, smsMessageId, successful, description, createdTime, updatedTime);
    }

    @ManyToOne
    @JoinColumn(name = "DepartmentId", referencedColumnName = "Id", insertable = false, updatable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "SmsMessageId", referencedColumnName = "Id", insertable = false, updatable = false)
    public SmsMessage getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(SmsMessage smsMessage) {
        this.smsMessage = smsMessage;
    }
}
