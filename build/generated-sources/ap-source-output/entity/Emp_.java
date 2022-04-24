package entity;

import entity.Dept;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-25T01:53:26")
@StaticMetamodel(Emp.class)
public class Emp_ { 

    public static volatile SingularAttribute<Emp, Integer> eid;
    public static volatile SingularAttribute<Emp, String> ename;
    public static volatile SingularAttribute<Emp, Dept> did;

}