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
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.imageio.ImageIO;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Singleton
@Startup
public class Init {
    byte[] imageInByte;
    @Inject
    UserDao userDao;
    @Inject
    TweetDao tweetDao;
    @Inject
    RoleDao roleDao;
    List<User> friends;
    List<User> following;

    @PostConstruct
    public void init() {
        following = new ArrayList<>();
        User user = new User("ruthger_vde", "Ruthger van den Eikhof", PasswordHash.stringToHash("r"), "SoftwareEngineer bij fontys hogeschool", "www.imAwesome.com", "Walsberg");
        User user2 = new User("lino_t", "Lino Thaencharun", PasswordHash.stringToHash("l"), "Vrachtwagenchauffeur", "www.supachoi.com", "Eindhoven");
        user.setImage("Resources/fu.jpeg");
        user2.setImage("Resources/straw_hat.jpeg");
        following.add(user);
        userDao.CreateNewUser(user);
        userDao.CreateNewUser(user2);
        User user3 = new User("victor_vdv", "Victor van der Vorst", PasswordHash.stringToHash("v"), "pieter bij fontys hogeschool", "www.Limburg.com", "Limbabwe");
        user3.setImage("Resources/rosjan.jpg");
        user3.setFollowing(following);
        userDao.CreateNewUser(user3);
        System.out.println(PasswordHash.stringToHash("r"));
        Role role = new Role("User");
        roleDao.CreateNewRole(role);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user3);
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
        tweet = new Tweet("Goed gegeten!", date, user3.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweet = new Tweet("Fontys? nou nee.", date, user3.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweet = new Tweet("Best day ever!", date, user2.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweet = new Tweet("Avondje stappen met de maten", date, user2.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweet = new Tweet("PSV Landskampioen!", date, user2.getUsername());
        tweetDao.CreateNewTweet(tweet);
        friends = new ArrayList<>();
        friends.add(user);
        friends.add(user3);
        user2.setFriends(friends);
        userDao.CreateNewUser(user2);
    }

}
