package com.aepan.sysmgr.service.implement;

import java.io.IOException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aepan.sysmgr.service.HttpCallService;
import com.aepan.sysmgr.util.ConfigManager;
@Service
public class HttpCallServiceImpl implements HttpCallService{
	private static final Logger logger = LoggerFactory.getLogger(HttpCallServiceImpl.class);
	//统计流量
	public void countUsedFlow() {
		sendHttpRequest("/rest/task/countUsedFlow");
	}
	//套餐到期提醒
	public void sendPackageDueTips() {
		sendHttpRequest("/rest/task/sendPackageDueTips");
	}
	//同步商品分类
	public void reloadCategory() {
		sendHttpRequest("/rest/task/reloadCategory");
	}
	private void sendHttpRequest(String url){
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
		try{
		// Start the client
	    httpclient.start();

	    // Execute request
	    url = ConfigManager.getInstants().getTaskHost()+url;
	    logger.debug("async send http request url:"+url);
	    final HttpGet request1 = new HttpGet(url);
	    Future<HttpResponse> future = httpclient.execute(request1, null);
	    // and wait until a response is received
	    HttpResponse response1 = future.get();
	    logger.debug(request1.getRequestLine() + "->" + response1.getStatusLine());
		}catch(Exception e){
			
		} finally {
		    try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
