/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Dept;
import entity.Emp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LENOVO
 */
@Local
public interface EmpSessionBeanLocal {
    
    public String deptInsert(int did, String dname);
    public String deptUpdate(int did, String dname);
    public String deptDelete(int did);
    public Dept deptSearch(int did);
    public List<Dept> deptShowall();
    
    public String empInsert(int eid, String ename, int did);
    public String empUpdate(int eid, String ename, int did);
    public String empDelete(int eid);
    public Emp empSearch(int eid);
    public List<Emp> empShowall();
    
    public List<Dept> getDeptName(String dname);
    public List<Emp> getEmpName(String ename);
    
}
