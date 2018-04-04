/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STAFF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
    , @NamedQuery(name = "Staff.findByStaffId", query = "SELECT s FROM Staff s WHERE s.staffId = :staffId")
    , @NamedQuery(name = "Staff.findByStaffName", query = "SELECT s FROM Staff s WHERE s.staffName = :staffName")
    , @NamedQuery(name = "Staff.findByStaffIc", query = "SELECT s FROM Staff s WHERE s.staffIc = :staffIc")
    , @NamedQuery(name = "Staff.findByStaffGender", query = "SELECT s FROM Staff s WHERE s.staffGender = :staffGender")
    , @NamedQuery(name = "Staff.findByStaffTel", query = "SELECT s FROM Staff s WHERE s.staffTel = :staffTel")
    , @NamedQuery(name = "Staff.findByStaffEmail", query = "SELECT s FROM Staff s WHERE s.staffEmail = :staffEmail")
    , @NamedQuery(name = "Staff.findByPosition", query = "SELECT s FROM Staff s WHERE s.position = :position")
    , @NamedQuery(name = "Staff.findByStaffGroup", query = "SELECT s FROM Staff s WHERE s.staffGroup = :staffGroup")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "STAFF_ID")
    private String staffId;
    @Size(max = 30)
    @Column(name = "STAFF_NAME")
    private String staffName;
    @Size(max = 12)
    @Column(name = "STAFF_IC")
    private String staffIc;
    @Column(name = "STAFF_GENDER")
    private Character staffGender;
    @Column(name = "STAFF_TEL")
    private Integer staffTel;
    @Size(max = 30)
    @Column(name = "STAFF_EMAIL")
    private String staffEmail;
    @Size(max = 20)
    @Column(name = "POSITION")
    private String position;
    @Size(max = 5)
    @Column(name = "STAFF_GROUP")
    private String staffGroup;

    public Staff() {
    }

    public Staff(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffIc() {
        return staffIc;
    }

    public void setStaffIc(String staffIc) {
        this.staffIc = staffIc;
    }

    public Character getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(Character staffGender) {
        this.staffGender = staffGender;
    }

    public Integer getStaffTel() {
        return staffTel;
    }

    public void setStaffTel(Integer staffTel) {
        this.staffTel = staffTel;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStaffGroup() {
        return staffGroup;
    }

    public void setStaffGroup(String staffGroup) {
        this.staffGroup = staffGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Staff[ staffId=" + staffId + " ]";
    }
    
}
