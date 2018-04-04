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
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Events.findRecord", query = "SELECT b FROM Booking b WHERE b.bookingId= :bookingId")
    , @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "Booking.findByBookingDate", query = "SELECT b FROM Booking b WHERE b.bookingDate = :bookingDate")
    , @NamedQuery(name = "Booking.findByBookingStatus", query = "SELECT b FROM Booking b WHERE b.bookingStatus = :bookingStatus")
    , @NamedQuery(name = "Booking.findByBookingTime", query = "SELECT b FROM Booking b WHERE b.bookingTime = :bookingTime")
    , @NamedQuery(name = "Booking.findByScheduleId", query = "SELECT b FROM Booking b WHERE b.scheduleId = :scheduleId")
    , @NamedQuery(name = "Booking.findByDonorId", query = "SELECT b FROM Booking b WHERE b.donorId = :donorId")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BOOKING_ID")
    private String bookingId;
    @Column(name = "BOOKING_DATE")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @Size(max = 15)
    @Column(name = "BOOKING_STATUS")
    private String bookingStatus;
    @Size(max = 8)
    @Column(name = "BOOKING_TIME")
    private String bookingTime;
    @Size(max = 10)
    @Column(name = "SCHEDULE_ID")
    private String scheduleId;
    @Size(max = 10)
    @Column(name = "DONOR_ID")
    private String donorId;

    public Booking() {
    }

     public Booking(String BookingID,String DonorID,Date reg_date, String BookingTime,String BookingStatus,String ScheduleID) {
        this.bookingId =BookingID;
        this.donorId=DonorID;
        this.bookingDate = reg_date;
        this.bookingTime=BookingTime;
        this.bookingStatus=BookingStatus;
        this.scheduleId=ScheduleID;
       
    }
    public Booking(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Booking[ bookingId=" + bookingId + " ]";
    }
    
}
