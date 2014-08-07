/**
 * 
 */
package com.GGI.Screens;

import java.util.ArrayList;

import com.GGI.Components.Beacon;
import com.GGI.Components.Circle;
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
public class GameScreen implements Screen,InputProcessor{

	private RGB g;
	private SpriteBatch pic = new SpriteBatch();
	private Texture bg = new Texture(Gdx.files.internal("BG.png"));
	
	private int w = Gdx.graphics.getWidth();
	private int h = Gdx.graphics.getHeight();
	
	private int xDown;
	private int yDown;
	
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	
	private int count = 0;
	
	private Beacon red=new Beacon(0,0.719f);
	private Beacon blue=new Beacon(1f,0.719f);
	private Beacon green=new Beacon(0.5f,1f);
	private Beacon center=new Beacon(0.45f,0.5f);
	private Beacon wait4=new Beacon(0.45f,0.92f);
	private Beacon wait3=new Beacon(0.45f,0.86f);
	private Beacon wait2=new Beacon(0.45f,0.80f);
	private Beacon wait1=new Beacon(0.45f,0.74f);
	
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
		Circle circle=circles.get(0);
		circle.move();
		pic.draw(circle.getTexture(),(int)circle.x,(int)circle.y,(int)(.1*w),(int)(.1*w));
		/*pic.draw(circles.get(count+3).getTexture(),(int)(.45*w),(int)(.86*h),(int)(.1*w),(int)(.1*w));
		pic.draw(circles.get(count+2).getTexture(),(int)(.45*w),(int)(.8*h),(int)(.1*w),(int)(.1*w));
		pic.draw(circles.get(count+1).getTexture(),(int)(.45*w),(int)(.74*h),(int)(.1*w),(int)(.1*w));
		pic.draw(circles.get(count).getTexture(),(int)(.45*w),(int)(.5*h),(int)(.1*w),(int)(.1*w));*/
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
		screenY = -screenY;
		xDown = screenX;
		yDown = screenY;
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = -screenY;
		int difX = Math.abs(xDown-screenX);
		int difY = Math.abs(yDown-screenY);
		
		if(difX>difY){
			if(screenX>xDown){
				circles.get(count).setTarget(blue);
			}
			else{
				circles.get(count).setTarget(red);
			}
		}
		else{
			circles.get(count).setTarget(green);
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		screenY = -screenY;
		return true;
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
