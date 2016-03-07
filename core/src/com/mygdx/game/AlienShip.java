package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

/**
 * Класс инопланетянских кораблей. Двигаются все разом 3/7/2016.
 */
public class AlienShip extends StarShip{
    AlienShip(int health, int x, int y, Texture img,Integer pos){
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
    public int getX() {
        return super.getX() + (int) deltaX;
    }

    @Override
    public int getY() {
        return super.getY() + (int) deltaY;
    }
}
