/**
 * 
 */
package com.GGI.Screens;

import com.GGI.RGB.RGB;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * @author Emmett Deen
 *
 */
public class OpeningScreen implements Screen{

	private RGB g;
	private int count = 0;
	private int s;
	
	public OpeningScreen(RGB g,int s){
		this.g=g;
		this.s=s;
	}
	
	@Override
	public void render(float delta) {
		
		switch(count){
		case 0:Gdx.gl.glClearColor(1f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		break;
		
		case 1:Gdx.gl.glClearColor(0f, 1f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		break;
		
		case 2:Gdx.gl.glClearColor(0f, 0f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		break;
		
		case 3:Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		g.setScreen(new GameScreen(g,s));
		break;
		}
		
		
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		count++;
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
