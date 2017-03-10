/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Role;
import domain.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class RoleDao {
    @PersistenceContext
    EntityManager em;
    
    public void CreateNewRole(Role r){
        em.persist(r);
    }
    
    public void addRole(Role role){
        em.merge(role);
    }
}
