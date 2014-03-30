package com.example.hometeach;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Welcome extends Activity {

	private View view;
	private boolean flag=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//全螢幕設定
		requestWindowFeature(Window.FEATURE_NO_TITLE); //消除標題框
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //設定全螢幕
		
		setContentView(R.layout.welcome);	//程式與 layout之間的關係就是由此建立!!
	
		view = findViewById(R.id.welcome);	//手動在 linear layout 加一個 id
		
		view.postDelayed(new Runnable() {
			public void run() {
				if(flag==false)
					gotoMain();
				}
		 	},5000); //5秒後執行
		
	}

	private void gotoMain(){
		Intent it = new Intent(Welcome.this, ClassMenu.class);	//Intent 想要:想要從 Welcome 跳到 MainActivity
		startActivity(it);
		Welcome.this.finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}