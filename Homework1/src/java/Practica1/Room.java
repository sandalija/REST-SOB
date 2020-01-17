
package Practica1;

import Practica1.Requeriments;
import Practica1.RoomType;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ROOM")
@NamedQueries({
    @NamedQuery(name= "Room.findAll", query= "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByRoomId", query = "SELECT r FROM Room r WHERE r.roomId = :roomId"),
    @NamedQuery(name = "Room.findByLocation", query = "SELECT r FROM Room r WHERE r.location = :location"),
    @NamedQuery(name = "Room.orderByASC", query = "SELECT r FROM Room r ORDER BY r.preu ASC"),
    @NamedQuery(name = "Room.orderByDESC", query = "SELECT r FROM Room r ORDER BY r.preu DESC"),
    @NamedQuery(name = "Room.findByLocationASC", query = "SELECT r FROM Room r WHERE r.location = :location ORDER BY r.preu ASC"),
    @NamedQuery(name = "Room.findByLocationDESC", query = "SELECT r FROM Room r WHERE r.location = :location ORDER BY r.preu DESC")
        
        //Named query OrderBy, una por cada sentido
})
@XmlRootElement
public class Room implements Serializable, Comparable<Room>{
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Room_Gen")
    @Column(name="ROOM_ID")
    private int roomId;
    @Column(name = "LOCATION")
    private String location; //ciutat
    @Column(name = "ADDRESS")
    private String adreca;
    @Embedded
    private RoomType roomType;
    @Column(name = "PRICE")
    private float preu;
    @Embedded
    private Requeriments requeriments;
    @Column(name="DESCRIPTION")
    private String description;    
            
    public Room() {
    }
    
    public Room(int id, String location, String adreça, int b1, 
            int b2, int b3, float preu, String r1, int min, int max, 
            int r4, int r5) {
        this.roomId = id;
        this.location = location;
        this.adreca = adreça;
        this.roomType = new RoomType(b1, b2, b3);
        this.preu = preu;
        this.requeriments = new Requeriments(r1, min, max, r4, r5);
    }
    
    public Room(String location, String adreça, int b1, 
            int b2, int b3, float preu, String r1, int min, int max, 
            int r4, int r5) {
        this.location = location;
        this.adreca = adreça;
        this.roomType = new RoomType(b1, b2, b3);
        this.preu = preu;
        this.requeriments = new Requeriments(r1, min, max, r4, r5);
    }

    @Override
    public int compareTo(Room obj){
       return ((int) (this.preu  -  obj.getPreu()));
    }
    
    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public Requeriments getRequeriments() {
        return requeriments;
    }

    public void setRequeriments(Requeriments requeriments) {
        this.requeriments = requeriments;
    }
    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
    
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdreça() {
        return adreca;
    }

    public void setAdreça(String adreça) {
        this.adreca = adreça;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Float getPreu() {
        return preu;
    }

    public void setPreu(Float preu) {
        this.preu = preu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (this.roomId != other.roomId) {
            return false;
        }
        return true;
    }  
    
}

