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
@Table(name="USUARIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM USER u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM USER u WHERE u.password = :password"),
    @NamedQuery(name = "User.login", query = "SELECT u FROM USER u WHERE u.username = :username AND u.password = :password")
})
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "USUARI_ID")
    private Integer tenantId;
    @Size(max = 32)
    @Column(name = "USERNAME")
    private String USERNAME;
    @Size(max = 32)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TENANT_ID")
    private String tenant_id;
    
}
