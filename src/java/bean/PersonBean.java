/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PersonDAO;
import entity.Person;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author test
 */
@ManagedBean
@SessionScoped
public class PersonBean {

   private Person p=new Person();
   private PersonDAO pDAO=new PersonDAO();
   private List<Person> persons;
    public PersonBean() {
    }
    public String add(){
        pDAO.add(p);
        p.setName(null);p.setEmail(null);p.setTelephone(null);
        return "index";
    }
    public String remove(){
        pDAO.delete(p);
        p.setName(null);p.setEmail(null);p.setTelephone(null);
        return "index";
    }
    public String change(){
        pDAO.update(p);
       p.setId(null); p.setName(null);p.setEmail(null);p.setTelephone(null);
        return "index";
    }
    public String load(Person person){
        this.p=person;
        return "edit";
    }
    public List<Person> list(){
        persons=pDAO.getPersons();
        return persons;
    }
    
}
