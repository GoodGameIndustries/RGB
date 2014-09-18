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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Emmett Deen
 *
 */
public class LevelSelectScreen implements Screen,InputProcessor{

	private RGB g;
	private SpriteBatch pic = new SpriteBatch();
	private Button easy;
	private Button medium;
	private Button hard;
	private Texture lock;
	private Texture select;
	private BitmapFont fnt = new BitmapFont();
	private int w=Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	
	public LevelSelectScreen(RGB g){
		this.g=g;
		
		fnt.setScale(2f);
		
		lock = new Texture(Gdx.files.internal("lock.png"));
		select = new Texture(Gdx.files.internal("select.png"));
		
		easy = new Button(new Texture(Gdx.files.internal("Buttons/easyUp.png")),new Texture(Gdx.files.internal("Buttons/easyDown.png")));
		easy.bounds.x=.2f;easy.bounds.y=.2f;
		easy.position.x=.4f;easy.position.y=.55f;
		
		medium = new Button(new Texture(Gdx.files.internal("Buttons/mediumUp.png")),new Texture(Gdx.files.internal("Buttons/mediumDown.png")));
		medium.bounds.x=.2f;medium.bounds.y=.2f;
		medium.position.x=.4f;medium.position.y=.35f;
		
		hard = new Button(new Texture(Gdx.files.internal("Buttons/hardUp.png")),new Texture(Gdx.files.internal("Buttons/hardDown.png")));
		hard.bounds.x=.2f;hard.bounds.y=.2f;
		hard.position.x=.4f;hard.position.y=.15f;
		
		
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
		screenY = h-screenY;
		if(easy.inXBounds(screenX)&&easy.inYBounds(screenY)){easy.press();}
		if(medium.inXBounds(screenX)&&medium.inYBounds(screenY)&&g.stats.getHS()>=50){medium.press();}
		if(hard.inXBounds(screenX)&&hard.inYBounds(screenY)&&g.stats.getHS()>=100){hard.press();}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = h-screenY;
		
		easy.release();
		medium.release();
		hard.release();
		
		if(easy.inXBounds(screenX)&&easy.inYBounds(screenY)){g.setScreen(new OpeningScreen(g,0));}
		if(medium.inXBounds(screenX)&&medium.inYBounds(screenY)&&g.stats.getHS()>=50){g.setScreen(new OpeningScreen(g,50));}
		if(hard.inXBounds(screenX)&&hard.inYBounds(screenY)&&g.stats.getHS()>=100){g.setScreen(new OpeningScreen(g,100));}
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

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		pic.begin();
		 pic.draw(select,0,.75f*h,w,.25f*h);
		 pic.draw(easy.current, easy.position.x*w, easy.position.y*h, easy.bounds.x*w,easy.bounds.y*w);
		 pic.draw(medium.current, medium.position.x*w, medium.position.y*h, medium.bounds.x*w,medium.bounds.y*w);
		 pic.draw(hard.current, hard.position.x*w, hard.position.y*h, hard.bounds.x*w,hard.bounds.y*w);
		 
		 if(g.stats.getHS()<50){pic.draw(lock,.65f*w,(.35f*h)+(.05f*w),.1f*w,.1f*w);}
		 if(g.stats.getHS()<100){pic.draw(lock,.65f*w,(.15f*h)+(.05f*w),.1f*w,.1f*w);}
		 
		 fnt.draw(pic, "Starts your score at 50", (Gdx.graphics.getWidth()/2)-((fnt.getBounds("Starts your score at 50").width)/2),.33f*h);
		 fnt.draw(pic, "Starts your score at 100", (Gdx.graphics.getWidth()/2)-((fnt.getBounds("Starts your score at 100").width)/2),.13f*h);
		pic.end();
		
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

}
