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
    int round = 0;

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
        Point wave = waveX(p.getX());

        p.setX(p.getX() +  relPosition.getX() + wave.getX());
        p.setY(p.getY() +  relPosition.getY() + wave.getY());

        return p;
    }

    private Point waveX(double x){
        round ++;
        if (round > 360) round = 0;
        return new Point( 0 , Math.sin(Math.toRadians(x + round)) * 5  );
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
