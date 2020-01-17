/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1.auth;

/**
 *
 * @author sergi
 */
public class Users {
    
    private String name;
    private String sexe;
    private int edat;

    public Users(String name, String sexe, int edat) {
        this.name = name;
        this.sexe = sexe;
        this.edat = edat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
    
    
}
