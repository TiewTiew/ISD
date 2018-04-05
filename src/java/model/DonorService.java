package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class DonorService {
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;
    
    public DonorService (EntityManager mgr){
        this.mgr = mgr;
    }
    
    public boolean addRecord(Donor donor){
        mgr.persist(donor);
        return true;
    }
    
    public Donor findDonorById(String studentid){
        query = mgr.createNamedQuery("Donor.findByDonorId");
        query.setParameter("donorId", donorId);
        return (Donor)query.getSingleResult();
    }

    public Donor findDonorByName(String donorName){
        query = mgr.createNamedQuery("Member.findByDonorName");
        query.setParameter("donorName", donorName);
        try {
            return (Donor) query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    public boolean deleteDonor(String donorid){
        Donor donor = findDonorById(donorid);
        if(donor != null){
            mgr.remove(donor);
            return true;
        }
        return false;
    }

    public boolean checkDonorId(String donorId){
        query = mgr.createNamedQuery("Donor.findByDonorId");
        query.setParameter("donorId", donorId);
        try {
            query.getSingleResult();
            return false; // id taken
        } catch (NoResultException e){
            return true; //id available
        }

    }
    
    
    public List<Donor> findAllDonor(){
        return mgr.createNamedQuery("Donor.findDonor").getResultList();
    }
    
    public boolean updateDonor(Donor donor){
        Donor tempDonor = findDonorById(donor.getDonorId());
        if (tempDonor != null){
            tempDonor.setDonorId(donor.getDonorId());
            tempDonor.setDonorPassword(donor.getDonorPassword());
            mgr.merge(tempDonor);
            return true;
        }
        return false;
    }
}