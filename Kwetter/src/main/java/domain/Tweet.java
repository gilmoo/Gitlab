/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
@NamedQuery(name = "Tweet.all", query = "SELECT c FROM Tweet c")
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bericht;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datum;
    @ManyToOne
    private User user_id;
    
    
    public Tweet(){}
    
    public Tweet(String bericht, Date datum){
        this.bericht = bericht;
        this.datum = datum;
    }

    public String getBericht() {
        return bericht;
    }

    public void setBericht(String bericht) {
        this.bericht = bericht;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
