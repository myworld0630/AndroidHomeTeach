package com.example.hometeach;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class classMenu extends Activity {

	public Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		button1 = (Button) findViewById(R.id.Button1);
		
		button1.setOnClickListener(new Button.OnClickListener(){
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(classMenu.this, firstClass.class);
				startActivity(intent); 
				classMenu.this.finish(); 
			}         
        });		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
