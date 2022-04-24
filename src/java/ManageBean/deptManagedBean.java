/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import client.EmpClient;
import ejb.EmpSessionBeanLocal;
import entity.Dept;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author LENOVO
 */
@Named(value = "deptManagedBean")
@Dependent
public class deptManagedBean {

    @EJB
    private EmpSessionBeanLocal empSessionBean;

    EmpClient ec = new EmpClient();
    
    String did,dname;
    private List<Dept> dlist;
    
    
    /**
     * Creates a new instance of deptManagedBean
     */
    public deptManagedBean() {
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Dept> getDlist() {
        return dlist;
    }

    public void setDlist(List<Dept> dlist) {
        this.dlist = dlist;
    }
    
    public List<Dept> showDept() {
        Response response = ec.deptShowall(Response.class);
        ArrayList<Dept> dList = new ArrayList<>();
        GenericType<List<Dept>> dAdd = new GenericType<List<Dept>>(){};
        dList = (ArrayList<Dept>)response.readEntity(dAdd);
        return dList;
    }
    
    public void insertClickDept() {
        try {
            ec.deptInsert("0", dname);
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
    
    public void deleteClickDept(String did) {
        try {
            ec.deptDelete(did);
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
    
    public void editClickDept(String id) {
        Response response = ec.deptSearch(Response.class, id);
        GenericType<Dept> searchdept = new GenericType<Dept>(){};
        Dept d = response.readEntity(searchdept);
        did = d.getDid().toString();
        dname = d.getDname();
        
    }
    
    public void updateClickDept() {
        try {
            ec.deptUpdate(did, dname);
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
    
}
