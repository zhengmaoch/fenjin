package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.common.Area;
import com.fenjin.fjtms.core.domain.products.Department;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "testcenter")
public class TestCenter {
    private String id;
    private String name;
    private String departmentId;
    private String areaId;
    private String companyName;
    private String companyEnglishName;
    private String address;
    private String zipCode;
    private String email;
    private String tel;
    private String fax;
    private String certificatePictureId;
    private String certificateNumber;
    private String logoPictureId;
    private String url;
    private int code;
    private boolean published;
    private boolean deleted;
    private int displayOrder;
    private Date createdTime;
    private Date updatedTime;
    private Department department;
    private Area area;

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
    @Column(name = "DepartmentId")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "AreaId")
    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "CompanyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "CompanyEnglishName")
    public String getCompanyEnglishName() {
        return companyEnglishName;
    }

    public void setCompanyEnglishName(String companyEnglishName) {
        this.companyEnglishName = companyEnglishName;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ZipCode")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "Fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "CertificatePictureId")
    public String getCertificatePictureId() {
        return certificatePictureId;
    }

    public void setCertificatePictureId(String certificatePictureId) {
        this.certificatePictureId = certificatePictureId;
    }

    @Basic
    @Column(name = "CertificateNumber")
    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    @Basic
    @Column(name = "LogoPictureId")
    public String getLogoPictureId() {
        return logoPictureId;
    }

    public void setLogoPictureId(String logoPictureId) {
        this.logoPictureId = logoPictureId;
    }

    @Basic
    @Column(name = "Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "Code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "Published")
    public boolean getPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
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
        TestCenter that = (TestCenter) o;
        return code == that.code &&
                published == that.published &&
                deleted == that.deleted &&
                displayOrder == that.displayOrder &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(areaId, that.areaId) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(companyEnglishName, that.companyEnglishName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(email, that.email) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(certificatePictureId, that.certificatePictureId) &&
                Objects.equals(certificateNumber, that.certificateNumber) &&
                Objects.equals(logoPictureId, that.logoPictureId) &&
                Objects.equals(url, that.url) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updatedTime, that.updatedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, departmentId, areaId, companyName, companyEnglishName, address, zipCode, email, tel, fax, certificatePictureId, certificateNumber, logoPictureId, url, code, published, deleted, displayOrder, createdTime, updatedTime);
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
    @JoinColumn(name = "AreaId", referencedColumnName = "Id", insertable = false, updatable = false)
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

}
