/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class UserService {
    @Inject
    UserDao userDao;
    
    public List<User> allUsers(){
        return userDao.allUsers();
    }
    
    public List<User> allFriends(User u){
        return userDao.allFriends(u);
    }
    
    public User userByName(String name){
        return userDao.userByName(name);
    }
}
