package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
/**
 * Класс кораблей. В будушем и корабаль пользователя.
 */
public class StarShip extends CollisionObject{
    double health;
    double x;
    double y;
    double width;
    double height;
    double destX;
    double destY;
    double acceleration;
    double speedX;
    double speedY;
    Integer formationPos;
    Texture img;

    public StarShip(double health, double x, double y, Texture img, Integer pos) {
        super(img.getWidth(),img.getHeight());
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

    public StarShip(double health, double x, double y) {
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
        setX(getX() + speedX);
        setY(getY() + speedY);
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

    public double getDestX() {
        return destX;
    }

    public void setDestX(double destX) {
        this.destX = destX;
    }

    public double getDestY() {
        return destY;
    }

    public void setDestY(double destY) {
        this.destY = destY;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getX() {
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }
}
