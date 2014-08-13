package com.GGI.Components;

import com.badlogic.gdx.Gdx;

public class Beacon {
	private int w=Gdx.graphics.getWidth();
	private int h=Gdx.graphics.getHeight();
	private float x;private float y;
	
	public Beacon(float x, float y){
		this.x=(float)x;this.y=(float)y;
	}
	
	public float getX(){return x;}
	public float getY(){return y;}
}
