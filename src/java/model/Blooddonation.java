/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "BLOODDONATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blooddonation.findAll", query = "SELECT b FROM Blooddonation b")
    , @NamedQuery(name = "Blooddonation.findByBdId", query = "SELECT b FROM Blooddonation b WHERE b.bdId = :bdId")
    , @NamedQuery(name = "Blooddonation.findByBdDate", query = "SELECT b FROM Blooddonation b WHERE b.bdDate = :bdDate")
    , @NamedQuery(name = "Blooddonation.findByBdTime", query = "SELECT b FROM Blooddonation b WHERE b.bdTime = :bdTime")
    , @NamedQuery(name = "Blooddonation.findByBdQuantity", query = "SELECT b FROM Blooddonation b WHERE b.bdQuantity = :bdQuantity")
    , @NamedQuery(name = "Blooddonation.findByBloodType", query = "SELECT b FROM Blooddonation b WHERE b.bloodType = :bloodType")
    , @NamedQuery(name = "Blooddonation.findByBookingId", query = "SELECT b FROM Blooddonation b WHERE b.bookingId = :bookingId")})
public class Blooddonation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BD_ID")
    private String bdId;
    @Column(name = "BD_DATE")
    @Temporal(TemporalType.DATE)
    private Date bdDate;
    @Size(max = 10)
    @Column(name = "BD_TIME")
    private String bdTime;
    @Column(name = "BD_QUANTITY")
    private Integer bdQuantity;
    @Size(max = 5)
    @Column(name = "BLOOD_TYPE")
    private String bloodType;
    @Size(max = 10)
    @Column(name = "BOOKING_ID")
    private String bookingId;

    public Blooddonation() {
    }

    public Blooddonation(String bdId) {
        this.bdId = bdId;
    }

    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    public Date getBdDate() {
        return bdDate;
    }

    public void setBdDate(Date bdDate) {
        this.bdDate = bdDate;
    }

    public String getBdTime() {
        return bdTime;
    }

    public void setBdTime(String bdTime) {
        this.bdTime = bdTime;
    }

    public Integer getBdQuantity() {
        return bdQuantity;
    }

    public void setBdQuantity(Integer bdQuantity) {
        this.bdQuantity = bdQuantity;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bdId != null ? bdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blooddonation)) {
            return false;
        }
        Blooddonation other = (Blooddonation) object;
        if ((this.bdId == null && other.bdId != null) || (this.bdId != null && !this.bdId.equals(other.bdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Blooddonation[ bdId=" + bdId + " ]";
    }
    
}
