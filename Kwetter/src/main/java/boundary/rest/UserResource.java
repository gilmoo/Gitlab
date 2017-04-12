/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.User;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.UserService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
@Path("User")
@PermitAll
public class UserResource {
    @Inject
    UserService userService;
    
    @GET
    @Path("allUsers")
    public List<User> allUsers(){
        return userService.allUsers();
    }
    
    @POST
    @Path("CreateUser")
    @Consumes("application/json")
    public boolean createNewUser(User user){
         return userService.createNewUser(user);
    }
    
    @GET
    @Path("userByUsername/{username}")
    public User userByUsername(@PathParam("username")String username){
        return userService.userByName(username);
    } 
    
    @GET
    @Path("Friends/{id}")
    public List<User> allFriends(@PathParam("id")String username){
        return userService.allFriends(username);
    } 
}
