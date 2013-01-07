package edu.tongji.se.android;

import com.androidquery.AQuery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class AdView extends LinearLayout{
	
	private static final String TAG = "AdsDeliverSDK";
	
	ImageView iv_banner_pic;
	TextView tv_banner_text1;
	TextView tv_banner_text2;
	ViewFlipper vp_banner_flipper;
	
	Context mContext;
	
	AdClient mAdClient;
	RequestAdTask mRequestAdTask;
	AdverInfo mAdverInfo;
	AQuery aq;
	Location mLocation;

	public AdView(final Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.adview_layout, this, true);
		
		mContext = context;
		
		iv_banner_pic = (ImageView) findViewById(R.id.ads_banner_pic);
		tv_banner_text1 = (TextView) findViewById(R.id.ads_banner_text1);
		tv_banner_text2 = (TextView) findViewById(R.id.ads_banner_text2);
		vp_banner_flipper = (ViewFlipper) findViewById(R.id.ads_banner_fliper);
		
		mAdClient = AdClient.getInstance();
		aq = new AQuery(context);
		
		// 点击跳转到AdActivity
		AdView.this.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, AdsActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString(Constant.AD_IMAGE_PATH_KEY, Constant.DOMAIN + mAdverInfo.getContent_pic());
				bundle.putString(Constant.AD_CONTENT_KEY, mAdverInfo.getContent_word());
				intent.putExtras(bundle);
				context.startActivity(intent);
			}
		});
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		
		//TODO 一开始广告设成不可见的
		//AdView.this.setVisibility(View.GONE);

		// 设置ViewFliper
		vp_banner_flipper.setInAnimation(mContext, R.anim.roll_up);
		vp_banner_flipper.setOutAnimation(mContext, R.anim.roll_down);
		vp_banner_flipper.setAutoStart(true);
		vp_banner_flipper.setFlipInterval(5000);
		
		
		LocationUtil.getLocation(mContext, mLocationListener);
		
		
		
		
	}
	
	private LocationListener mLocationListener = new LocationListener() {

		@Override
		public void onLocationChanged(Location location) {
			LocationUtil.locationManager.removeUpdates(mLocationListener);
			
			mLocation = location;
			try {
				getAdFromNet();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Toast.makeText(mContext, "正在请求广告...", Toast.LENGTH_LONG).show();
			
			
		}

		@Override
		public void onProviderDisabled(String provider) {
			Log.d(TAG, "provider disable");
		}
		@Override

		public void onProviderEnabled(String provider) {
			Log.d(TAG, "provider enable");
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			
		}
		
	};

	
	private void getAdFromNet() throws Exception {
		
		mRequestAdTask = new RequestAdTask();
		mRequestAdTask.execute(mLocation);
		
	}
	
	private class RequestAdTask extends AsyncTask<Location, Void, Boolean> {

		@Override
		protected Boolean doInBackground(Location... locations) {
			
			Location location = locations[0];
			try {
				mAdClient.RequestAd((float)location.getLongitude(), (float)location.getLatitude());
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			return mAdClient.hasError(); 
		}

		@Override
		protected void onPostExecute(Boolean result) {
			
			if(!result) {
				
				mAdverInfo = mAdClient.getAdverInfo();
				
				if(mAdverInfo == null) {
					Log.d("AdsDeliverSDK", "mAdverInfo is null");
				}else {
					tv_banner_text1.setText(mAdverInfo.getBanner_word_one());
					tv_banner_text2.setText(mAdverInfo.getBanner_word_two());
					aq.id(iv_banner_pic).image(Constant.DOMAIN + mAdverInfo.getBanner_pic());
					AdView.this.setVisibility(View.VISIBLE);
				}
				
			}
			
		}
		
	}
	
}
