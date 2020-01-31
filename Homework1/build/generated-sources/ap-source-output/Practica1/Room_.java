package Practica1;

import Practica1.Requeriments;
import Practica1.RoomType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-31T11:53:22")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, Requeriments> requeriments;
    public static volatile SingularAttribute<Room, String> img;
    public static volatile SingularAttribute<Room, Float> preu;
    public static volatile SingularAttribute<Room, String> adreca;
    public static volatile SingularAttribute<Room, String> description;
    public static volatile SingularAttribute<Room, String> location;
    public static volatile SingularAttribute<Room, Integer> roomId;
    public static volatile SingularAttribute<Room, RoomType> roomType;

}