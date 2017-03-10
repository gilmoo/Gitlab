/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.all", query = "SELECT c FROM User c"),   
    @NamedQuery(name = "User.userByName", query = "SELECT c FROM User c WHERE c.name = :name")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String bio;
    private String web;
    private String location;
    
    @ManyToMany
    private List<User> friends;

    @ManyToMany(mappedBy = "friends")
    private List<User> users_friend;
    
    @OneToMany(mappedBy = "user_id")
    private List<Tweet> tweets;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
    
    
    public User(){    
    }
    
    public User(String username, String naam, String password){
        this.username = username;
        this.name = naam;
        this.password = password;
        this.friends = new ArrayList<>();
    }
    
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getUsers_friend() {
        return users_friend;
    }

    public void setUsers_friend(List<User> users_friend) {
        this.users_friend = users_friend;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getWeb() {
        return web;
    }

    public String getLocation() {
        return location;
    }


    public Long getId() {
        return user_id;
    }

    public void setId(Long id) {
        this.user_id = id;
    }
    
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
