package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;


import java.util.Iterator;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture alienImg;
	int round = 0;
	MapManager mapManager = MapManager.getManeger();
	static long lastShot = 0;//для таймера
	AlienFormation alienFormation = new AlienFormation();

	static StarShip starShip;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Background.jpg");

		alienImg = new Texture("AlienShipSmall.png");

		starShip = new StarShip(10, 0, 0);
		mapManager.addShip(starShip);

		FireLuncher.Start();//!!это мне не нравиться тут

		for(int i = 0 ; i < alienFormation.getMax() ;i++) {
			Point point = alienFormation.getFormation(i);
			mapManager.addShip(new AlienShip(50, (int)point.getX() ,(int)point.getY() ,alienImg,i));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.2f, .3f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, -500, 0);

		Iterator<StarShip> iterator = mapManager.shipIterator();

		while (iterator.hasNext()){
			StarShip alien = iterator.next();
			batch.draw(alien.getImg(),(int)alien.getX(),(int)alien.getY());
		}

		FireLuncher.DrawBullets(batch);//!!это мне не нравиться тут

		batch.end();

		Update();
		FireLuncher.Update();//!!это мне не нравиться тут + как насчет разной производительности ПК? Вопрос -пстоянны ли ФПС

	}

	void Shoot()
	{
		long T = TimeUtils.millis();

		if((Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isButtonPressed(Input.Buttons.LEFT) ) && (T  > lastShot + 100))
		{
			FireLuncher.shot();
			lastShot=T;
		}
	}

	//Это вызывается каждый кадр из рендера формы(после)
	void Update()
	{
		starShip.setX(Gdx.input.getX());

		Shoot();

		Iterator<StarShip> iterator = mapManager.shipIterator();
		while (iterator.hasNext()){
			StarShip alien = iterator.next();
			Integer pos = alien.getFormationPos();
			if(pos == null) continue;
			Point dest = alienFormation.getFormation(pos);
			if(dest == null) continue;
			alien.setDestX((int)dest.getX());
			alien.setDestY((int)dest.getY());
			alien.move();
		}

		Point relativePos = new Point(Math.sin(Math.toRadians(round)) * 100 + 200,Math.cos(Math.toRadians(round)) * 50 + 500);
		alienFormation.setPosition(relativePos);

		round++;
		if(round > 360) round = 0;
	}
}
