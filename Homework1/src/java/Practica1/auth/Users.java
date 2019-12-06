/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1.auth;

import Practica1.Room;
import java.io.Serializable;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "USERS")
@NamedQuery(name = "Room.findUser", query = "SELECT u FROM Users u WHERE u.hashCode = :hashCode")
public class Users implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id @Column(name = "USERNAME")
    private String username;
    @Column(name = "HASH_CODE")
    private String hashCode;

    public Users() {
    }

    
    public Users(String username, String hash) {
        this.username = username;
        this.hashCode = hash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hash) {
        this.hashCode = hash;
    }
    
    
    
    
}
