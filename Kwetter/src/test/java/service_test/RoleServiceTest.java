/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_test;

import dao.RoleDao;
import domain.Role;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import service.RoleService;

/**
 *
 * @author ruthgervandeneikhof
 */
@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {
    @Mock
    private static RoleService rs;
    @Mock
    private static RoleDao rd;
    private static Role role;
    
    public RoleServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rs = mock(RoleService.class);
        role = new Role("Users");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void CreateNewRoleTest(){
        rs.CreateNewRole(role);
    }
    
    
}
