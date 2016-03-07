package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс упровляющий формацией
 */
public class AlienFormation {
    List<Point> list = new ArrayList<Point>();
    Point relPosition;

    AlienFormation() {
        relPosition = new Point(200,600);
        list.add(new Point(getX(0),0));
        list.add(new Point(getX(1),100));
        list.add(new Point(getX(2),0));
        list.add(new Point(getX(3),100));
        list.add(new Point(getX(4),0));
        list.add(new Point(getX(5),100));
        list.add(new Point(getX(6),0));
    }

    public Point getFormation(int position){
        Point p = new Point(list.get(position));

        p.setX(p.getX() +  relPosition.getX());
        p.setY(p.getY() +  relPosition.getY());

        return p;
    }

    private int getX(int i){
        return i * 100;
    }

    public int getMax (){
        return list.size();
    }

    public Point getPosition() {
        return relPosition;
    }

    public void setPosition(Point position) {
        this.relPosition = position;
    }
}
