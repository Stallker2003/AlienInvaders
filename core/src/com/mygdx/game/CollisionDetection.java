package com.mygdx.game;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Проверка на колизию
 */
public class CollisionDetection {
    static final CollisionDetection collisionDetection = new CollisionDetection();
    static HashSet<CollisionObject> objects = new HashSet<CollisionObject>();

    private CollisionDetection(){}
    public static CollisionDetection getSingleton(){
        return collisionDetection;
    }

    public void add(CollisionObject obj){
        objects.add(obj);
    }

    public void checkCollisions(){
        CollisionObject [] arr = new CollisionObject[objects.size()];
        objects.toArray(arr);

        for( CollisionObject i: arr){
           // System.out.println("Name " + i.getName());
            for(CollisionObject j:arr){
                if((!i.getName().equals(j.getName())) && i.detectProximity(j)  && i.detectCollision(j)){
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
