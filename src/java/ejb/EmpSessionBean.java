/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Dept;
import entity.Emp;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LENOVO
 */
@Stateless
public class EmpSessionBean implements EmpSessionBeanLocal {
    
    
    @PersistenceContext(unitName = "EmpDemoPU")
    EntityManager em;

    @Override
    public String deptInsert(int did, String dname) {
        
        try {
            Dept d = new Dept();
            d.getDid();
            d.getDname();
            em.persist(d);
            return "Inserted";
        } catch (Exception e) {
            return e.getMessage();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deptUpdate(int did, String dname) {
        
        try {
            Dept d = (Dept)em.find(Dept.class, did);
            d.setDid(did);
            d.setDname(dname);
            em.merge(d);
            return "Updated";
        } catch (Exception e) {
            return e.getMessage();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deptDelete(int did) {
        
        try {
            
            Dept d = (Dept)em.find(Dept.class, did);
            em.detach(d);
            return "Deleted";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dept deptSearch(int did) {
        
        try {
            Dept d = (Dept)em.find(Dept.class, did);
            return d;
        } catch (Exception e) {
            return null;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dept> deptShowall() {
        
        List<Dept> dList = em.createNamedQuery("Dept.findAll").getResultList();
        return dList;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String empInsert(int eid, String ename, int did) {
        
        try {
            
            Dept d = (Dept)em.find(Dept.class, did);
            Collection<Emp> empc = d.getEmpCollection();
            
            Emp e = new Emp();
            
            e.setEid(eid);
            e.setEname(ename);
            e.setDid(d);
            
            empc.add(e);
            d.setEmpCollection(empc);
            
            em.persist(e);
            em.merge(d);
            
            return "Inserted";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String empUpdate(int eid, String ename, int did) {
        
        try {
            
            Dept d = (Dept)em.find(Dept.class,did);
            Collection<Emp> empc = d.getEmpCollection();
            
            Emp e = (Emp)em.find(Emp.class, eid);
            
            e.setEid(eid);
            e.setDid(d);
            e.setEname(ename);
            
            empc.add(e);
            d.setEmpCollection(empc);
            
            em.persist(e);
            em.merge(d);
            
            return "Updated";
            
        } catch (Exception e) {
            
            return e.toString();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String empDelete(int eid) {
        
        try {
            
            Emp e = (Emp)em.find(Emp.class, eid);
            em.remove(e);
            
            return "Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Emp empSearch(int eid) {
        
        try {
            
            Emp e = em.find(Emp.class, eid);
            return e;
            
        } catch (Exception e) {
            
            return null;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emp> empShowall() {
        
        List<Emp> eList = em.createNamedQuery("Emp.findAll").getResultList();
        return eList;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Dept> getDeptName(String dname) {
        
        return em.createNamedQuery("Emp.findEmpByDeptName").setParameter("dname", dname).getResultList();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emp> getEmpName(String ename) {
        
        return em.createNamedQuery("Emp.findByEname").setParameter("ename", ename).getResultList();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
