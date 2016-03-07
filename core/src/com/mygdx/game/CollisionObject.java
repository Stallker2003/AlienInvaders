package com.mygdx.game;

/**
 * Заготовка под обьекты которые могут сталкиваться
 */
public abstract class CollisionObject {
    double width;
    double height;
    double radius;
    boolean isAlive;

    public CollisionObject(double width, double height) {
        this.width = width;
        this.height = height;

        isAlive = true;

        width = width / 2;
        height = height / 2;

        radius = Math.sqrt((width*width) + (height*height));
    }

    abstract public double getX();

    abstract public double getY();

    abstract public int getHealth();

    abstract public int setHealth(int height);

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    public void onCollision(double healthImpact) {
        if(this.getHealth() > healthImpact){
            this.setHealth(this.getHealth() - (int)healthImpact);
        } else {
            this.setIsAlive(false);
        }
    }

    public double getCollisionDamage() {
        return this.getHealth();
    }

    
    public double getProximityRadius() {
        return radius;
    }

    public boolean detectProximity(CollisionObject obj) {
        double dist = Math.abs((obj.getX() - this.getX()) / (obj.getY() - this.getY()));
        return dist < obj.getProximityRadius() + this.getProximityRadius();
    }
    
    public boolean detectCollision(CollisionObject obj) {
        Point [] arr1 = this.getCollisionModel();
        Point [] arr2 = obj.getCollisionModel();
        System.out.println("Detecting Collision");
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
