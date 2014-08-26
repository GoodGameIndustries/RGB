/**
 * 
 */
package com.GGI.Screens;

import com.GGI.Components.Button;
import com.GGI.RGB.RGB;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Emmett Deen
 *
 */
public class MenuScreen implements Screen, InputProcessor {

	private RGB g;
	private Button play;
	private Button leaderboards;
	private Texture bg;
	private SpriteBatch menu = new SpriteBatch();
	
	private int w = Gdx.graphics.getWidth();
	private int h = Gdx.graphics.getHeight();
	
	public MenuScreen(RGB g){
	this.g = g;
	
	play = new Button(new Texture(Gdx.files.internal("Menu/PlayUp.png")),new Texture(Gdx.files.internal("Menu/PlayDown.png")),0);
	leaderboards = new Button(new Texture(Gdx.files.internal("Menu/LeaderBoardsUp.png")),new Texture(Gdx.files.internal("Menu/LeaderBoardsDown.png")),1);
	bg = new Texture(Gdx.files.internal("Menu/Logo.png"));
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		menu.begin();
		menu.draw(bg,0,.6f*h,w,.4f*w);
		menu.end();
		
		play.render();
		leaderboards.render();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
		
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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		
		//System.out.println(play.inXBounds(screenX));
		//System.out.println(play.inYBounds(screenY));
		if(play.inXBounds(screenX) && play.inYBounds(screenY)){
			play.press();
			//g.setScreen(new GameScreen());
		}
		if(leaderboards.inXBounds(screenX) && leaderboards.inYBounds(screenY)){
			leaderboards.press();
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = h-screenY;
		play.release();
		leaderboards.release();
		if(play.inXBounds(screenX) && play.inYBounds(screenY)){
			g.setScreen(new GameScreen(g));
		}
		if(leaderboards.inXBounds(screenX) && leaderboards.inYBounds(screenY)){
			if (g.platformInterface.getSignedInGPGS()) g.platformInterface.getLeaderboardGPGS();
			else g.platformInterface.loginGPGS();
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
