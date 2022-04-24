/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import client.EmpClient;
import ejb.EmpSessionBeanLocal;
import entity.Dept;
import entity.Emp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author LENOVO
 */
@Named(value = "empManagedBean")
@ApplicationScoped
public class empManagedBean {

    @EJB
    private EmpSessionBeanLocal empSessionBean;

    EmpClient ec = new EmpClient();
    Emp e = new Emp();
    String eid,did,ename,dname;
    private List<Emp> eList;
    private List<Dept> dList;
    
    /**
     * Creates a new instance of empManagedBean
     */
    public empManagedBean() {
    }

    public Emp getE() {
        return e;
    }

    public void setE(Emp e) {
        this.e = e;
    }

    
    
    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> geteList() {
        return eList;
    }

    public void seteList(List<Emp> eList) {
        this.eList = eList;
    }

    public List<Dept> getdList() {
        return dList;
    }

    public void setdList(List<Dept> dList) {
        this.dList = dList;
    }

    public EmpSessionBeanLocal getEmpSessionBean() {
        return empSessionBean;
    }

    public void setEmpSessionBean(EmpSessionBeanLocal empSessionBean) {
        this.empSessionBean = empSessionBean;
    }

    public EmpClient getEc() {
        return ec;
    }

    public void setEc(EmpClient ec) {
        this.ec = ec;
    }
    
    
    
    public List<Emp> showEmp() {
        Response response = ec.empShowall(Response.class);
        ArrayList<Emp> elist = new ArrayList<>();
        GenericType<List<Emp>> eAdd = new GenericType<List<Emp>>(){};
        elist = (ArrayList<Emp>)response.readEntity(eAdd);
        return elist;
    }
    
    public List<Dept> showDept() {
        Response response = ec.deptShowall(Response.class);
        ArrayList<Dept> dlist = new ArrayList<>();
        GenericType<List<Dept>> dAdd = new GenericType<List<Dept>>(){};
        dlist = (ArrayList<Dept>)response.readEntity(dAdd);
        return dlist;
    }
    
    public String insertClickEmp() {
        try {
            System.out.println("Data"+ename+"    " + did);
            ec.empInsert("0", ename, did);
            return "showempjsf.xhtml?faces-redirect=true";
        } catch (ClientErrorException e) {
            return e.getMessage();
        }
    }
    
    public String editClickEmp(String id) {
        Response response = ec.empSearch(Response.class, id);
        GenericType<Emp> empSearch = new GenericType<Emp>(){};
        Emp e = response.readEntity(empSearch);
        eid = e.getEid().toString();
        did = e.getDid().getDid().toString();
        ename = e.getEname();
        return "/empjsf.xhtml";
    }
    
    public String updateClickEmp() {
        try {
            ec.empUpdate(eid, ename, did);
            return "/showempjsf.xhtml";
        } catch (ClientErrorException e) {
            return e.getMessage();
        }
    }
    
    public void deleteClickEmp(String id) {
        try {
            ec.empDelete(id);
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
    
    public void getEmpName(String ename) {
        empSessionBean.getEmpName(ename);
    }
    
    public List<Emp> listByEname() {
        Response response = ec.empSearchByEname(Response.class, ename);
        ArrayList<Emp> elist = new ArrayList<>();
        GenericType<List<Emp>> eAdd = new GenericType<List<Emp>>(){};
        elist = (ArrayList<Emp>)response.readEntity(eAdd);
        return elist;
    }
    
    public void getDeptName(String dname) {
        empSessionBean.getDeptName(dname);
    }
    
    public List<Emp> listByDname() {
        Response response = ec.empSearchByDname(Response.class, dname);
        ArrayList<Emp> elist = new ArrayList<>();
        GenericType<List<Emp>> eAdd = new GenericType<List<Emp>>(){};
        elist = (ArrayList<Emp>)response.readEntity(eAdd);
        return elist;
    }
    
}
