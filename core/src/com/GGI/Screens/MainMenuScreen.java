/**
 * 
 */
package com.GGI.Screens;

import com.GGI.Components.Button;
import com.GGI.RGB.RGB;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * @author Emmett Deen
 *
 */
public class MainMenuScreen implements Screen, InputProcessor{
	private RGB game;
	private ShapeRenderer shape = new ShapeRenderer();
	private SpriteBatch pic = new SpriteBatch();
	private int w = Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	private float r=1f,g=0,b=0f;
	private Texture logo;
	private Button play;
	private Button help;
	private int step = 0;
	private BitmapFont fnt = new BitmapFont();
	
	public MainMenuScreen(RGB game){
		this.game=game;
		fnt.setScale(2f);
		logo = new Texture(Gdx.files.internal("Title.png"));
		
		play = new Button(new Texture(Gdx.files.internal("Buttons/playUp.png")),new Texture(Gdx.files.internal("Buttons/playDown.png")));
		play.bounds.x=.2f;play.bounds.y=.2f;
		play.position.x=.4f;play.position.y=.35f;
		
		help = new Button(new Texture(Gdx.files.internal("Buttons/helpUp.png")),new Texture(Gdx.files.internal("Buttons/helpDown.png")));
		help.bounds.x=.2f;help.bounds.y=.2f;
		help.position.x=.4f;help.position.y=.15f;
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeType.Line);
		 shape.setColor(r, g, b, 1);
		 
		 shape.circle(w/2, (3*h)/4, w/3);
		 shape.circle(w/2, (3*h)/4, (w/3)-1);
		 shape.circle(w/2, (3*h)/4, (w/3)+1);
		 shape.circle(w/2, (3*h)/4, (w/3)-2);
		 shape.circle(w/2, (3*h)/4, (w/3)+2);
		 shape.circle(w/2, (3*h)/4, (w/3)-3);
		 shape.circle(w/2, (3*h)/4, (w/3)+3);
		 shape.end();
		 
		 pic.begin();
		 pic.draw(help.current, help.position.x*w, help.position.y*h, help.bounds.x*w,help.bounds.y*w);
		 pic.draw(play.current, play.position.x*w, play.position.y*h, play.bounds.x*w,play.bounds.y*w);
		 
		 pic.draw(logo,w/6,((3*h)/4) - (w/3),(2*w)/3,(2*w)/3);
		 fnt.draw(pic, "Your highscore is: "+game.stats.getHS(), (Gdx.graphics.getWidth()/2)-((fnt.getBounds("Your highscore is: "+game.stats.getHS()).width)/2),Gdx.graphics.getHeight() - ((9*Gdx.graphics.getHeight())/24));
		 fnt.draw(pic, "You have played: "+game.stats.getGP()+" game(s)", (Gdx.graphics.getWidth()/2)-((fnt.getBounds("You have played: "+game.stats.getGP()+" game(s)").width)/2),Gdx.graphics.getHeight() - (Gdx.graphics.getHeight()/3));
		 pic.end();
		 
		 
		alterColor();
	}

	private void alterColor() {
		if(step<=100){
			g+=.01f;
		}
		else if(step<200){
			r-=.01f;
		}
		else if(step<300){
			b+=.01f;
		}
		else if(step<400){
			g-=.01f;
		}
		else if(step<500){
			r+=.01f;
		}
		else if(step<600){
			b-=.01f;
		}
		else{step=0;}
		
		
		step++;
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
		screenY = h-screenY;
		if(play.inXBounds(screenX)&&play.inYBounds(screenY)){play.press();}
		if(help.inXBounds(screenX)&&help.inYBounds(screenY)){help.press();}
		System.out.println(screenX + "," + screenY);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = h-screenY;
		
		play.release();
		help.release();
		
		if(play.inXBounds(screenX)&&play.inYBounds(screenY)){game.setScreen(new LevelSelectScreen(game));}
		if(help.inXBounds(screenX)&&help.inYBounds(screenY)){game.setScreen(new InstructionScreen(game));}
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
