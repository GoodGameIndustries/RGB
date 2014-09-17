package com.GGI.RGB;

import com.GGI.Components.Stats;
import com.GGI.Screens.GGIScreen;
import com.GGI.Screens.GameScreen;
import com.GGI.Screens.MainMenuScreen;
import com.GGI.Screens.OpeningScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RGB extends Game {
	public Stats stats = new Stats();
	
	SpriteBatch batch;
	Texture img;
	
	public RGB(){
		//stats.load();
	}
	
	@Override
	public void create() {
		setScreen(new GGIScreen(this));
		
	}

	
}
