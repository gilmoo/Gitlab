/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
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
    
    public List<User> allFriends(User u){
        return em.createNamedQuery("User.allFriends").getResultList();
    }
    
    public User userByName(String name){
        User user;
        List<User> users;
        users = em.createNamedQuery("User.userByName").setParameter("name", name).getResultList();
        user = users.get(0);
        return user;
    }
    
    public void CreateNewUser(User user){
        em.persist(user);
    }    
}
