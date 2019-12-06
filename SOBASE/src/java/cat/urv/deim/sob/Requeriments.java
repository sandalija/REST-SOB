
package cat.urv.deim.sob;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
public class Requeriments implements Serializable{
    private static final long serialVersionUID = 1L;
    @Column (name = "SEXE")
    private String sexe;
    @Column (name = "MIN_EDAT")
    private Integer minEdat;
    @Column (name = "MAX_EDAT")
    private Integer maxEdat;
    @Column(name = "FUMADOR")
    private int fumador;
    @Column(name = "MASCOTES")
    private int mascotes;

    public Requeriments() {
    }

    public Requeriments(String sexe, Integer minEdat, Integer maxEdat, int
            fumador, int mascotes) {
        this.sexe = sexe;
        this.minEdat = minEdat;
        this.maxEdat = maxEdat;
        this.fumador = fumador;
        this.mascotes = mascotes;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Integer getMinEdat() {
        return minEdat;
    }

    public void setMinEdat(Integer minEdat) {
        this.minEdat = minEdat;
    }

    public Integer getMaxEdat() {
        return maxEdat;
    }

    public void setMaxEdat(Integer maxEdat) {
        this.maxEdat = maxEdat;
    }

    public int getFumador() {
        return fumador;
    }

    public void setFumador(int fumador) {
        this.fumador = fumador;
    }

    public int getMascotes() {
        return mascotes;
    }

    public void setMascotes(int mascotes) {
        this.mascotes = mascotes;
    }

    
    
}
