package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Этот класс управляет созданием пуль
 */
public class FireLuncher {
    static java.util.Stack<FireLuncher> fireLuncherPool;//Это для неактивных
    static ArrayList<FireLuncher> activFireLunchers = new ArrayList<FireLuncher>();
    Texture img;
    double posX;
    double posY;

    //!!Обьекты еще не удаляются, нужен таймер и функция Deactivate
    public FireLuncher()
    {
        img = new Texture("bullet.png");
        posX = MyGdxGame.starShip.getX();
        posY = MyGdxGame.starShip.getY();
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
    //Это увеличит позицию
    public  void Translate(double x, double y)
    {
        posX += x;
        posY += y;
    }

    //Инициализируем
    public static void Start()
    {
        fireLuncherPool = new Stack<FireLuncher>();

        for(double i = 0; i<1000; i++)//пока нет нормального пула
        {
            FireLuncher P = new FireLuncher();
            fireLuncherPool.push(P);
        }
    }

    public static void Update()
    {
        for (FireLuncher i: activFireLunchers) {
            i.Translate(0,15);
        }
    }

    public static void DrawBullets(SpriteBatch batch)
    {
        for (FireLuncher P: activFireLunchers) {
            batch.draw(P.img, (int)P.posX, (int)P.posY);
        }
    }

    //Это создаст новый снаряд, и поместит его в стек
    static FireLuncher Instance()
    {
        FireLuncher P = new FireLuncher();
        fireLuncherPool.push(P);
        return  P;
    }

    //Это возвратит незаенятый элемент типа баллэт
    static FireLuncher GetInnactiveBullet()
    {
        if(fireLuncherPool.empty()) {
            return Instance();
        }
        else
            return fireLuncherPool.pop();
    }

    //Это активирует один буллет из списка
    static FireLuncher ActivateBullet()
    {
        FireLuncher P = GetInnactiveBullet();
        activFireLunchers.add(P);
        return P;
    }

    public static FireLuncher shot()
    {
            FireLuncher P = ActivateBullet();
            P.SetPos(MyGdxGame.starShip.getX()+32, MyGdxGame.starShip.getY()+156);//тут добавляем для того чтобы выровнять по кораблю
            return P;
    }
}

