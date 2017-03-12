/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.RoleDao;
import dao.TweetDao;
import dao.UserDao;
import domain.Role;
import domain.Tweet;
import domain.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Singleton
@Startup
public class Init {
    @Inject
    UserDao userDao;
    @Inject
    TweetDao  tweetDao;
    @Inject
    RoleDao roleDao;
    List<User> friends;
    
    @PostConstruct
    public void init(){
        User user = new User( "ruthger_vde","Ruthger van den Eikhof",PasswordHash.stringToHash("r"));   
        User user2 = new User( "lino_t","Lino Thaencharun",PasswordHash.stringToHash("l"));
        userDao.CreateNewUser(user);
        userDao.CreateNewUser(user2);
        System.out.println(PasswordHash.stringToHash("r"));
        Role role = new Role("User");
        roleDao.CreateNewRole(role);
        List<User> users = new ArrayList<>();
        users.add(user);
        role.setUsers(users);
        roleDao.addRole(role);
        role = new Role("Administrator");
        roleDao.CreateNewRole(role);
        users.clear();
        users.add(user2);
        role.setUsers(users);
        roleDao.addRole(role);       
        Date date = new Date();
        Tweet tweet = new Tweet("blablaalblabl", date, user.getUsername());
        Tweet tweet1 = new Tweet("testsretestes", date, user.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweetDao.CreateNewTweet(tweet1);
        friends = new ArrayList<>();
        friends.add(user);
        user2.setFriends(friends);
        userDao.CreateNewUser(user2);
        User user3 = userDao.userByName("ruthger_vde");
        System.out.println(user3.getName());
        userDao.CreateNewUser(user3);
    }
    
}
