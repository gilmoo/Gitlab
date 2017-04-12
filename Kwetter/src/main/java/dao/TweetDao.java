/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Tweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public Tweet maakNewTweet(Tweet tweet){
        em.persist(tweet);
        em.flush();
        return em.find(Tweet.class, tweet.getId());
    }
    
    public List<Tweet> tweetSearch(String bericht, String username){
        Query query = em.createNamedQuery("Tweet.tweetSearch").setParameter("username", "%" + username + "%").setParameter("bericht", "%" + bericht + "%");
        return query.getResultList();
    }
    
    public List<Tweet> tweetsByUser(String username){
        List<Tweet> tweets;
        tweets = em.createNamedQuery("Tweet.tweetsByUser").setParameter("username", username).getResultList();
        return tweets;
    }
}
