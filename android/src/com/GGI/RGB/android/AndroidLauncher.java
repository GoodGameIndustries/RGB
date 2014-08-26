package com.GGI.RGB.android;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.GGI.RGB.ActionResolver;
import com.GGI.RGB.RGB;
import com.GGI.RGB.android.GameHelper.GameHelperListener;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;



public class AndroidLauncher extends AndroidApplication implements ActionResolver,GameHelperListener{

	private GameHelper gameHelper;
	
	private Boolean finished = true;
	
	private static final String GOOGLE_PLAY_URL = "https://play.google.com/store/apps/developer?id=Good+Game+Industries";
	final static String APP_ID  = "app0e068a9b555f40b297";
	 final static String ZONE_ID = "vz14ca1a96805c4aaeb2";
	  
	  Handler button_text_handler;
	  Runnable button_text_runnable;
	  Button video_button;


	public AndroidLauncher(){
		gameHelper = new GameHelper(this);
		gameHelper.enableDebugLog(true, "GPGS");
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new RGB(this), config);
		gameHelper.setup(this);
		gameHelper.onStart(this);
		
	
		
		 button_text_handler = new Handler();
		
		
		    
	}

	
	
	@Override
	public void onStart(){
		super.onStart();
		
		gameHelper.onStart(this);
	}

	@Override
	public void onStop(){
		super.onStop();
		gameHelper.onStop();
	}
	public void onPause()
	  {
	    super.onPause();
	   
	  }

	  public void onResume()
	  {
	    super.onResume();
	    
	  }

	@Override
	public void onActivityResult(int request, int response, Intent data) {
		super.onActivityResult(request, response, data);
		gameHelper.onActivityResult(request, response, data);
	}

	@Override
	public boolean getSignedInGPGS() {
		return gameHelper.isSignedIn();
	}

	@Override
	public void loginGPGS() {
		try {
			runOnUiThread(new Runnable(){
				public void run() {
					gameHelper.beginUserInitiatedSignIn();
				}
			});
		} catch (final Exception ex) {
		}
	}

	@Override
	public void submitScoreGPGS(int score) {
		gameHelper.getGamesClient().submitScore("CgkIrZaxjpALEAIQCA", score);
	}

	@Override
	public void unlockAchievementGPGS(String achievementId) {
		gameHelper.getGamesClient().unlockAchievement(achievementId);
	}

	@Override
	public void getLeaderboardGPGS() {
		startActivityForResult(gameHelper.getGamesClient().getLeaderboardIntent("CgkIrZaxjpALEAIQCA"), 100);
	}

	@Override
	public void getAchievementsGPGS() {
		startActivityForResult(gameHelper.getGamesClient().getAchievementsIntent(), 101);
	}

	@Override
	public void onSignInFailed() {
	}

	@Override
	public void onSignInSucceeded() {
	}
	
	

	  @Override
	  public void onBackPressed() {
	    final Dialog dialog = new Dialog(this);
	    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    LinearLayout ll = new LinearLayout(this);
	    ll.setOrientation(LinearLayout.VERTICAL);

	    Button b1 = new Button(this);
	    b1.setText("Quit");
	    b1.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	        finish();
	      }
	    });
	    ll.addView(b1);

	    Button b2 = new Button(this);
	    b2.setText("Tap To Survive");
	    b2.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(GOOGLE_PLAY_URL)));
	        dialog.dismiss();
	      }
	    });
	    ll.addView(b2);

	    dialog.setContentView(ll);
	    dialog.show();
	  }

	  
		 
		    
	  

	  public boolean getFinished(){return finished;}

	@Override
	public void playAd() {
		// TODO Auto-generated method stub
		
	}
}