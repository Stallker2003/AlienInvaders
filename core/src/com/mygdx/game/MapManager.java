package com.mygdx.game;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Менеджер всех кораблей.
 */
public class MapManager {
    Set<StarShip> alienShipHashMap = new HashSet<StarShip>();

    public void add(StarShip starShip){
        alienShipHashMap.add(starShip);
    }

    public Iterator<StarShip> iterator (){ return alienShipHashMap.iterator(); }

}
