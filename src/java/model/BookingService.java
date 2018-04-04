package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class BookingService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public BookingService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addBooking(Booking bk) {
        mgr.persist(bk);
        return true;
    }

    public Booking findByBookingID(String Booking_ID) {
        Booking bk = mgr.find(Booking.class, Booking_ID);
        return bk;
    }

     public Booking findRecord(String Booking_ID){
        query = mgr.createNamedQuery("Booking.findRecord");  
        query.setParameter("Booking_ID", Booking_ID);
        return (Booking) query.getSingleResult();
    }
    
    
    public List<Booking> findAll() {
        List bkList = mgr.createNamedQuery("Booking.findAll").getResultList();
        return bkList;
    }

    public boolean updateBooking(Booking part) {
       Booking bk = findRecord(part.getBookingId());
        if (bk != null) {
            bk.setBookingStatus(part.getBookingStatus());
            mgr.merge(part);
            return true;
        }
        return false;
    }
}

