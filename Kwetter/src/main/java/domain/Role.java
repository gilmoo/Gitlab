/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
public class Role implements Serializable {
    @Id
    private String roleName;
    
    @ManyToMany
    @JoinTable(name="USER_ROLE",
        joinColumns = @JoinColumn(name = "roleName",
        referencedColumnName = "roleName"), inverseJoinColumns = @JoinColumn(name = "username",
        referencedColumnName = "username"))
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }
        
    public String getRoleName() {
        return roleName;
    }
    
    public Role(){}
    
    public Role(String roleName){
        this.roleName = roleName;
        this.users = new ArrayList<User>();
    }
}
