/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1.auth;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergi
 */
@Entity
@Table(name="USUARI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuari.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "Usuari.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "Usuari.login", query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
})
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Gen")
    @Column(name = "USUARI_ID")
    private int usuari_id;
    @Size(max = 32)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 32)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TENANT_ID")
    private int tenant_id;

    public User() {
    }

    public User(int usuari_id, String username, String password, int tenant_id) {
        this.usuari_id = usuari_id;
        this.username = username;
        this.password = password;
        this.tenant_id = tenant_id;
    }

    public int getUsuari_id() {
        return usuari_id;
    }

    public void setUsuari_id(int usuari_id) {
        this.usuari_id = usuari_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

   
    
    
    
}
