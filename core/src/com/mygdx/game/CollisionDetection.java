package com.mygdx.game;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Проверка на колизию
 */
public class CollisionDetection {
    HashSet<CollisionObject> objects = new HashSet<CollisionObject>();

    public void add(CollisionObject obj){
        objects.add(obj);
    }

    public void checkCollisions(){
        CollisionObject [] arr = (CollisionObject[]) objects.toArray();

        for( CollisionObject i: arr){
            for(CollisionObject j:arr){
                if(i.detectProximity(j) && i.detectCollision(j)){
                    double damage_i = i.getCollisionDamage();
                    double damage_j = j.getCollisionDamage();
                    i.onCollision(damage_j);
                    j.onCollision(damage_i);
                    if (! i.isAlive()) remove(i);
                    if (! j.isAlive()) remove(j);
                }
            }
        }
    }

    public void remove(CollisionObject obj){
        objects.remove(obj);
    }
}
