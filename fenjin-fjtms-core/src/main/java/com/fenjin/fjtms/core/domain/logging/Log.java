package com.fenjin.fjtms.core.domain.logging;

import com.fenjin.fjtms.core.domain.users.User;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "log")
public class Log implements Serializable {
    private String id;
    private int logLevelId;
    private String shortMessage;
    private String fullMessage;
    private String ipAddress;
    private String userId;
    private String pageUrl;
    private String referrerUrl;
    private Date createdTime;
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
    @Column(name = "LogLevelId")
    public int getLogLevelId() {
        return logLevelId;
    }

    public void setLogLevelId(int logLevelId) {
        this.logLevelId = logLevelId;
    }

    @Basic
    @Column(name = "ShortMessage")
    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    @Basic
    @Column(name = "FullMessage")
    public String getFullMessage() {
        return fullMessage;
    }

    public void setFullMessage(String fullMessage) {
        this.fullMessage = fullMessage;
    }

    @Basic
    @Column(name = "IpAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
    @Column(name = "PageUrl")
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    @Basic
    @Column(name = "ReferrerUrl")
    public String getReferrerUrl() {
        return referrerUrl;
    }

    public void setReferrerUrl(String referrerUrl) {
        this.referrerUrl = referrerUrl;
    }

    @Basic
    @Column(name = "CreatedTime")
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log Log = (Log) o;
        return logLevelId == Log.logLevelId &&
                Objects.equals(id, Log.id) &&
                Objects.equals(shortMessage, Log.shortMessage) &&
                Objects.equals(fullMessage, Log.fullMessage) &&
                Objects.equals(ipAddress, Log.ipAddress) &&
                Objects.equals(userId, Log.userId) &&
                Objects.equals(pageUrl, Log.pageUrl) &&
                Objects.equals(referrerUrl, Log.referrerUrl) &&
                Objects.equals(createdTime, Log.createdTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logLevelId, shortMessage, fullMessage, ipAddress, userId, pageUrl, referrerUrl, createdTime);
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
