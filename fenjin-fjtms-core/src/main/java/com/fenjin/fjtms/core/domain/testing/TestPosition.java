package com.fenjin.fjtms.core.domain.testing;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "testposition")
public class TestPosition {
    private String id;
    private String testCenterId;
    private String rfid1;
    private String rfid2;
    private String rfid3;
    private String rfid4;
    private String rfid5;
    private String rfid6;
    private String rfid7;
    private String rfid8;
    private String rfid9;
    private String rfid10;
    private String rfid11;
    private String rfid12;
    private String rfid13;
    private String rfid14;
    private String rfid15;
    private String rfid16;
    private String rfid17;
    private String rfid18;
    private String rfid19;
    private String rfid20;
    private TestCenter testCenter;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TestCenterId")
    public String getTestCenterId() {
        return testCenterId;
    }

    public void setTestCenterId(String testCenterId) {
        this.testCenterId = testCenterId;
    }

    @Basic
    @Column(name = "RFID1")
    public String getRfid1() {
        return rfid1;
    }

    public void setRfid1(String rfid1) {
        this.rfid1 = rfid1;
    }

    @Basic
    @Column(name = "RFID2")
    public String getRfid2() {
        return rfid2;
    }

    public void setRfid2(String rfid2) {
        this.rfid2 = rfid2;
    }

    @Basic
    @Column(name = "RFID3")
    public String getRfid3() {
        return rfid3;
    }

    public void setRfid3(String rfid3) {
        this.rfid3 = rfid3;
    }

    @Basic
    @Column(name = "RFID4")
    public String getRfid4() {
        return rfid4;
    }

    public void setRfid4(String rfid4) {
        this.rfid4 = rfid4;
    }

    @Basic
    @Column(name = "RFID5")
    public String getRfid5() {
        return rfid5;
    }

    public void setRfid5(String rfid5) {
        this.rfid5 = rfid5;
    }

    @Basic
    @Column(name = "RFID6")
    public String getRfid6() {
        return rfid6;
    }

    public void setRfid6(String rfid6) {
        this.rfid6 = rfid6;
    }

    @Basic
    @Column(name = "RFID7")
    public String getRfid7() {
        return rfid7;
    }

    public void setRfid7(String rfid7) {
        this.rfid7 = rfid7;
    }

    @Basic
    @Column(name = "RFID8")
    public String getRfid8() {
        return rfid8;
    }

    public void setRfid8(String rfid8) {
        this.rfid8 = rfid8;
    }

    @Basic
    @Column(name = "RFID9")
    public String getRfid9() {
        return rfid9;
    }

    public void setRfid9(String rfid9) {
        this.rfid9 = rfid9;
    }

    @Basic
    @Column(name = "RFID10")
    public String getRfid10() {
        return rfid10;
    }

    public void setRfid10(String rfid10) {
        this.rfid10 = rfid10;
    }

    @Basic
    @Column(name = "RFID11")
    public String getRfid11() {
        return rfid11;
    }

    public void setRfid11(String rfid11) {
        this.rfid11 = rfid11;
    }

    @Basic
    @Column(name = "RFID12")
    public String getRfid12() {
        return rfid12;
    }

    public void setRfid12(String rfid12) {
        this.rfid12 = rfid12;
    }

    @Basic
    @Column(name = "RFID13")
    public String getRfid13() {
        return rfid13;
    }

    public void setRfid13(String rfid13) {
        this.rfid13 = rfid13;
    }

    @Basic
    @Column(name = "RFID14")
    public String getRfid14() {
        return rfid14;
    }

    public void setRfid14(String rfid14) {
        this.rfid14 = rfid14;
    }

    @Basic
    @Column(name = "RFID15")
    public String getRfid15() {
        return rfid15;
    }

    public void setRfid15(String rfid15) {
        this.rfid15 = rfid15;
    }

    @Basic
    @Column(name = "RFID16")
    public String getRfid16() {
        return rfid16;
    }

    public void setRfid16(String rfid16) {
        this.rfid16 = rfid16;
    }

    @Basic
    @Column(name = "RFID17")
    public String getRfid17() {
        return rfid17;
    }

    public void setRfid17(String rfid17) {
        this.rfid17 = rfid17;
    }

    @Basic
    @Column(name = "RFID18")
    public String getRfid18() {
        return rfid18;
    }

    public void setRfid18(String rfid18) {
        this.rfid18 = rfid18;
    }

    @Basic
    @Column(name = "RFID19")
    public String getRfid19() {
        return rfid19;
    }

    public void setRfid19(String rfid19) {
        this.rfid19 = rfid19;
    }

    @Basic
    @Column(name = "RFID20")
    public String getRfid20() {
        return rfid20;
    }

    public void setRfid20(String rfid20) {
        this.rfid20 = rfid20;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestPosition that = (TestPosition) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(testCenterId, that.testCenterId) &&
                Objects.equals(rfid1, that.rfid1) &&
                Objects.equals(rfid2, that.rfid2) &&
                Objects.equals(rfid3, that.rfid3) &&
                Objects.equals(rfid4, that.rfid4) &&
                Objects.equals(rfid5, that.rfid5) &&
                Objects.equals(rfid6, that.rfid6) &&
                Objects.equals(rfid7, that.rfid7) &&
                Objects.equals(rfid8, that.rfid8) &&
                Objects.equals(rfid9, that.rfid9) &&
                Objects.equals(rfid10, that.rfid10) &&
                Objects.equals(rfid11, that.rfid11) &&
                Objects.equals(rfid12, that.rfid12) &&
                Objects.equals(rfid13, that.rfid13) &&
                Objects.equals(rfid14, that.rfid14) &&
                Objects.equals(rfid15, that.rfid15) &&
                Objects.equals(rfid16, that.rfid16) &&
                Objects.equals(rfid17, that.rfid17) &&
                Objects.equals(rfid18, that.rfid18) &&
                Objects.equals(rfid19, that.rfid19) &&
                Objects.equals(rfid20, that.rfid20);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testCenterId, rfid1, rfid2, rfid3, rfid4, rfid5, rfid6, rfid7, rfid8, rfid9, rfid10, rfid11, rfid12, rfid13, rfid14, rfid15, rfid16, rfid17, rfid18, rfid19, rfid20);
    }

    @ManyToOne
    @JoinColumn(name = "TestCenterId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public TestCenter getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(TestCenter testCenter) {
        this.testCenter = testCenter;
    }
}
