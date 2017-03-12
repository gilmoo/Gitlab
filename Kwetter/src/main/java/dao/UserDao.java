/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class UserDao {
    @PersistenceContext
    EntityManager em;
    
    public List<User> allUsers(){
        return em.createNamedQuery("User.all").getResultList();
    }
    
    public User userByName(String username){
        try{
            User user;
            List<User> users;
            users = em.createNamedQuery("User.userByName").setParameter("username", username).getResultList();
            user = users.get(0);
            return user;
        } catch (Error er) {
            System.out.println(er.toString());
            User user;    
            return user = new User("","","");
        }
    }
    
    public List<User> friends(String username){
        try{
            User user;
            List<User> users;
            users = em.createNamedQuery("User.userByName").setParameter("username", username).getResultList();
            user = users.get(0);
            return user.getFriends();
        } catch (Error er) {
            System.out.println(er.toString());
            List<User> users = new ArrayList();
            return users;
        }
    }
    
    public boolean CreateNewUser(User user){
        try{
            em.persist(user);
        } catch(Error er) {
            System.out.println(er.toString());
            return false;
        }
        return true;
    }    
}
