package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class BloodTransactionService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public BloodTransactionService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addBloodTransaction(Bloodtransaction bt) {
        mgr.persist(bt);
        return true;
    }

    public Bloodtransaction findByBTID(String BT_ID) {
        Bloodtransaction bt = mgr.find(Bloodtransaction.class, BT_ID);
        return bt;
    }

       public Bloodtransaction findRecord(String BT_ID){
        query = mgr.createNamedQuery("Bloodtransaction.findRecord");  
        query.setParameter("BT_id", BT_ID);
        return (Bloodtransaction) query.getSingleResult();
    }
    
    public List<Bloodtransaction> findAll() {
        List btList = mgr.createNamedQuery("Bloodtransaction.findAll").getResultList();
        return btList;
    }
}