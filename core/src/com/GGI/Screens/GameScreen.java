/**
 * 
 */
package com.GGI.Screens;

import java.util.ArrayList;

import com.GGI.Components.Circle;
import com.GGI.RGB.RGB;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Emmett Deen
 *
 */
public class GameScreen implements Screen{

	private RGB g;
	private SpriteBatch pic = new SpriteBatch();
	private Texture bg = new Texture(Gdx.files.internal("BG.png"));
	
	private int w = Gdx.graphics.getWidth();
	private int h = Gdx.graphics.getHeight();
	
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	
	private int count = 0;
	
	public GameScreen(RGB g){
		this.g=g;
		
		for(int i = 0; i <100; i++){
			circles.add(new Circle());
		}
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		pic.begin();
		pic.draw(bg,0,0,w,h);
		pic.draw(circles.get(count).getTexture(),(int)(.45*w),(int)(.5*h),(int)(.1*w),(int)(.1*w));
		pic.end();
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
