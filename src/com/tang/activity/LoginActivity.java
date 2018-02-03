package com.tang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.tang.caronline.MainActivity;
import com.tang.caronline.R;

public class LoginActivity extends Activity {

	private Button mLogin;
	private TextView username;
	private TextView password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		initView();

		mLogin.setOnClickListener(loginOnClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	/**
	 * 初始化视图
	 */
	public void initView() {
		mLogin = (Button) findViewById(R.id.login);
		username = (TextView) findViewById(R.id.loginname);
		password = (TextView) findViewById(R.id.password);

	}

	private OnClickListener loginOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// 进行用户名和密码校验

			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(intent);
			finish();

		}
	};

}
