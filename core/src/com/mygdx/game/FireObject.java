package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

/**
 * То чем мы будем стрелять, лазер или ракета
 */
public class FireObject extends CollisionObject {
    double x;
    double y;
    double health;

    FireObject(double x, double y, double health, Texture img){
        super(img.getWidth(),img.getHeight());
        this.x = x;
        this.y = y;
        this.health = health;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    public void move(){

    }
}
