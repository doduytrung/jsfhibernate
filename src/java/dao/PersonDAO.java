/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Person;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author test
 */
public class PersonDAO {
    private Session s;
    private Transaction t;
    List<Person> persons;

    public List<Person> getPersons() {
        s=HibernateUtil.getSessionFactory().openSession();
        t=s.getTransaction();
        Criteria c=s.createCriteria(Person.class);
        this.persons=c.list();
        return persons;
    }
    public void add(Person p){
        s=HibernateUtil.getSessionFactory().openSession();
        t=s.getTransaction();
        s.save(p);
        t.commit();
    }
     public void update(Person p){
        s=HibernateUtil.getSessionFactory().openSession();
        t=s.getTransaction();
        s.update(p);
        t.commit();
    }
      public void delete(Person p){
        s=HibernateUtil.getSessionFactory().openSession();
        t=s.getTransaction();
        s.delete(p);
        t.commit();
    }
    
}
