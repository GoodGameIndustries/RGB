/**
 * 
 */
package com.GGI.Components;

import com.GGI.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Emmett Deen
 *
 */
public class Circle {

	private Texture t;
	public float x=0.45f;
	public float y=1f;
	private Beacon red=new Beacon(0f,0.281f);
	private Beacon blue=new Beacon(1f,0.281f);
	private Beacon green=new Beacon(0.45f,-.2f);
	private Beacon center=new Beacon(0.45f,0.3f);
	private Beacon wait4=new Beacon(0.45f,0.92f);
	private Beacon wait3=new Beacon(0.45f,0.86f);
	private Beacon wait2=new Beacon(0.45f,0.80f);
	private Beacon wait1=new Beacon(0.45f,0.74f);
	private Beacon target=wait4;
	private int count=4;
	private float speed = 0.005f;
	private GameScreen gs;
	private float multiplier = 1f;
	private boolean isThis = false;
	private int cNum;
	public Circle(GameScreen gameScreen){
		t = randomColor();
		this.gs = gameScreen;
	}
	
	public void setTarget(Beacon beacon){
		target=beacon;
		//x=target.getX();y=target.getY();
	}
	
	public void setLocation(Beacon beacon){
		x=beacon.getX();y=beacon.getY();
	}
	
	private void setPosition(float x, float y){this.x=x;this.y=y;}
	
	private float calculateDistance(Beacon beacon){
		return (float) Math.pow(Math.pow(beacon.getX()-x,2)+Math.pow(beacon.getY()-y,2),0.5);
	}
	
	/*
	private void targetMove(){
		double r=calculateDistance(target);
		System.out.println(r);
		if(r>50f){
			x=(float) (x+(target.getX()-x)/r);
			y=(float) (y+(target.getY()-y)/r);
		}
		else{x=target.getX();y=target.getY(); count--;}
		//moveBound();
	}
	*/
	
	private void targetMove(){
		float xDif = Math.abs(x-target.getX());
		float yDif = Math.abs(y-target.getY());
		if(xDif<.1f&&yDif<.1f){
			if(count>1){count--;}
			else if(target!=center){
				//gs.circles.add(new Circle(gs));
				if(target.color!=cNum){gs.gameOver = true;}
				gs.circles.remove(this);
			}
			
		}
		
		if(x>target.getX()){x-=(speed*xDif)*3 ;}
		if(x<target.getX()){x+=(speed*xDif)*3 ;}
		
		
		if(y>target.getY()){y-=(speed*yDif)*3 ;}
		if(y<target.getY()){y+=(speed*yDif)*3 ;}
		
		
		
	}
	
	private void moveBound(){
		x=(x>1f)?1f:x;
		y=(y>1f)?1f:y;
	}
	
	public void setSpeed(float s){
		speed = s*multiplier ;
	}
	
	public void move(){
		//System.out.println(count);
		if(count>5){count--;}
		switch(count){
		
			case 5:setTarget(wait4);targetMove();
			case 4:setTarget(wait3);targetMove();
			case 3:setTarget(wait2);targetMove();
			case 2:setTarget(wait1);targetMove();
			case 1://y=y-0.1f;
				setTarget(center);
				targetMove();
			case 0: targetMove();
			}
			
	}
	
	private Texture randomColor() {
		cNum = (int)(Math.random()*3);
		switch(cNum){
		case 0: return new Texture(Gdx.files.internal("RedC.png"));
		case 1: return new Texture(Gdx.files.internal("BlueC.png"));
		case 2: return new Texture(Gdx.files.internal("GreenC.png"));
		}
		return null;
		
	}
	
	public Texture getTexture(){return t;}

	public void setCount(int i) {
		count = i;
		
	}
	
}
