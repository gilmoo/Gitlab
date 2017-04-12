/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Tweet.all", query = "SELECT c FROM Tweet c"),
    @NamedQuery(name = "Tweet.tweetsByUser", query = "SELECT c FROM Tweet c WHERE c.username = :username"),
    @NamedQuery(name = "Tweet.tweetSearch", query = "SELECT c FROM Tweet c WHERE c.bericht LIKE :bericht OR c.username LIKE :username")
})
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bericht;
    private String datum;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public Tweet(){}
    
    public Tweet(String bericht, String datum, String username){
        this.bericht = bericht;
        this.datum = datum;
        this.username = username;
    }

    public String getBericht() {
        return bericht;
    }

    public void setBericht(String bericht) {
        this.bericht = bericht;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
