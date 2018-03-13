package com.tang.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public String loginServer(String path) {
		String responseMsg = "";

		// servlet服务器地址是
		// String urlStr = "http://192.168.3.177:8080/Test/servlet/TestServlet";
		String urlStr = "http://192.168.3.177:8080/Test/" + path;
		HttpPost request = new HttpPost(urlStr);

		try {
			HttpClient client = getHttpClient();
			// 执行请求
			HttpResponse response = client.execute(request);
			// response是servlet给出的返回结果
			// if(response.getStatusLine().getStatusCode() == 200){
			responseMsg = EntityUtils.toString(response.getEntity());
			System.out.println("11111111111111responseMsg-------------"
					+ responseMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseMsg;
	}

	public HttpClient getHttpClient() {
		BasicHttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 3 * 1000);
		HttpConnectionParams.setSoTimeout(httpParams, 5 * 1000);
		HttpClient client = new DefaultHttpClient(httpParams);
		return client;
	}
	public static void main(String[] args) {
		System.out.println(2);
	}
}