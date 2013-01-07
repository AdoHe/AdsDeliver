package edu.tongji.se.android;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public class AdClient {
	
	private static final String TAG = "AdsDeliver_SDK";
	private static final String METHOD_URL = Constant.DOMAIN + "/AdsDeliver_Server/AdRequest.action";
	
	private String request_url;
	private String responseStr;
	private AdverInfo adverInfo;
	private boolean hasError;
	
	private HttpClient httpClient;
	private HttpGet request;
	
	
	
	private AdClient() {
		httpClient = new DefaultHttpClient();
		request = new HttpGet();
		adverInfo = null;
		hasError = false;
	}
	
	private static class AdClientContainer
	{
		private static AdClient client = new AdClient();
	}
	
	public static synchronized AdClient getInstance()
	{
		return AdClientContainer.client;
	}
	
	
	public void RequestAd(float lng, float lat) throws Exception{
		
		request_url = METHOD_URL + "?lng=" + lng + "&lat=" + lat;
		URI uri = new URI(request_url);
		request.setURI(uri);
		
		HttpResponse response = httpClient.execute(request);
		
		switch(response.getStatusLine().getStatusCode()) {
		case 200: {
			Log.d(TAG, "advertisement request success");
			requestSuccess(response);
			hasError = false;
			break;
		}
		default: {
			Log.d(TAG, "advertisement request failed.");
			hasError = true;
			break;
		}
		
		}
		
	}
	
	
	// 请求成功后处理返回信息
	private void requestSuccess(HttpResponse resp) throws ParseException, IOException, JSONException {
		responseStr = EntityUtils.toString(resp.getEntity());
		Log.d(TAG, "responseString: " + responseStr);
		
		// 解析返回的JSON
		JSONObject json = new JSONObject(responseStr);
		JSONObject ad_json = json.getJSONObject("ad");
		JSONObject adInfo_json = ad_json.getJSONObject("adverinfo");
		adverInfo = new AdverInfo();
		
		adverInfo.setBanner_pic(adInfo_json.getString("afBannerPic"));
		adverInfo.setBanner_word_one(adInfo_json.getString("afBannerWordOne"));
		adverInfo.setBanner_word_two(adInfo_json.getString("afBannerWordTwo"));
		adverInfo.setContent_pic(adInfo_json.getString("afContentPic"));
		adverInfo.setContent_word(adInfo_json.getString("afContents"));
		adverInfo.setAd_address(ad_json.getString("avAddress"));
	}


	public AdverInfo getAdverInfo() {
		return adverInfo;
	}
	
	public boolean hasError() {
		return hasError;
	}
	
	
}
