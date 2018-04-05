package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class StaffService {
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;
    
    public StaffService (EntityManager mgr){
        this.mgr = mgr;
    }
    
    public boolean addRecord(Staff staff){
        mgr.persist(staff);
        return true;
    }
    
    public Staff findStaffById(String staffId){
        query = mgr.createNamedQuery("staff.findByStaffId");
        query.setParameter("staffId", staffId);
        return (Staff)query.getSingleResult();
    }

    public Staff findStaffByName(String staffName){
        query = mgr.createNamedQuery("Staff.findByStaffNname");
        query.setParameter("staffName", staffName);
        try {
            return (Staff) query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    public boolean deleteStaff(String staffId){
        Staff staff = findStaffById(staffId);
        if(staff != null){
            mgr.remove(staff);
            return true;
        }
        return false;
    }
    
    
    public boolean checkStaffId(String StaffId){
        query = mgr.createNamedQuery("Staff.findByStaffId");
        query.setParameter("staffId", StaffId);
        try {
            query.getSingleResult();
            return false; // username taken
        } catch (NoResultException e){
            return true; //username available
        }

    }
    
    
    public List<Staff> findAllStaff(){
        return mgr.createNamedQuery("Staff.findStaff").getResultList();
    }
    
    public boolean updateStaff(Staff staff){
        Staff tempStaff = findStaffById(staff.getStaffId());
        if (tempStaff != null){
            tempStaff.setStaffId(staff.getStaffId());
            tempStaff.setStaffPassword(staff.getStaffPassword());
            tempStaff.setPosition(staff.getPosition());
            mgr.merge(tempStaff);
            return true;
        }
        return false;
    }
}