/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Comparator;

/**
 *
 * @author sergi
 */

public class RoomComparator implements Comparator<Room> {
    @Override
    public int compare (Room a, Room b) {
        return a.compareTo(b);
    }
    
}
