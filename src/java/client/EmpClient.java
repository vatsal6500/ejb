/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        EmpClient client = new EmpClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author LENOVO
 */
public class EmpClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/EmpDemo/webresources";

    public EmpClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public String deptDelete(String did) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deptdelete/{0}", new Object[]{did})).request().post(null, String.class);
    }

    public String deptInsert(String did, String dname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deptadd/{0}/{1}", new Object[]{did, dname})).request().post(null, String.class);
    }

    public String deptUpdate(String did, String dname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deptupdate/{0}/{1}", new Object[]{did, dname})).request().post(null, String.class);
    }

    public <T> T deptShowall(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("deptdisplay");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String empDelete(String eid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("empdelete/{0}", new Object[]{eid})).request().post(null, String.class);
    }

    public <T> T deptSearch(Class<T> responseType, String did) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("deptsearch/{0}", new Object[]{did}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T empSearch(Class<T> responseType, String eid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("empsearch/{0}", new Object[]{eid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T empSearchByEname(Class<T> responseType, String ename) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("empbyename/{0}", new Object[]{ename}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T empShowall(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("empdisplay");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String empInsert(String eid, String ename, String did) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("empadd/{0}/{1}/{2}", new Object[]{eid, ename, did})).request().post(null, String.class);
    }

    public <T> T empSearchByDname(Class<T> responseType, String dname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("empbydname/{0}", new Object[]{dname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String empUpdate(String eid, String ename, String did) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deptupdate/{0}/{1}/{2}", new Object[]{eid, ename, did})).request().post(null, String.class);
    }

    public void close() {
        client.close();
    }
    
}
