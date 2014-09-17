/**
 * 
 */
package com.GGI.Screens;

import java.util.Timer;
import java.util.TimerTask;







import com.GGI.RGB.RGB;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Emmett Deen
 *
 */
public class GGIScreen implements Screen{
	
	private Texture opening;
	private RGB g;
	private SpriteBatch pix;
	private boolean start = true;
	private Timer timer;
	public GGIScreen(RGB g){
		this.g=g;
		opening = new Texture("Powered.png");
		pix = new SpriteBatch();
		g.stats.load();
		myTimer();
	}

	private void myTimer() {
		TimerTask timerTask = new TimerTask() {

	          @Override
	          public void run() {
	        	 
	        	  Gdx.app.postRunnable(new Runnable() {
	     	         @Override
	     	         public void run() {
	     	            // process the result, e.g. add it to an Array<Result> field of the ApplicationListener.
	     	        	 g.setScreen(new MainMenuScreen(g));
	     	         }
	     	      });
	          }
	      };
		timer = new Timer();
		timer.schedule(timerTask, 2000);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f,1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		pix.begin();
		pix.draw(opening, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		pix.end();
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		//g.ar.playAd();
		
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
