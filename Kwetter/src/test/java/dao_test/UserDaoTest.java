/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_test;

import dao.UserDao;
import domain.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ruthgervandeneikhof
 */
public class UserDaoTest {
    private UserDao ud;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;
    
    public UserDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ud = new UserDao();
        emf = Persistence.createEntityManagerFactory("Kwetter_test_persist");
        em = emf.createEntityManager();
        et = em.getTransaction();
        ud.setDao(em);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createNewUserTest(){
        User user = new User("victor_v","victor","pass");
        et.begin();
        ud.CreateNewUser(user);
        et.commit();
    }
}
