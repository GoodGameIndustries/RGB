/**
 * 
 */
package com.GGI.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * @author Emmett Deen
 *
 */
public class Stats {
	private int HS = 0;
	private int GP = 0;
	private int M = 0;
	private int CB = 0;
	
	public Stats(){
		
	}
	
	public void load(){//HS:GP:MUSIC:COLORBLIND
		if(Gdx.files.local("localStats.txt").exists()){
			FileHandle file = Gdx.files.local("localStats.txt");
			String text[] = file.readString().split(":");
			HS = Integer.parseInt(text[0]);
			GP = Integer.parseInt(text[1]);
			
		}
		else{
			FileHandle from = Gdx.files.internal("stats.txt");
			from.copyTo(Gdx.files.local("localStats.txt"));
			
			FileHandle file = Gdx.files.local("localStats.txt");
			String[] text = file.readString().split(":");
			HS = Integer.parseInt(text[0]);
			GP = Integer.parseInt(text[1]);
			
		}
	}
	
	public void save(){
		FileHandle file = Gdx.files.local("localStats.txt");
		file.writeString(HS+":"+GP+":"+M+":"+CB, false);
	}

	public int getHS() {
		return HS;
	}

	public void setHS(int hS) {
		HS = hS;
	}

	public int getGP() {
		return GP;
	}

	public void setGP(int gP) {
		GP = gP;
	}

}
