package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
/**
 * Класс кораблей. В будушем и корабаль пользователя.
 */
public class StarShip {
    int health;
    int x;
    int y;
    int width;
    int height;
    Texture img;

    public StarShip(int health, int x, int y, Texture img) {
        this.health = health;
        this.x = x;
        this.y = y;
        this.img = img;
        this.width =  img.getWidth();
        this.health = img.getHeight();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }
}
