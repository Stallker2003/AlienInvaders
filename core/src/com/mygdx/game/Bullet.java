package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;
//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Дима on 07.03.2016.
 */
public class Bullet {
    static java.util.Stack<Bullet> bulletPool;//Это для неактивных
    static ArrayList<Bullet> activBullets;
    Texture img;
    int posX;
    int posY;
//!!Обьекты еще не удаляются, нужен таймер и функция Deactivate
    public Bullet()
    {
        img = new Texture("bullet.png");
        posX = MyGdxGame.starShip.getX();
        posY = MyGdxGame.starShip.getY();
    }

    public Texture GetImage()
    {
        return img;
    }

    public void SetPos(int x, int y)
    {
        posX = x;
        posY = y;
    }
    public int GetPosX()
    {
        return posX;
    }
    public int GetPosY()
    {
        return posY;
    }
    //Это увеличит позицию
    public  void Translate(int x, int y)
    {
        posX += x;
        posY += y;
    }

    //Инициализируем
    public static void Start()
    {
        bulletPool = new Stack<Bullet>();
        activBullets = new ArrayList<Bullet>();
    }

    public static void Update()
    {
        for (int i = 0;i<activBullets.size();i++)
        {
            activBullets.get(i).Translate(0,1);
        }

    }

    public static void DrawBullets(SpriteBatch batch)
    {
        for (int i = 0;i<activBullets.size();i++)
        {
            Bullet P = activBullets.get(i);
            batch.draw(P.img, P.posX, P.posY);
        }
    }

    //Это создаст новый снаряд, и поместит его в стек
    static Bullet Instance()
    {
        Bullet P = new Bullet();
        bulletPool.push(P);
        return  P;
    }

    //Это возвратит незаенятый элемент типа баллэт
    static Bullet GetInnactiveBullet()
    {
        if(bulletPool.empty()) {
            return Instance();
        }
        else
            return bulletPool.pop();
    }

    //Это активирует один буллет из списка
    static Bullet ActivateBullet()
    {
        Bullet P = GetInnactiveBullet();
        activBullets.add(P);
        return P;
    }

    public static Bullet shot()
    {
        Bullet P = ActivateBullet();
        P.SetPos(MyGdxGame.starShip.getX(), MyGdxGame.starShip.getY());
        return  P;
    }
}

