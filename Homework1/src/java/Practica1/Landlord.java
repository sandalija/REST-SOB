/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 *
 * @author sergi
 */
@Embeddable
public class Landlord implements Serializable{
    private static final long serialVersionUID = 1L;
    @Column(name = "NAME")
    private String nom;
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 12)
    @Column(name = "PHONE")
    private String tlf;

    public Landlord() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
    
    
}
