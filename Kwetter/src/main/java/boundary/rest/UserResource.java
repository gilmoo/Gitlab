/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.User;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import service.UserService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
@Path("User")
@DeclareRoles({"UserRole"})
public class UserResource {
    @Inject
    UserService userService;
    
    @GET
    @Path("allUsers")
    @RolesAllowed("UserRole")  
    public List<User> allUsers(){
        return userService.allUsers();
    }
    
}
