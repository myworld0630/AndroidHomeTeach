package com.exampl.demo.secondclass;

import com.example.hometeach.R;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ImgView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imgview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.imgview, menu);
		return true;
	}

}
