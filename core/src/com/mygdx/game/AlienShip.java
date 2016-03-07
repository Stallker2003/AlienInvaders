package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Класс инопланетянских кораблей. Двигаются все разом 3/7/2016.
 */
public class AlienShip extends StarShip{
    AlienShip(double health, double x, double y, Texture img,Integer pos){
        super(health,x,y,img,pos);
    }

    private static double deltaX = 0;
    private static double deltaY = 0;

    public static double getDeltaX() {
        return deltaX;
    }

    public static void setDeltaX(double deltaX) {
        AlienShip.deltaX = deltaX;
    }

    public static double getDeltaY() {
        return deltaY;
    }

    public static void setDeltaY(double deltaY) {
        AlienShip.deltaY = deltaY;
    }

    @Override
    public double getX() {
        return super.getX() + deltaX;
    }

    @Override
    public double getY() {
        return super.getY() + deltaY;
    }
}
