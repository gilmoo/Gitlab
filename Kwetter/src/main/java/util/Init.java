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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
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

    byte[] imageInByte;
    @Inject
    UserDao userDao;
    @Inject
    TweetDao tweetDao;
    @Inject
    RoleDao roleDao;
    List<User> friends;

    @PostConstruct
    public void init() {
        String image;
        String s = "/Users/ruthgervandeneikhof/Documents/School/S6/JEA/Gitlab/Kwetter/src/main/webapp/Resources/straw_hat.JPEG";
        //File file = new File(classLoader.getResource(s).getFile());
        image = encodeFileToBase64Binary(new File(s));

        User user = new User("ruthger_vde", "Ruthger van den Eikhof", PasswordHash.stringToHash("r"), "SoftwareEngineer bij fontys hogeschool", "www.imAwesome.com", "Walsberg");
        User user2 = new User("lino_t", "Lino Thaencharun", PasswordHash.stringToHash("l"), "Vrachtwagenchauffeur", "www.supachoi.com", "Eindhoven");
        user.setImage(image);
        user2.setImage(image);
        userDao.CreateNewUser(user);
        userDao.CreateNewUser(user2);
        User user3 = new User("victor_vdv", "Victor van der Vorst", PasswordHash.stringToHash("v"), "pieter bij fontys hogeschool", "www.Limburg.com", "Limbabwe");
        user3.setImage(image);
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
        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        Tweet tweet = new Tweet("Angular: je kunt er van houden, maar je kunt het ook zeker haten. Het vergt wat moeite om te leren", date, user.getUsername());
        Tweet tweet1 = new Tweet("testsretestes", date, user.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweetDao.CreateNewTweet(tweet1);
        tweet = new Tweet("Vandaag lekker uit wezen eten! In lange tijden niet zo veel gegeten! zeker voor herhaling vatbaar.", date, user3.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweet = new Tweet("Fontys? nou nee.", date, user3.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweet = new Tweet("Best day ever!", date, user2.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweet = new Tweet("Avondje stappen met de maten", date, user2.getUsername());
        tweetDao.CreateNewTweet(tweet);
        tweet = new Tweet("Ik ben van mening dat het Forum voor Democratie met Theo Hiddema & Thiery Baudet goed vertegenwoordigd is.", date, user2.getUsername());
        tweetDao.CreateNewTweet(tweet);
        friends = new ArrayList<>();
        friends.add(user);
        friends.add(user3);
        user2.setFriends(friends);
        userDao.CreateNewUser(user2);
    }

    private static String encodeFileToBase64Binary(File file) {
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }

}
