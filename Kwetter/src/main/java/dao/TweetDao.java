/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Tweet;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class TweetDao {
    @PersistenceContext
    EntityManager em;
    
    public List<Tweet> allTweets(){    
        return em.createNamedQuery("Tweet.all").getResultList();
    }
    
    public void CreateNewTweet(Tweet tweet){
        em.persist(tweet);
    }
    
    public List<Tweet> tweetsByUser(String username){
        List<Tweet> tweets;
        tweets = em.createNamedQuery("Tweet.tweetsByUser").setParameter("username", username).getResultList();
        return tweets;
    }
}
