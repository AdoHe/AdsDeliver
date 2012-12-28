package edu.tongji.se.android;

import com.androidquery.AQuery;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class AdView extends LinearLayout{
	
	ImageView iv_banner_pic;
	TextView tv_banner_text1;
	TextView tv_banner_text2;
	ViewFlipper vp_banner_flipper;
	
	Context mContext;
	
	AdClient mAdClient;
	RequestAdTask mRequestAdTask;
	AdverInfo mAdverInfo;
	AQuery aq;

	public AdView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.adview_layout, this, true);
		
		mContext = context;
		
		iv_banner_pic = (ImageView) findViewById(R.id.ads_banner_pic);
		tv_banner_text1 = (TextView) findViewById(R.id.ads_banner_text1);
		tv_banner_text2 = (TextView) findViewById(R.id.ads_banner_text2);
		vp_banner_flipper = (ViewFlipper) findViewById(R.id.ads_banner_fliper);
		
		mAdClient = AdClient.getInstance();
		aq = new AQuery(context);
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		
		// 设置ViewFliper
		vp_banner_flipper.setInAnimation(mContext, R.anim.roll_up);
		vp_banner_flipper.setOutAnimation(mContext, R.anim.roll_down);
		vp_banner_flipper.setAutoStart(true);
		vp_banner_flipper.setFlipInterval(5000);
		
		
		try {
			getAdFromNet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Toast.makeText(mContext, "正在请求广告...", Toast.LENGTH_LONG).show();
	}
	
	
	private void getAdFromNet() throws Exception {
		
		mRequestAdTask = new RequestAdTask();
		mRequestAdTask.execute();
		
	}
	
	private class RequestAdTask extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected Boolean doInBackground(Void... arg0) {
			
			try {
				mAdClient.RequestAd((float)121.819, (float)31.1218);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			return mAdClient.hasError(); 
		}

		@Override
		protected void onPostExecute(Boolean result) {
			
			if(!result) {
				
				mAdverInfo = mAdClient.getAdverInfo();
				Log.d("AdsDeliverSDK", "banner_word_one: " + mAdverInfo.getBanner_word_one());
				
				if(mAdverInfo == null) {
					Log.d("AdsDeliverSDK", "mAdverInfo is null");
				}else {
				}
				
				tv_banner_text1.setText(mAdverInfo.getBanner_word_one());
				tv_banner_text2.setText(mAdverInfo.getBanner_word_two());
				aq.id(iv_banner_pic).image(mAdverInfo.getBanner_pic());
			}
			
		}
		
	}
	
}
