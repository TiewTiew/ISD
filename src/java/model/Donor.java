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
@Table(name = "DONOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donor.findAll", query = "SELECT d FROM Donor d")
    , @NamedQuery(name = "Donor.findByDonorId", query = "SELECT d FROM Donor d WHERE d.donorId = :donorId")
    , @NamedQuery(name = "Donor.findByDonorName", query = "SELECT d FROM Donor d WHERE d.donorName = :donorName")
    , @NamedQuery(name = "Donor.findByDonorPassword", query = "SELECT d FROM Donor d WHERE d.donorPassword = :donorPassword")
    , @NamedQuery(name = "Donor.findByDonorIc", query = "SELECT d FROM Donor d WHERE d.donorIc = :donorIc")
    , @NamedQuery(name = "Donor.findByDonorGender", query = "SELECT d FROM Donor d WHERE d.donorGender = :donorGender")
    , @NamedQuery(name = "Donor.findByDonorTel", query = "SELECT d FROM Donor d WHERE d.donorTel = :donorTel")
    , @NamedQuery(name = "Donor.findByDonorEmail", query = "SELECT d FROM Donor d WHERE d.donorEmail = :donorEmail")
    , @NamedQuery(name = "Donor.findByDonorStatus", query = "SELECT d FROM Donor d WHERE d.donorStatus = :donorStatus")
    , @NamedQuery(name = "Donor.findByBloodType", query = "SELECT d FROM Donor d WHERE d.bloodType = :bloodType")
    , @NamedQuery(name = "Donor.findByDonorAddress", query = "SELECT d FROM Donor d WHERE d.donorAddress = :donorAddress")})
public class Donor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DONOR_ID")
    private String donorId;
    @Size(max = 30)
    @Column(name = "DONOR_NAME")
    private String donorName;
    @Size(max = 12)
    @Column(name = "DONOR_PASSWORD")
    private String donorPassword;
    @Size(max = 12)
    @Column(name = "DONOR_IC")
    private String donorIc;
    @Column(name = "DONOR_GENDER")
    private Character donorGender;
    @Column(name = "DONOR_TEL")
    private Integer donorTel;
    @Size(max = 30)
    @Column(name = "DONOR_EMAIL")
    private String donorEmail;
    @Size(max = 10)
    @Column(name = "DONOR_STATUS")
    private String donorStatus;
    @Size(max = 5)
    @Column(name = "BLOOD_TYPE")
    private String bloodType;
    @Size(max = 40)
    @Column(name = "DONOR_ADDRESS")
    private String donorAddress;

    public Donor() {
    }

    public Donor(String donorId) {
        this.donorId = donorId;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorPassword() {
        return donorPassword;
    }

    public void setDonorPassword(String donorPassword) {
        this.donorPassword = donorPassword;
    }

    public String getDonorIc() {
        return donorIc;
    }

    public void setDonorIc(String donorIc) {
        this.donorIc = donorIc;
    }

    public Character getDonorGender() {
        return donorGender;
    }

    public void setDonorGender(Character donorGender) {
        this.donorGender = donorGender;
    }

    public Integer getDonorTel() {
        return donorTel;
    }

    public void setDonorTel(Integer donorTel) {
        this.donorTel = donorTel;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getDonorStatus() {
        return donorStatus;
    }

    public void setDonorStatus(String donorStatus) {
        this.donorStatus = donorStatus;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDonorAddress() {
        return donorAddress;
    }

    public void setDonorAddress(String donorAddress) {
        this.donorAddress = donorAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donorId != null ? donorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donor)) {
            return false;
        }
        Donor other = (Donor) object;
        if ((this.donorId == null && other.donorId != null) || (this.donorId != null && !this.donorId.equals(other.donorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Donor[ donorId=" + donorId + " ]";
    }
    
}
