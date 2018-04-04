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
@Table(name = "BLOODTRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bloodtransaction.findAll", query = "SELECT b FROM Bloodtransaction b")
    , @NamedQuery(name = "Bloodtransaction.findByBtId", query = "SELECT b FROM Bloodtransaction b WHERE b.btId = :btId")
    , @NamedQuery(name = "Bloodtransaction.findByBtDate", query = "SELECT b FROM Bloodtransaction b WHERE b.btDate = :btDate")
    , @NamedQuery(name = "Bloodtransaction.findByBtTime", query = "SELECT b FROM Bloodtransaction b WHERE b.btTime = :btTime")
    , @NamedQuery(name = "Bloodtransaction.findByBtQuantity", query = "SELECT b FROM Bloodtransaction b WHERE b.btQuantity = :btQuantity")
    , @NamedQuery(name = "Bloodtransaction.findByBloodType", query = "SELECT b FROM Bloodtransaction b WHERE b.bloodType = :bloodType")
    , @NamedQuery(name = "Bloodtransaction.findByStaffId", query = "SELECT b FROM Bloodtransaction b WHERE b.staffId = :staffId")})
public class Bloodtransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BT_ID")
    private String btId;
    @Column(name = "BT_DATE")
    @Temporal(TemporalType.DATE)
    private Date btDate;
    @Size(max = 10)
    @Column(name = "BT_TIME")
    private String btTime;
    @Column(name = "BT_QUANTITY")
    private Integer btQuantity;
    @Size(max = 5)
    @Column(name = "BLOOD_TYPE")
    private String bloodType;
    @Size(max = 10)
    @Column(name = "STAFF_ID")
    private String staffId;

    public Bloodtransaction() {
    }

    public Bloodtransaction(String btId) {
        this.btId = btId;
    }

    public String getBtId() {
        return btId;
    }

    public void setBtId(String btId) {
        this.btId = btId;
    }

    public Date getBtDate() {
        return btDate;
    }

    public void setBtDate(Date btDate) {
        this.btDate = btDate;
    }

    public String getBtTime() {
        return btTime;
    }

    public void setBtTime(String btTime) {
        this.btTime = btTime;
    }

    public Integer getBtQuantity() {
        return btQuantity;
    }

    public void setBtQuantity(Integer btQuantity) {
        this.btQuantity = btQuantity;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (btId != null ? btId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloodtransaction)) {
            return false;
        }
        Bloodtransaction other = (Bloodtransaction) object;
        if ((this.btId == null && other.btId != null) || (this.btId != null && !this.btId.equals(other.btId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bloodtransaction[ btId=" + btId + " ]";
    }
    
}
