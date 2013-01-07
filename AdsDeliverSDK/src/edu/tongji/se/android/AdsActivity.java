package edu.tongji.se.android;

import com.androidquery.AQuery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdsActivity extends Activity {

	private AQuery mAq;
	
	private String mImagePath;
	private String mAdContent;
	
	private TextView mTvAdContent;
	private ImageView mIvAdContent;
	private ImageButton mIbClose;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.adactivity_layout);
		
		Bundle bundle = getIntent().getExtras();
		mImagePath = bundle.getString(Constant.AD_IMAGE_PATH_KEY);
		mAdContent = bundle.getString(Constant.AD_CONTENT_KEY);
		
		mAq = new AQuery(this);
		
		mTvAdContent = (TextView) findViewById(R.id.tv_adcontent);
		mIvAdContent = (ImageView) findViewById(R.id.iv_adcontent);
		mIbClose = (ImageButton) findViewById(R.id.ib_close_content);
		
		mTvAdContent.setText(Html.fromHtml(mAdContent));
		mAq.id(mIvAdContent).image(mImagePath);
		
		mIbClose.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AdsActivity.this.finish();
			}
		});
		
	}
	
}
