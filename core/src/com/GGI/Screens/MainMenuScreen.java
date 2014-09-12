/**
 * 
 */
package com.GGI.Screens;

import com.GGI.Components.Button;
import com.GGI.RGB.RGB;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * @author Emmett Deen
 *
 */
public class MainMenuScreen implements Screen{
	private RGB game;
	private ShapeRenderer shape = new ShapeRenderer();
	private SpriteBatch pic = new SpriteBatch();
	private int w = Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	private float r=.01f,g=0,b=0;
	private Texture logo;
	private Button play;
	private Button help;
	public MainMenuScreen(RGB game){
		this.game=game;
		logo = new Texture(Gdx.files.internal("Title.png"));
		
		play = new Button(new Texture(Gdx.files.internal("Buttons/playUp.png")),new Texture(Gdx.files.internal("Buttons/playDown.png")));
		play.bounds.x=(float)(w/1000);play.bounds.y=(float)(w/1000);
		play.position.x=.1f;play.position.y=.1f;
		
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
		 pic.draw(logo,w/6,((3*h)/4) - (w/3),(2*w)/3,(2*w)/3);
		 play.render(pic);
		 pic.end();
		 
		 
		alterColor();
	}

	private void alterColor() {
		if(r>0){
			r+=.01f;
		}
		if(r>1.5f){
			r=0;
			g+=.01f;
		}
		if(g>0){
			g+=.01f;
		}
		if(g>1.5f){
			g=0;
			b+=.01f;
		}
		if(b>0){
			b+=.01f;
		}
		if(b>1.5f){
			b=0;
			r+=.01f;
		}
		
		
		
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
