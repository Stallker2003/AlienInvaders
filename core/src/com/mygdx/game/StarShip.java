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
    int destX;
    int destY;
    double acceleration;
    double speedX;
    double speedY;
    Integer formationPos;
    Texture img;

    public StarShip(int health, int x, int y, Texture img, Integer pos) {
        this.health = health;
        this.x = x;
        this.y = y;
        this.img = img;
        this.width =  img.getWidth();
        this.health = img.getHeight();

        this.formationPos = pos;
        this.acceleration = 50;
        this.destX = x;
        this.destY = y;
    }

    public StarShip(int health, int x, int y) {
        this(health, x, y, new Texture("SpaceShipSmall.png"),null);
    }

    public void move(){ move(0.1);}

    public void move(double time){
        double distX;
        double distY;

        distX = getX() - destX;
        distY = getY() - destY;

        double max_acceleration = time * acceleration;

        speedX = calculateAcceleration(distX,max_acceleration);
        speedY = calculateAcceleration(distY,max_acceleration);

        //System.out.println( "Dest [" + destX + "," + destY +  "] Pos [" + getX() + "," + getY() + "] Dist [" + distX + "," + distY + "] Speed [" + speedX + "," + speedY + "]" );
        setX(getX() + (int)speedX);
        setY(getY() + (int)speedY);
    }

    public double calculateAcceleration(double dist, double maxAcceleration){
        double minAcceleration = Math.abs(dist);
        if(dist == 0){
            return 0;
        }
        if (Math.abs(dist) > maxAcceleration){
            if(dist > 0) return -maxAcceleration;
            else return  +maxAcceleration;
        }

        if(dist > 0) return -minAcceleration;
        else return  +minAcceleration;
    }

    public Integer getFormationPos() {
        return formationPos;
    }

    public void setFormationPos(Integer formationPos) {
        this.formationPos = formationPos;
    }

    public int getDestX() {
        return destX;
    }

    public void setDestX(int destX) {
        this.destX = destX;
    }

    public int getDestY() {
        return destY;
    }

    public void setDestY(int destY) {
        this.destY = destY;
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
