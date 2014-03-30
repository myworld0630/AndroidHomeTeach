package com.example.hometeach;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

import com.exampl.demo.secondclass.*;

public class SecondClass extends Activity implements OnItemClickListener{

	private ListView listView;
	private ArrayAdapter<String>adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondclass);

		/////////////////////////////////////////////////////////////////////
		Intent intent = getIntent();
		String messageStringArray[] = intent
				.getStringArrayExtra("messageStringArray");
		String messageString = intent.getStringExtra("messageString");
		int messageInt = intent.getIntExtra("messageInt", 0);
		System.out.println("SecondClass:" + messageStringArray);
		System.out.println("SecondClass:" + messageString);
		System.out.println("SecondClass:" + messageInt);
		/////////////////////////////////////////////////////////////////////
		
		// ²M³æ°}¦C
		listView = (ListView) findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		adapter.add("Memo");
		adapter.add("BuyTickey");
		adapter.add("TempConversion");
		adapter.add("FoodMenu");
		adapter.add("FoodMenuEvent");
		adapter.add("ImageView");
		adapter.add("FoodImgMenu");
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.secondclass, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent();
			intent.setClass(SecondClass.this, ClassMenu.class);
			startActivity(intent);
			SecondClass.this.finish();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
		
		Intent it;
		if(listView.getItemAtPosition(pos).toString().equals("Memo")){
			it = new Intent(this, MemoActivity.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("BuyTickey")){
			it = new Intent(this, BuyTicket.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("TempConversion")){
			it = new Intent(this, TempConversion.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("FoodMenu")){
			it = new Intent(this, FoodMenu.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("FoodMenuEvent")){
			it = new Intent(this, FoodMenuEvent.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("ImageView")){
			it = new Intent(this, ImgView.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("FoodImgMenu")){
			it = new Intent(this, FoodImgMenu.class);
			startActivity(it);
		}
	}
}
