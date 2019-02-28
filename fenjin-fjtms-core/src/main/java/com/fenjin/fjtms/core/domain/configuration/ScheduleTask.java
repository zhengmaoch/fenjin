package com.fenjin.fjtms.core.domain.configuration;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "scheduletask")
public class ScheduleTask {
    private String id;
    private String name;
    private int seconds;
    private String type;
    private boolean enabled;
    private boolean stopOnError;
    private String leasedByMachineName;
    private Date leasedUntilUtc;
    private Date lastStartUtc;
    private Date lastEndUtc;
    private Date lastSuccessUtc;

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
    @Column(name = "Seconds")
    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Enabled")
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "StopOnError")
    public boolean getStopOnError() {
        return stopOnError;
    }

    public void setStopOnError(boolean stopOnError) {
        this.stopOnError = stopOnError;
    }

    @Basic
    @Column(name = "LeasedByMachineName")
    public String getLeasedByMachineName() {
        return leasedByMachineName;
    }

    public void setLeasedByMachineName(String leasedByMachineName) {
        this.leasedByMachineName = leasedByMachineName;
    }

    @Basic
    @Column(name = "LeasedUntilUtc")
    public Date getLeasedUntilUtc() {
        return leasedUntilUtc;
    }

    public void setLeasedUntilUtc(Date leasedUntilUtc) {
        this.leasedUntilUtc = leasedUntilUtc;
    }

    @Basic
    @Column(name = "LastStartUtc")
    public Date getLastStartUtc() {
        return lastStartUtc;
    }

    public void setLastStartUtc(Date lastStartUtc) {
        this.lastStartUtc = lastStartUtc;
    }

    @Basic
    @Column(name = "LastEndUtc")
    public Date getLastEndUtc() {
        return lastEndUtc;
    }

    public void setLastEndUtc(Date lastEndUtc) {
        this.lastEndUtc = lastEndUtc;
    }

    @Basic
    @Column(name = "LastSuccessUtc")
    public Date getLastSuccessUtc() {
        return lastSuccessUtc;
    }

    public void setLastSuccessUtc(Date lastSuccessUtc) {
        this.lastSuccessUtc = lastSuccessUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleTask that = (ScheduleTask) o;
        return seconds == that.seconds &&
                enabled == that.enabled &&
                stopOnError == that.stopOnError &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(leasedByMachineName, that.leasedByMachineName) &&
                Objects.equals(leasedUntilUtc, that.leasedUntilUtc) &&
                Objects.equals(lastStartUtc, that.lastStartUtc) &&
                Objects.equals(lastEndUtc, that.lastEndUtc) &&
                Objects.equals(lastSuccessUtc, that.lastSuccessUtc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, seconds, type, enabled, stopOnError, leasedByMachineName, leasedUntilUtc, lastStartUtc, lastEndUtc, lastSuccessUtc);
    }
}
