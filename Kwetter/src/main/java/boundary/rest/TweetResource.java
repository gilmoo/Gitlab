/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Tweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import service.TweetService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
@Path("Tweet")
public class TweetResource {
    @Inject
    TweetService tweetService;
    
    @GET
    public List<Tweet> allTweets(){
        return tweetService.allTweets();
    } 
}
