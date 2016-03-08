package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Этот класс управляет созданием пуль
 */
public class FireLuncher {
    static java.util.Stack<FireLuncher> fireLuncherPool;//Это для неактивных
    static ArrayList<FireLuncher> activFireLunchers = new ArrayList<FireLuncher>();
    static MapManager mapManager = MapManager.getManeger();
    double posX;
    double posY;
    static FireLuncher fireLuncher = new FireLuncher();
    StarShip playerShip;
    Texture img;

    //!!Обьекты еще не удаляются, нужен таймер и функция Deactivate
    private FireLuncher() {}

    public static FireLuncher singleton(){
        return fireLuncher;
    }

    public void setPlayer(StarShip playerShip){
        this.playerShip = playerShip;
        updatePlayerPosition();
    }

    public void updatePlayerPosition(){
        posX = playerShip.getX();
        posY = playerShip.getY();
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public Texture GetImage()
    {
        return img;
    }

    public void SetPos(double x, double y)
    {
        posX = x;
        posY = y;
    }
    public double GetPosX()
    {
        return posX;
    }
    public double GetPosY()
    {
        return posY;
    }

    public static void Update()
    {
        Iterator<FireObject> i = mapManager.fireIterator();

        while (i.hasNext()){
            FireObject fire = i.next();
            fire.move();
        }
    }

    public static void DrawBullets(SpriteBatch batch)
    {
        Iterator<FireObject> i = mapManager.fireIterator();

        while (i.hasNext()){
            FireObject fire = i.next();
            if (fire.isAlive()) batch.draw(fire.getImg(), (int)fire.getImgPosX(), (int)fire.getImgPosY());
        }
    }

    public FireObject shot()
    {
        updatePlayerPosition();
        FireObject P = new FireObject(posX,posY + playerShip.getImg().getHeight(),1,img,5);
        mapManager.addFire(P);
        return P;
    }
}

