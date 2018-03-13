package com.tang.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tang.caronline.CarActivity;
import com.tang.caronline.CarApplyActivity;
import com.tang.caronline.DriverActivity;
import com.tang.caronline.MainActivity;
import com.tang.caronline.R;
import com.tang.util.OkHttpClientManager;
import com.tang.util.OkHttpClientManager.Param;

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
			try{
				
				InputStream is = getClassLoader().getResourceAsStream("ser.properties");
				Properties p = new Properties();
				p.load(is);
				String url = p.getProperty("url");
				url +="sys/SysUser_logins"; 
				Param p1  = new Param("username","admin");
				Param p2  = new Param("password","abc123");
			OkHttpClientManager.postAsyn(url, new OkHttpClientManager.StringCallback(){

				@Override
				public void onFailure(Request request, IOException e) {
					
				}

				@Override
				public void onResponse(String response) {
					JSONObject json = JSONObject.parseObject(response);
					System.out.println(json.get("id"));
					System.out.println("response-->"+response);
					JSONArray jarr = JSONArray.parseArray(json.getString("auth"));
					for (Iterator iterator = jarr.iterator(); iterator
							.hasNext();) {
						JSONObject job = (JSONObject) iterator.next();
						String code = job.get("code").toString();
						System.out.println("code:"+code);
					}
					Intent intent = new Intent(LoginActivity.this, DriverActivity.class);
					startActivity(intent);
				} }, p1,p2);
			
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				
			}
			
			
			
			Thread t = new Thread() {
				@SuppressLint("NewApi")
				@Override
				public void run() {
					System.out.println("启动线程");
					try {
						
						InputStream is = getClassLoader().getResourceAsStream("ser.properties");
						Properties p = new Properties();
						p.load(is);
						
						String url;
						url = p.getProperty("url")+"sys/SysUser_logins";
						System.out.println(url);
						// 进行用户名和密码校验
						Param p1  = new Param("username","admin");
						Param p2  = new Param("password","abc123");
						Response r =  OkHttpClientManager.post(url,p1,p2);
						System.out.println("r.code()------>"+r.code());
						System.out.println("r---->"+r.body().string());
						System.out.println("r.message()---->"+r.message());
						System.out.println("url:" + url);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			};
			//t.start();

		}
	};

}
