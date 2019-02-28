package com.fenjin.fjtms.core.domain.media;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "picture")
public class Picture {
    private String id;
    private boolean[] pictureBinary;
    private String mimeType;
    private String seoFilename;
    private String altAttribute;
    private String titleAttribute;
    private boolean isNew;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PictureBinary")
    public boolean[] getPictureBinary() {
        return pictureBinary;
    }

    public void setPictureBinary(boolean[] pictureBinary) {
        this.pictureBinary = pictureBinary;
    }

    @Basic
    @Column(name = "MimeType")
    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Basic
    @Column(name = "SeoFilename")
    public String getSeoFilename() {
        return seoFilename;
    }

    public void setSeoFilename(String seoFilename) {
        this.seoFilename = seoFilename;
    }

    @Basic
    @Column(name = "AltAttribute")
    public String getAltAttribute() {
        return altAttribute;
    }

    public void setAltAttribute(String altAttribute) {
        this.altAttribute = altAttribute;
    }

    @Basic
    @Column(name = "TitleAttribute")
    public String getTitleAttribute() {
        return titleAttribute;
    }

    public void setTitleAttribute(String titleAttribute) {
        this.titleAttribute = titleAttribute;
    }

    @Basic
    @Column(name = "IsNew")
    public boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture Picture = (Picture) o;
        return isNew == Picture.isNew &&
                Objects.equals(id, Picture.id) &&
                Arrays.equals(pictureBinary, Picture.pictureBinary) &&
                Objects.equals(mimeType, Picture.mimeType) &&
                Objects.equals(seoFilename, Picture.seoFilename) &&
                Objects.equals(altAttribute, Picture.altAttribute) &&
                Objects.equals(titleAttribute, Picture.titleAttribute);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, mimeType, seoFilename, altAttribute, titleAttribute, isNew);
        result = 31 * result + Arrays.hashCode(pictureBinary);
        return result;
    }

}
