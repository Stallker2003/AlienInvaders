package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture fly;
	int n = 1;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Background.jpg");
		fly = new Texture("SpaceShipSmall.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.2f, .3f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, -500, 0);
		batch.draw(fly, 500+n, 77);
		batch.end();

		Update();

	}

	//Это вызывается каждый кадр из рендера формы(после)
	void Update()
	{
		if(Gdx.input.getX()>Gdx.graphics.getWidth()/2)n++;
		if(Gdx.input.getX()<Gdx.graphics.getWidth()/2)n--;
	}
}
