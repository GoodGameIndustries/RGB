/**
 * 
 */
package com.GGI.Components;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Emmett Deen
 *
 */
public class Button {

	private int action;//0=upgrade,1=sell
	private Texture up;
	private Texture down;
	public Texture current;
	
	private SpriteBatch button = new SpriteBatch();
	
	
	public Rectangle bounds = new Rectangle();
	public Vector2 position = new Vector2();
	
	private int w = Gdx.graphics.getWidth();
	private int h = Gdx.graphics.getHeight();
	
	public Button(Texture up, Texture down){
		this.up = up;
		this.down = down;
		this.current = this.up;
		//this.action = action;
		
		
		//setPositionAndBounds();
	}
	
	private void setPositionAndBounds() {
		switch(action){
		case 0:position.x = .15f;position.y=.4f;bounds.width=.3f;bounds.height=.3f;
			break;
		case 1:position.x = .55f;position.y=.4f;bounds.width=.3f;bounds.height=.3f;
			break;
		case 2:position.x = .35f;position.y=.3f;bounds.width=.3f;bounds.height=.3f;
		}
		
	}

	
	public void render(SpriteBatch button){
		
		button.draw(current,position.x*w,position.y*h,bounds.width*w,bounds.height*w);
		
	}
	
	public void press(){
		current = down;
		//act();
	}
	private void act() {
		switch(action){
		
		}
		
	}

	public void release(){
		current = up;
	}
	
	public boolean inXBounds(int n){
		return(n>position.x*w && n<(position.x*w)+(bounds.width*w));
	}
	
	public boolean inYBounds(int n){
		return(n>position.y*h && n<(position.y*h)+(bounds.height*w));
	}
	
}
