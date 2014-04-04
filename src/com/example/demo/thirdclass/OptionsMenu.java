package com.example.demo.thirdclass;


import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.optionsmenu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.optionsmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String msg = "";
		switch (item.getItemId()) {
		case R.id.yangmingshan:
			msg = getString(R.string.yangmingshan);
			break;
		case R.id.yushan:
			msg = getString(R.string.yushan);
			break;
		case R.id.taroko:
			msg = getString(R.string.taroko);
			break;
		case R.id.myloc:
			msg = getString(R.string.myloc);
			break;
		case R.id.exit:
			this.finish();
		default:
			return super.onOptionsItemSelected(item);
		}
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
		return true;
	}
	
}
