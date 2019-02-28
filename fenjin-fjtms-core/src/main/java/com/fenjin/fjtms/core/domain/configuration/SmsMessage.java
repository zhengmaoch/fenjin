package com.fenjin.fjtms.core.domain.configuration;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "smsmessage")
public class SmsMessage {
    private String id;
    private String from;
    private String to;
    private String sign;
    private String templateCode;
    private String templateParameter;
    private String content;
    private Date createdTime;
    private Date sendTime;
    private boolean successful;
    private String result;
    private int priority;
    private String description;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "From")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Basic
    @Column(name = "To")
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Basic
    @Column(name = "Sign")
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Basic
    @Column(name = "TemplateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    @Basic
    @Column(name = "TemplateParameter")
    public String getTemplateParameter() {
        return templateParameter;
    }

    public void setTemplateParameter(String templateParameter) {
        this.templateParameter = templateParameter;
    }

    @Basic
    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "SendTime")
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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
    @Column(name = "Result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "Priority")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsMessage that = (SmsMessage) o;
        return successful == that.successful &&
                priority == that.priority &&
                Objects.equals(id, that.id) &&
                Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(sign, that.sign) &&
                Objects.equals(templateCode, that.templateCode) &&
                Objects.equals(templateParameter, that.templateParameter) &&
                Objects.equals(content, that.content) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(sendTime, that.sendTime) &&
                Objects.equals(result, that.result) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, sign, templateCode, templateParameter, content, createdTime, sendTime, successful, result, priority, description);
    }

}
