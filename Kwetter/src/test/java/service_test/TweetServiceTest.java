/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_test;

import domain.Tweet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import service.TweetService;

/**
 *
 * @author ruthgervandeneikhof
 */
@RunWith(MockitoJUnitRunner.class)
public class TweetServiceTest {
    @Mock
    private static TweetService ts;
    private static Tweet tweet;
    private static Tweet tweet2;
            
    public TweetServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ts = mock(TweetService.class);
        Date date = new Date();
        List<Tweet> tweets = new ArrayList();
        tweet = new Tweet("test", date, "ruthger_vde");
        tweet2 = new Tweet("test2", date,"ruthger_vde");
        tweets.add(tweet);
        tweets.add(tweet2);
        when(ts.allTweets()).thenReturn(tweets);
        when(ts.tweetsByUser("ruthger_vde")).thenReturn(tweets);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void allTweetsTest(){
        List<Tweet> tweets;
        tweets = ts.allTweets();
        assertNotNull(tweets);
        assertEquals(tweets.get(0).getBericht(),"test");
    }
    
    @Test
    public void tweetsByUserTest(){
        String username = "ruthger_vde";
        String username2 = "lino_t";
        List<Tweet> tweets;
        tweets = ts.tweetsByUser(username2);
        assertTrue(tweets.isEmpty());
        tweets = ts.tweetsByUser(username);
        assertNotNull(tweets);
        assertEquals(tweets.get(0).getBericht(),"test");
    }
}
