package com.tang.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;

import com.tang.caronline.R;

public class WelcomeActivity extends Activity {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.activity_welcome);
	        Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
					startActivity(intent);
					finish();
				}
			}, 3000);
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
