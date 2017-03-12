/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Tweet;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.TweetService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
@Path("Tweet")
@DeclareRoles({"UserRole"})
public class TweetResource {
    @Inject
    TweetService tweetService;
    
    @GET
    @Path("allTweets")
    @RolesAllowed("UserRole") 
    public List<Tweet> allTweets(){
        return tweetService.allTweets();
    } 
    
    @GET
    @Path("/tweetsByUser/{user}")
    @RolesAllowed("UserRole") 
    public List<Tweet> tweetsByUser(@PathParam("user")String username){
        return tweetService.tweetsByUser(username);
    }
}
