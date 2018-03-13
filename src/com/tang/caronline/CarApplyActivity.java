package com.tang.caronline;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
/**
 * 用车申请
 * @author Administrator
 *
 */
public class CarApplyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_car_apply);
		setTitle("用车申请");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}


}
