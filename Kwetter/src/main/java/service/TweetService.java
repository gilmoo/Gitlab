/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TweetDao;
import domain.Tweet;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class TweetService {
    @Inject
    TweetDao tweetDao;
    
    public List<Tweet> allTweets(){
        return tweetDao.allTweets();
    }
    
    public List<Tweet> tweetsByUser(String username){
        return tweetDao.tweetsByUser(username);
    }
    
    public List<Tweet> tweetSearch(String bericht, String username){
        return tweetDao.tweetSearch(bericht, username);
    }

    public Tweet createNewTweet(Tweet tweet) {
        return tweetDao.maakNewTweet(tweet);
    }
}
