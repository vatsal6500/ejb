package entity;

import entity.Emp;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-25T01:53:26")
@StaticMetamodel(Dept.class)
public class Dept_ { 

    public static volatile SingularAttribute<Dept, String> dname;
    public static volatile CollectionAttribute<Dept, Emp> empCollection;
    public static volatile SingularAttribute<Dept, Integer> did;

}