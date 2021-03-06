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
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Emmett Deen
 *
 */
public class GameScreen implements Screen,InputProcessor{

	private RGB g;
	private SpriteBatch pic = new SpriteBatch();
	private Texture bg = new Texture(Gdx.files.internal("BG.png"));
	private Texture light = new Texture(Gdx.files.internal("light.png"));
	public int[] lights = new int[]{0,0,0};
	
	private int w = Gdx.graphics.getWidth();
	private int h = Gdx.graphics.getHeight();
	
	private int xDown;
	private int yDown;
	private Sound whoosh = Gdx.audio.newSound(Gdx.files.internal("whoosh.wav"));
	public ArrayList<Circle> circles = new ArrayList<Circle>();
	
	
	
	private int count = 0;
	
	public int score = 0;
	
	public Beacon red=new Beacon(0f,0.281f,0);
	public Beacon blue=new Beacon(1f,0.281f,1);
	public Beacon green=new Beacon(0.45f,-.2f,2);
	private Beacon center=new Beacon(0.45f,0.5f);
	private Beacon wait4=new Beacon(0.45f,0.92f);
	private Beacon wait3=new Beacon(0.45f,0.86f);
	private Beacon wait2=new Beacon(0.45f,0.80f);
	private Beacon wait1=new Beacon(0.45f,0.74f);
	private int spawnRate = 100;
	private BitmapFont fnt = new BitmapFont();
	
	
	public boolean gameOver = false;
	
	public GameScreen(RGB g,int s){
		this.g=g;
		score =s;
		spawnRate=spawnRate-score;
		if(spawnRate<25){spawnRate=25;}
		fnt.setScale(2f);
		
			/*Circle circle = new Circle(this);
			circles.add(circle);
			circle.setCount(1);*/
			Circle circle2 = new Circle(this);
			circles.add(circle2);
			
		
		
		//circles.get(0).setLocation(wait1);
		circles.get(0).setLocation(wait4);
	
	}
	
	@Override
	public void render(float delta) {
		if(circles.size()>1){
			if(Math.abs(circles.get(0).x-circles.get(1).x)<.05f && Math.abs(circles.get(0).y-circles.get(1).y)<.05f){gameOver = true;}
		}
		if(gameOver){
				g.setScreen(new GameOverScreen(g,score));
		}
		
		Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//System.out.println(count);
		count++;if(count == spawnRate ){System.out.println("spawn");circles.add(new Circle(this));count=0;
		if(spawnRate>25){spawnRate--;}
		}
		
		pic.begin();
		pic.draw(bg,0,0,w,h);
		fnt.draw(pic, "Score: "+score, w-(fnt.getBounds("Score: "+score).width)-10, h-(fnt.getBounds("Score: "+score).height)-5);
		for(int i = 0; i < circles.size();i++){
		Circle circle=circles.get(i);
		circle.move();
		pic.draw(circle.getTexture(),(int)(circle.x*w),(int)(circle.y*h),(int)(.1*w),(int)(.1*w));
		}
		if(lights[0]>1){pic.draw(light,-(w/2),0,w,(int) (.75*h));lights[0]--;}
		if(lights[1]>1){pic.draw(light,0,-(h/2),w,h);lights[1]--;}
		if(lights[2]>1){pic.draw(light,w/2,0,w,(int) (.75*h));lights[2]--;}
		
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
		 Gdx.input.setInputProcessor(this);
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		System.out.println("Paused");
		Gdx.input.setInputProcessor(null);
		
	}

	@Override
	public void resume() {
		
		Gdx.input.setInputProcessor(this);
		
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
		screenY = h-screenY;
		xDown = screenX;
		yDown = screenY;
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = h-screenY; 
		int difX = Math.abs(xDown-screenX);
		int difY = Math.abs(yDown-screenY);
		
		System.out.println(screenX);
		System.out.println(screenY);
		if(screenX<w*.8&&screenY>h*.9){System.out.println("pause");pause();g.setScreen(new PauseScreen(g,this));}
		else{
		if(circles.size()>0){
		if(difX>difY){
			if(screenX>xDown){
				circles.get(0).setTarget(blue);
				
			}
			else{
				circles.get(0).setTarget(red);
			}
		}
		else{
			circles.get(0).setTarget(green);
		}
		circles.get(0).setCount(0);
		circles.get(0).setSpeed(0.1f);
		}
		}
		whoosh.play();
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
