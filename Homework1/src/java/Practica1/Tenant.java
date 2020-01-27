package Practica1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

// @XmlRootElement
// @NamedQuery's
@Entity
@Table(name= "TENANT")
@NamedQueries({
    @NamedQuery(name = "Tenant.findById", query = "SELECT t FROM Tenant t "
            + "WHERE t.tenantId = :tenantID")
})
@XmlRootElement
public class Tenant implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Tenant_Gen")
    @Column(name= "TENANT_ID")
    private Integer tenantId;
    @Size(max = 30)
    @Column(name = "NAME")
    private String nom;
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 12)
    @Column(name = "PHONE")
    private String tlf;
    @Column(name = "EDAT")
    private int edat;
    @Column(name= "SEXE")
    private String sexe;
    @Column(name= "MASCOTES")
    private int mascotes;
    @Column(name= "FUMADOR")
    private int fumador;
    
    public Tenant() {
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    
    public Tenant(Integer tenantId) {
        this.tenantId = tenantId;
    }
    
    public Tenant(Integer tenantId, String nom, String email, String tlf) {
        this.tenantId = tenantId;
        this.nom = nom;
        this.email = email;
        this.tlf = tlf;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
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

    public int getMascotes() {
        return mascotes;
    }

    public void setMascotes(int mascotes) {
        this.mascotes = mascotes;
    }

    public int getFumador() {
        return fumador;
    }

    public void setFumador(int fumador) {
        this.fumador = fumador;
    }
/*
    @Override
    public String toString() {
        return "Tenant{" + "tenantId=" + tenantId + ", nom=" + nom + ", "
                + "email=" + email + ", tlf=" + tlf + ", edat=" + edat + ", "
                + "sexe=" + sexe + ", mascotes=" + mascotes + ", fumador=" 
                + fumador + '}';
    }*/
    
    
    
    
    

    
    
    
    
}