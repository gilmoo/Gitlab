/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain_test;

import domain.Tweet;
import java.util.Date;
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
public class TweetTest {
    
    public TweetTest() {
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
    public void createNewTweet(){
        Date date = new Date();
        Tweet tweet = new Tweet("Dit is een bericht.", date.toString(), "ruthger_vde");
        assertNotNull(tweet);
        assertEquals(tweet.getBericht(),"Dit is een bericht.");
        tweet.setBericht("Dit is een nieuw bericht");
        assertEquals(tweet.getBericht(),"Dit is een nieuw bericht");
    }
}
