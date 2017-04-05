/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_test;

import dao.UserDao;
import domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import service.UserService;
import util.PasswordHash;

/**
 *
 * @author ruthgervandeneikhof
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    
    private static UserService us;
    @Mock
    private static UserDao ud;
    private static User user;
    private static User user2;
    
    public UserServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<User> users = new ArrayList();
        List<User> friends = new ArrayList();
        user = new User( "ruthger_vde","Ruthger van den Eikhof",PasswordHash.stringToHash("r"),"SoftwareEngineer bij fontys hogeschool","www.imAwesome.com", "Walsberg");
        user2 = new User( "lino_t","Lino Thaencharun",PasswordHash.stringToHash("l"),"SoftwareEngineer bij fontys hogeschool","www.imAwesome.com", "Walsberg");
        User user3 = new User("victor_v", "Victor van der Vorst",PasswordHash.stringToHash("v"),"SoftwareEngineer bij fontys hogeschool","www.imAwesome.com", "Walsberg");
        users.add(user);
        users.add(user2);
        users.add(user3);
        friends.add(user);
        friends.add(user2);
        us = new UserService();
        us.setDao(ud);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getUserByNameTest(){
        String name = "Ruthger van den Eikhof";
        User user1 = us.userByName(name);
        verify(ud, Mockito.times(1)).userByName(name);
    }
    
    @Test
    public void createNewUserTest(){
        us.createNewUser(user);
        verify(ud, Mockito.times(1)).CreateNewUser(user);
    }
    
    @Test
    public void allFriendsTest(){
        List<User> friends;
        friends = us.allFriends("lino_t");
        verify(ud, Mockito.times(1)).friends("lino_t");
    }
    
    @Test
    public void allUsersTest(){
        List<User> allUsers;
        allUsers = us.allUsers();
        verify(ud, Mockito.times(1)).allUsers();
    }
}
