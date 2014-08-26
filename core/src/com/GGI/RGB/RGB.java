package com.GGI.RGB;

import com.GGI.Screens.GameScreen;
import com.GGI.Screens.MenuScreen;
import com.GGI.Screens.OpeningScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RGB extends Game {
	SpriteBatch batch;
	Texture img;
	public ActionResolver platformInterface;
	public RGB(ActionResolver aInterface){
		platformInterface = aInterface;
		platformInterface.loginGPGS();
	}
	
	@Override
	public void create() {
		platformInterface.loginGPGS();
		setScreen(new MenuScreen(this));
		
	}

	
}
