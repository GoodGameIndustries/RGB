/**
 * 
 */
package com.GGI.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Emmett Deen
 *
 */
public class Circle {

	private Texture t;
	public Circle(){
		t = randomColor();
	}
	private Texture randomColor() {
		switch((int)Math.random()*3){
		case 0: return new Texture(Gdx.files.internal("RedC.png"));
		case 1: return new Texture(Gdx.files.internal("BlueC.png"));
		case 2: return new Texture(Gdx.files.internal("GreenC.png"));
		}
		return null;
		
	}
	
	public Texture getTexture(){return t;}
	
}
