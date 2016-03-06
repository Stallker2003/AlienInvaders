package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

import java.util.Iterator;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture fly;
	Texture alienImg;
	int n = 1;
	int round = 0;
	MapManager mapManager = new MapManager();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Background.jpg");
		fly = new Texture("SpaceShipSmall.png");
		alienImg = new Texture("AlienShipSmall.png");

		for(int i = 0 ; i < 10 ;i++) {
			mapManager.add(new AlienShip(50, 100 * i , 500 + (i % 3) * 50,alienImg));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.2f, .3f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, -500, 0);
		batch.draw(fly, 500+n, 77);

		Iterator<StarShip> iterator = mapManager.iterator();
		while (iterator.hasNext()){
			StarShip alien = iterator.next();
			batch.draw(alien.getImg(),alien.getX(),alien.getY());
		}

		batch.end();

		Update();

	}

	//Это вызывается каждый кадр из рендера формы(после)
	void Update()
	{
		if(Gdx.input.getX()>Gdx.graphics.getWidth()/2)n++;
		if(Gdx.input.getX()<Gdx.graphics.getWidth()/2)n--;

		AlienShip.setDeltaX(Math.sin(Math.toRadians(round)) * 100);
		AlienShip.setDeltaY(Math.cos(Math.toRadians(round)) * 50);

		round++;
		if(round > 360) round = 0;
	}
}
