package com.mygdx.game;

/**
 * Заготовка под обьекты которые могут сталкиваться
 */
public abstract class CollisionObject {
    private double width;
    private double height;
    private double radius;
    private boolean isAlive;
    private int healthDamage;
    private String name;

    public CollisionObject(double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
        isAlive = true;

        width = width / 2;
        height = height / 2;

        radius = Math.sqrt((width*width) + (height*height));
    }

    abstract public double getX();

    abstract public double getY();

    abstract public double getHealth();

    abstract public void setHealth(double health);

    public void setHealthDamage(int healthDamage) {
        this.healthDamage = healthDamage;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    public void onCollision(double healthImpact) {
        if(this.getHealth() > healthImpact){
            this.setHealth(this.getHealth() - healthImpact);
        } else {
            this.setIsAlive(false);
        }
    }

    public double getCollisionDamage() {
        if(healthDamage == 0 )return this.getHealth();
        return healthDamage;
    }
    
    public double getProximityRadius() {
        return radius;
    }

    public boolean detectProximity(CollisionObject obj) {

        double divX = obj.getX() - this.getX();
        double divY = obj.getY() - this.getY();
        double dist = Math.sqrt(divX * divX + divY * divY);
        return ( dist < obj.getProximityRadius() + this.getProximityRadius() );
    }
    
    public boolean detectCollision(CollisionObject obj) {
        Point [] arr1 = this.getCollisionModel();
        Point [] arr2 = obj.getCollisionModel();
        return true;
    }
    
    public Point[] getCollisionModel() {
        double half_width = width / 2;
        double half_height = height / 2;
        return new Point[]{
                new Point(-half_width,-half_height),
                new Point(-half_width,half_height),
                new Point(half_width,-half_height),
                new Point(half_width,half_height)};
    }

    public boolean checkLineIntersection(Point arr[]){
        Point LineA1 = arr[0];
        Point LineA2 = arr[1];
        Point LineB1 = arr[2];
        Point LineB2 = arr[3];
        
        double denom = ((LineB2.getY() - LineB1.getY()) * (LineA2.getX() - LineA1.getX())) - ((LineB2.getX() - LineB1.getX()) * (LineA2.getY() - LineA1.getY()));
        return denom != 0;
    }
}
