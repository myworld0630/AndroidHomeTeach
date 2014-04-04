package com.example.hometeach;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ClassMenu extends Activity {

	public Button button1;
	public Button button2;
	public Button button3;

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.classmenu);

		// //////////////////////////////////////////////////////////////////
		button1 = (Button) findViewById(R.id.Button1);

		button1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(ClassMenu.this, FirstClass.class);
				startActivity(intent);
				ClassMenu.this.finish();
			}
		});
		// //////////////////////////////////////////////////////////////////
		button2 = (Button) findViewById(R.id.Button2);

		button2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String messageStringArray[] = { "Welcome Activity", "to",
						"SecondClass Activity" }; // 要傳送的資料
				String messageString = "Welcome Activity to SecondClass Activity";
				int messageInt = 100;
				Intent intent = new Intent(ClassMenu.this, SecondClass.class);
				intent.putExtra("messageStringArray", messageStringArray);
				intent.putExtra("messageString", messageString);
				intent.putExtra("messageInt", messageInt);
				startActivity(intent);
				ClassMenu.this.finish();
			}
		});
		// //////////////////////////////////////////////////////////////////
		button3 = (Button) findViewById(R.id.Button3);

		button3.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ClassMenu.this, ThirdClass.class);
				startActivity(intent);
				ClassMenu.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.classmenu, menu);
		return true;
	}

}
