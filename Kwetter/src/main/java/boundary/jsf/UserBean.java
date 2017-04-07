/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jsf;

import domain.User;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import service.UserService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

    @Inject
    UserService userService;

    private List<User> users = new ArrayList<>();
    private List<User> friends = new ArrayList<>();
    private User user;
    private String profilePic;

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    private String loggedUsername;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void onPageLoad() throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        loggedUsername = request.getRemoteUser();
        if (loggedUsername == null) {
            loggedUsername = "Niet ingelogd";
            profilePic = "";
        } else {
            user = userService.userByName(loggedUsername);
            profilePic = user.getImage();
            friends.clear();
            friends = user.getFriends();
        }
    }

    public void refreshUsers() {
        users = userService.allUsers();
    }

    public void setUsers(ArrayList users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
