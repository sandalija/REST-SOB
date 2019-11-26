package Practica1;
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
public class RoomType {
    
    @Column(name = "SIMPLE")
    private int simple;
    @Column(name = "EXTERIOR")
    private int exterior;
    @Column(name = "MOBLADA")
    private int moblada; 


    public RoomType() {
    }
    public RoomType(int simple, int exterior, int moblada) {
        this.simple = simple;
        this.exterior = exterior;
        this.moblada = moblada;
       
    }

    public int getSimple() {
        return simple;
    }

    public void setSimple(int simple) {
        this.simple = simple;
    }

    public int getExterior() {
        return exterior;
    }

    public void setExterior(int exterior) {
        this.exterior = exterior;
    }

    public int getMoblada() {
        return moblada;
    }

    public void setMoblada(int moblada) {
        this.moblada = moblada;
    }
    
   

  
    
    
    
}
