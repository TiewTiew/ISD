package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class BloodServices {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public BloodServices(EntityManager mgr) {
        this.mgr = mgr;
    }

   public Blood findByBloodType(String Blood_Type) {
        Blood b = mgr.find(Blood.class, Blood_Type);
        return b;
    }
       public Blood findRecord(String Blood_Type){
        query = mgr.createNamedQuery("Blood.findRecord");  
        query.setParameter("Blood_type", Blood_Type);
        return (Blood) query.getSingleResult();
    }
    
    public List<Blood> findAll() {
        List bList = mgr.createNamedQuery("Blood.findAll").getResultList();
        return bList;
    }
    public boolean updateBlood(Blood part) {
       Blood b = findRecord( part.getBloodType());
        if (b != null) {
            b.setBloodQuantity(part.getBloodQuantity());
            mgr.merge(part);
            return true;
        }
        return false;
    }
}
