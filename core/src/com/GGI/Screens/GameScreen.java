/**
 * 
 */
package com.GGI.Screens;

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
	
	public GameScreen(RGB g){
		this.g=g;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		pic.begin();
		pic.draw(bg,0,0,w,h);
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
