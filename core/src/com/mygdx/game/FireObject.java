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
    static int id = 0;
    Texture img;

    FireObject(double x, double y, double health, Texture img){
        this(x,y,health,img,1);
    }

    FireObject(double x, double y, double health, Texture img,int healthDamage){
        super(img.getWidth(),img.getHeight(),"Fire" + id++);
        this.img = img;
        this.x = x;
        this.y = y;
        this.health = health;
        this.setHealthDamage(healthDamage);
    }

    public double getImgPosX(){
        return this.getX() - img.getWidth() / 2;
    }

    public double getImgPosY(){
        return this.getY() - img.getHeight() / 2;
    }

    public Texture getImg() {
        return img;
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
        y += 15;
    }
}
