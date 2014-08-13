package com.GGI.Components;

import com.badlogic.gdx.Gdx;

public class Beacon {
	private int w=Gdx.graphics.getWidth();
	private int h=Gdx.graphics.getHeight();
	private float x;private float y;
	public int color;//0=red 1=blue 2=green;
	
	public Beacon(float x, float y){
		this.x=(float)x;this.y=(float)y;
	}
	public Beacon(float x, float y,int c){
		this.x=(float)x;this.y=(float)y;
		this.color = c;
	}
	
	public float getX(){return x;}
	public float getY(){return y;}
}
