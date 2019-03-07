package com.fenjin.fjtms.core.domain.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fenjin.fjtms.core.domain.products.Department;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
@Accessors(chain = true)
public class User implements Serializable {
    private String id;
    private String username;
    private String fullName;
    private String password;
    private String post;
    private String phone;
    private String email;
    private boolean requireReLogin;
    private int failedLoginAttempts;
    private Date cannotLoginUntilDate;
    private boolean active;
    private boolean isSystemAccount;
    private String lastIpAddress;
    private Date lastLoginDate;
    private Date lastActivityDate;
    private boolean deleted;
    private Date createdTime;
    private Date updatedTime;
    private List<Role> roles = new ArrayList<>();

    @Id
    @Column(name = "Id")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Username")
    @NotBlank(message="用户名不能为空")
    @Length(min = 2, message = "用户名长度必须大于2个字符")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "FullName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Password")
    @NotBlank(message="密码不能为空")
    @Pattern(regexp = "(?!^\\\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}", message = "密码必须由数字、字符、特殊符号组成，且长度不能少于8个字符")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Post")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "Phone")
    @Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}", message = "电话号码格式不正确")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Email")
    @Email(message = "邮箱的格式不正确")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "RequireReLogin")
    public boolean getRequireReLogin() {
        return requireReLogin;
    }

    public void setRequireReLogin(boolean requireReLogin) {
        this.requireReLogin = requireReLogin;
    }

    @Basic
    @Column(name = "FailedLoginAttempts")
    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    @Basic
    @Column(name = "CannotLoginUntilDate")
    public Date getCannotLoginUntilDate() {
        return cannotLoginUntilDate;
    }

    public void setCannotLoginUntilDate(Date cannotLoginUntilDate) {
        this.cannotLoginUntilDate = cannotLoginUntilDate;
    }

    @Basic
    @Column(name = "Active")
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
    @Column(name = "IsSystemAccount")
    public boolean getIsSystemAccount() {
        return isSystemAccount;
    }

    public void setIsSystemAccount(boolean isSystemAccount) {
        this.isSystemAccount = isSystemAccount;
    }

    @Basic
    @Column(name = "LastIpAddress")
    public String getLastIpAddress() {
        return lastIpAddress;
    }

    public void setLastIpAddress(String lastIpAddress) {
        this.lastIpAddress = lastIpAddress;
    }

    @Basic
    @Column(name = "LastLoginDate")
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Basic
    @Column(name = "LastActivityDate")
    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
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
        User user = (User) o;
        return requireReLogin == user.requireReLogin &&
                failedLoginAttempts == user.failedLoginAttempts &&
                active == user.active &&
                deleted == user.deleted &&
                isSystemAccount == user.isSystemAccount &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(fullName, user.fullName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(post, user.post) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(cannotLoginUntilDate, user.cannotLoginUntilDate) &&
                Objects.equals(lastIpAddress, user.lastIpAddress) &&
                Objects.equals(lastLoginDate, user.lastLoginDate) &&
                Objects.equals(lastActivityDate, user.lastActivityDate) &&
                Objects.equals(createdTime, user.createdTime) &&
                Objects.equals(updatedTime, user.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, fullName, password, post, phone, email, requireReLogin, failedLoginAttempts, cannotLoginUntilDate, active, deleted, isSystemAccount, lastIpAddress, lastLoginDate, lastActivityDate, createdTime, updatedTime);
    }

    @ManyToMany
//    @JsonIgnore
    @JoinTable(name = "UserRoles",joinColumns=@JoinColumn(name="UserId"),inverseJoinColumns=@JoinColumn(name="RoleId"))
    public List<Role> getRoles(){
        return roles;
    }

    public void setRoles(List<Role> roles){
        this.roles = roles;
    }
}
