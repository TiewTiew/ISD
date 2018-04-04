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
@Table(name = "BLOOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blood.findAll", query = "SELECT b FROM Blood b")
    , @NamedQuery(name = "Blood.findByBloodType", query = "SELECT b FROM Blood b WHERE b.bloodType = :bloodType")
    , @NamedQuery(name = "Blood.findByBloodQuantity", query = "SELECT b FROM Blood b WHERE b.bloodQuantity = :bloodQuantity")})
public class Blood implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "BLOOD_TYPE")
    private String bloodType;
    @Column(name = "BLOOD_QUANTITY")
    private Integer bloodQuantity;

    public Blood() {
    }

    public Blood(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Integer getBloodQuantity() {
        return bloodQuantity;
    }

    public void setBloodQuantity(Integer bloodQuantity) {
        this.bloodQuantity = bloodQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bloodType != null ? bloodType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blood)) {
            return false;
        }
        Blood other = (Blood) object;
        if ((this.bloodType == null && other.bloodType != null) || (this.bloodType != null && !this.bloodType.equals(other.bloodType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Blood[ bloodType=" + bloodType + " ]";
    }
    
}
