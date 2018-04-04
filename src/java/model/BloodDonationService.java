package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class BloodDonationService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public BloodDonationService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addBlooddonation(Blooddonation bd) {
        mgr.persist(bd);
        return true;
    }

    public Blooddonation findByBDID(String BD_ID) {
        Blooddonation bd = mgr.find(Blooddonation.class, BD_ID);
        return bd;
    }

       public Blooddonation findRecord(String BD_ID){
        query = mgr.createNamedQuery("Blooddonation.findRecord");  
        query.setParameter("BD_id", BD_ID);
        return (Blooddonation) query.getSingleResult();
    }
    


    public List<Blooddonation> findAll() {
        List bdList = mgr.createNamedQuery("Blooddonation.findAll").getResultList();
        return bdList;
    }

  
}


