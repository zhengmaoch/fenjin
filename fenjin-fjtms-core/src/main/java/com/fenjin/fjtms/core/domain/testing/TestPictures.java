package com.fenjin.fjtms.core.domain.testing;

import com.fenjin.fjtms.core.domain.media.Picture;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "testpictures")
public class TestPictures {
    private String id;
    private String testId;
    private String pictureId;
    private int displayOrder;
    private Test test;
    private Picture picture;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TestId")
    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "PictureId")
    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    @Basic
    @Column(name = "DisplayOrder")
    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestPictures that = (TestPictures) o;
        return displayOrder == that.displayOrder &&
                Objects.equals(id, that.id) &&
                Objects.equals(testId, that.testId) &&
                Objects.equals(pictureId, that.pictureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testId, pictureId, displayOrder);
    }

    @ManyToOne
    @JoinColumn(name = "TestId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @ManyToOne
    @JoinColumn(name = "PictureId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
