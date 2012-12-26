package edu.tongji.se.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdView extends LinearLayout{
	
	ImageView iv_banner_pic;
	TextView tv_banner_text1;
	TextView tv_banner_text2;

	public AdView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.adview_layout, this, true);
		
		iv_banner_pic = (ImageView) findViewById(R.id.ads_banner_pic);
		tv_banner_text1 = (TextView) findViewById(R.id.ads_banner_text1);
		tv_banner_text2 = (TextView) findViewById(R.id.ads_banner_text2);
		
	}

	@Override
	protected void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
	}
	
}
