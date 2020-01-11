package com.mymemor.mymemor;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mymemor.mymemor.model.User;

@SuppressWarnings("deprecation")
public class Utilis {
	

   
    public static Object check(String p)
    {
    	Configuration con =new Configuration().configure().addAnnotatedClass(User.class);
        
    	SessionFactory sf =con.buildSessionFactory();
    	 
        Session s=sf.openSession();
    Transaction tx=s.beginTransaction();
    
    Query query=s.createQuery(p);
    Object o=query.uniqueResult();
   
	 tx.commit();
    return o;
    }

}