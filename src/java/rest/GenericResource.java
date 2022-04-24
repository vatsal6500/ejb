/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.EmpSessionBeanLocal;
import entity.Dept;
import entity.Emp;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author LENOVO
 */
@Path("generic")
public class GenericResource {

    @EJB EmpSessionBeanLocal es;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @Path("deptadd/{did}/{dname}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String deptInsert(@PathParam("did")Integer did, @PathParam("dname")String dname) {
        
        return es.deptInsert(did, dname);
        
    }
    
    @Path("deptupdate/{did}/{dname}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String deptUpdate(@PathParam("did")int did, @PathParam("dname")String dname) {
        return es.deptUpdate(did, dname);
    }
    
    @Path("deptdelete/{did}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String deptDelete(@PathParam("did")int did) {
        return es.deptDelete(did);
    }
    
    @Path("deptsearch/{did}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Dept deptSearch(@PathParam("did")int did) {
        return es.deptSearch(did);
    }
    
    @Path("deptdisplay")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dept> deptShowall() {
        return es.deptShowall();
    }
    
    @Path("empadd/{eid}/{ename}/{did}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String empInsert(@PathParam("eid")int eid, @PathParam("ename")String ename, @PathParam("did")int did) {
        return es.empInsert(eid, ename, did);
    }
    
    @Path("deptupdate/{eid}/{ename}/{did}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String empUpdate(@PathParam("eid")int eid, @PathParam("ename")String ename, @PathParam("did")int did) {
        return es.empUpdate(eid, ename, did);
    }
    
    @Path("empdelete/{eid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String empDelete(@PathParam("eid")int eid) {
        return es.empDelete(eid);
    }
    
    @Path("empsearch/{eid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Emp empSearch(@PathParam("eid")int eid) {
        return es.empSearch(eid);
    }
    
    @Path("empdisplay")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Emp> empShowall() {
        return es.empShowall();
    }
    
    @Path("empbyename/{ename}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Emp> empSearchByEname(@PathParam("ename")String ename) {
        return es.getEmpName(ename);
    }
    
    @Path("empbydname/{dname}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dept> empSearchByDname(@PathParam("dname")String dname) {
        return es.getDeptName(dname);
    }
    
}
