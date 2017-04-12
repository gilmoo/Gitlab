/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Tweet;
import domain.User;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.TweetService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
@Path("Tweet")
@PermitAll
public class TweetResource {
    @Inject
    TweetService tweetService;
    
    @GET
    @Path("allTweets")
    public List<Tweet> allTweets(){
        return tweetService.allTweets();
    } 
    
    @GET
    @Path("/tweetsByUser/{user}")
    public List<Tweet> tweetsByUser(@PathParam("user")String username){
        return tweetService.tweetsByUser(username);
    }
    
    @GET
    @Path("tweetSearch/{bericht}/{username}")
    public List<Tweet> tweetSearch(@PathParam("bericht")String bericht, @PathParam("username")String username){
        return tweetService.tweetSearch(bericht, username);
    }
    
    @POST
    @Path("createTweet")
    @Consumes("application/json")
    public Tweet createNewTweet(Tweet tweet){
         return tweetService.createNewTweet(tweet);
    }
}
