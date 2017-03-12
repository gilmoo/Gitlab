/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain_test;

import domain.Role;
import domain.User;
import java.util.ArrayList;
import java.util.List;
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
public class RoleTest {
    
    public RoleTest() {
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
    public void createNewRole(){
        User user = new User("ruthger_vde", "Ruthger", "ww");
        List<User> users = new ArrayList();
        users.add(user);
        Role role = new Role("Users");
        assertNotNull(role);
        assertNotNull(users);
        role.setUsers(users);
        assertEquals(role.getUsers(), users);
        assertEquals(role.getRoleName(), "Users");
    }
}
