package com.mygdx.game;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Менеджер всех кораблей.
 */
public class MapManager {
    Set<StarShip> alienShipHashMap = new HashSet<StarShip>();
    Set<FireObject> fireObjects = new HashSet<FireObject>();
    final static MapManager mapManager = new MapManager();

    private MapManager(){}

    public static MapManager getManeger(){return mapManager;}

    public void addShip(StarShip starShip){
        alienShipHashMap.add(starShip);
    }

    public void removeShip(StarShip starShip){
        alienShipHashMap.remove(starShip);
    }

    public Iterator<StarShip> shipIterator (){ return alienShipHashMap.iterator(); }

    public void addFire(FireObject fire){fireObjects.add(fire);}

    public void removeFire(FireObject fire){fireObjects.remove(fire);}

    public Iterator<FireObject> fireIterator (){ return fireObjects.iterator(); }
}
