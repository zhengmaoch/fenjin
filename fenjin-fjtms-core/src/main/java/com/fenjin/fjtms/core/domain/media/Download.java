package com.fenjin.fjtms.core.domain.media;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "download")
public class Download {
    private String id;
    private String downloadGuid;
    private boolean useDownloadUrl;
    private String downloadUrl;
    private boolean[] downloadBinary;
    private String contentType;
    private String filename;
    private String extension;
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
    @Column(name = "DownloadGuid")
    public String getDownloadGuid() {
        return downloadGuid;
    }

    public void setDownloadGuid(String downloadGuid) {
        this.downloadGuid = downloadGuid;
    }

    @Basic
    @Column(name = "UseDownloadUrl")
    public boolean getUseDownloadUrl() {
        return useDownloadUrl;
    }

    public void setUseDownloadUrl(boolean useDownloadUrl) {
        this.useDownloadUrl = useDownloadUrl;
    }

    @Basic
    @Column(name = "DownloadUrl")
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Basic
    @Column(name = "DownloadBinary")
    public boolean[] getDownloadBinary() {
        return downloadBinary;
    }

    public void setDownloadBinary(boolean[] downloadBinary) {
        this.downloadBinary = downloadBinary;
    }

    @Basic
    @Column(name = "ContentType")
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Basic
    @Column(name = "Filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Basic
    @Column(name = "Extension")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
        Download Download = (Download) o;
        return useDownloadUrl == Download.useDownloadUrl &&
                isNew == Download.isNew &&
                Objects.equals(id, Download.id) &&
                Objects.equals(downloadGuid, Download.downloadGuid) &&
                Objects.equals(downloadUrl, Download.downloadUrl) &&
                Arrays.equals(downloadBinary, Download.downloadBinary) &&
                Objects.equals(contentType, Download.contentType) &&
                Objects.equals(filename, Download.filename) &&
                Objects.equals(extension, Download.extension);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, downloadGuid, useDownloadUrl, downloadUrl, contentType, filename, extension, isNew);
        result = 31 * result + Arrays.hashCode(downloadBinary);
        return result;
    }
}
