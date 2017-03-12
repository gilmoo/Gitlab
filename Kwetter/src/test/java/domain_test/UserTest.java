/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain_test;

import domain.User;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ruthgervandeneikhof
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createNewUser(){
        User user = new User("ruthger_vde", "Ruthger", "wachtwoord");
        assertNotNull(user);
        assertEquals(user.getName(), "Ruthger");
        user.setPassword("password");
        assertEquals(user.getPassword(), "password");
        user.setUsername("newName");
        assertEquals(user.getUsername(), "newName");
    }
}
