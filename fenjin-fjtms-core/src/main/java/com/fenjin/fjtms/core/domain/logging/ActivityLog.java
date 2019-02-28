package com.fenjin.fjtms.core.domain.logging;

import com.fenjin.fjtms.core.domain.users.User;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "activitylog")
public class ActivityLog implements Serializable {
    private String id;
    private String activityLogTypeId;
    private String userId;
    private String comment;
    private Date createdTime;
    private String ipAddress;
    private ActivityLogType activityLogType;
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
    @Column(name = "ActivityLogTypeId")
    public String getActivityLogTypeId() {
        return activityLogTypeId;
    }

    public void setActivityLogTypeId(String activityLogTypeId) {
        this.activityLogTypeId = activityLogTypeId;
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
    @Column(name = "Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
    @Column(name = "IpAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityLog that = (ActivityLog) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(activityLogTypeId, that.activityLogTypeId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(ipAddress, that.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activityLogTypeId, userId, comment, createdTime, ipAddress);
    }

    @ManyToOne
    @JoinColumn(name = "ActivityLogTypeId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public ActivityLogType getActivityLogType() {
        return activityLogType;
    }

    public void setActivityLogType(ActivityLogType activityLogType) {
        this.activityLogType = activityLogType;
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
