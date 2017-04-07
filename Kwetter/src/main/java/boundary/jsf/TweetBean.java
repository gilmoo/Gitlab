/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jsf;

import domain.Tweet;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import service.TweetService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Named
@SessionScoped
public class TweetBean implements Serializable {

    @Inject
    TweetService tweetService;

    private List<Tweet> tweetsByUser;
    
    private String loggedUsername;

    public void onPageLoad() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        loggedUsername = request.getRemoteUser();
        refreshTweets();
    }

    public void refreshTweets() {
        if (loggedUsername != null) {
            tweetsByUser = tweetService.tweetsByUser(loggedUsername);
        }
    }
    
    public List<Tweet> getTweetsByUser() {
        return tweetsByUser;
    }

    public void setTweetsByUser(List<Tweet> tweetsByUser) {
        this.tweetsByUser = tweetsByUser;
    }

}
