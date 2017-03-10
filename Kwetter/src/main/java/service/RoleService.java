/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RoleDao;
import domain.Role;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class RoleService {
    @Inject
    RoleDao roleDao;
    
    public void Save(Role r){
        roleDao.CreateNewRole(r);
    }
    
    public void addRole(Role role){
        roleDao.addRole(role);
    }
}
