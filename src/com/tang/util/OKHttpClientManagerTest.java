package com.tang.util;

import java.io.IOException;

public class OKHttpClientManagerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://192.168.3.177:8099/cl/sys/SysUser_login?u.username=admin&u.password=abc123";
		
		
		// 进行用户名和密码校验
		try {
			OkHttpClientManager.post(url, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
