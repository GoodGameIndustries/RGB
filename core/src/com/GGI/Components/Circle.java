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
	public float x=0.45f;
	public float y=0.92f;
	private Beacon red=new Beacon(0f,0.281f);
	private Beacon blue=new Beacon(1f,0.281f);
	private Beacon green=new Beacon(0.5f,1f);
	private Beacon center=new Beacon(0.45f,0.5f);
	private Beacon wait4=new Beacon(0.45f,0.92f);
	private Beacon wait3=new Beacon(0.45f,0.86f);
	private Beacon wait2=new Beacon(0.45f,0.80f);
	private Beacon wait1=new Beacon(0.45f,0.74f);
	private Beacon target;
	private int count=5;
	
	public Circle(){
		t = randomColor();
	}
	
	public void setTarget(Beacon beacon){
		target=beacon;
		//x=target.getX();y=target.getY();
	}
	
	private float calculateDistance(Beacon beacon){
		return (float) Math.pow(Math.pow(beacon.getX()-x,2)+Math.pow(beacon.getY()-y,2),0.5);
	}
	
	private void targetMove(Beacon beacon){
		double r=calculateDistance(beacon);
		System.out.println(r);
		x=(float) (x+Math.abs(beacon.getX()-x)/r);
		y=(float) (y+Math.abs(beacon.getY()-y)/r);
		if(r<50){return;}
		//moveBound();
	}
	
	private void moveBound(){
		x=(x>1f)?1f:x;
		y=(y>1f)?1f:y;
	}
	
	public void move(){
		switch(count){
<<<<<<< HEAD
			case 5:setTarget(wait4);count--;
			case 4:setTarget(wait3);count--;
			case 3:setTarget(wait2);count--;
			case 2:setTarget(wait1);count--;
			case 1:y=y-1f;
=======
			case 5:setTarget(wait4);targetMove(target);count--;
			case 4:setTarget(wait3);targetMove(target);count--;
			case 3:setTarget(wait2);targetMove(target);count--;
			case 2:setTarget(wait1);targetMove(target);count--;
			case 1://y=y-0.1f;
				setTarget(red);targetMove(target);
>>>>>>> origin/master
		}
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
