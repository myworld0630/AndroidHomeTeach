package com.example.hometeach;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.demo.fourthclass.Geocoder;
import com.example.demo.fourthclass.HelloCursor;
import com.example.demo.fourthclass.HelloSQLite;
import com.example.demo.fourthclass.MyHotline;
import com.example.demo.fourthclass.MyMap;
import com.example.demo.fourthclass.MyMap2;
import com.example.demo.fourthclass.SimpleLocation;

public class FourthClass extends Activity implements OnItemClickListener{

	private ListView listView;
	private ArrayAdapter<String>adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fourthclass);

		// ²M³æ°}¦C
		listView = (ListView) findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		adapter.add("HelloSQLite");
		adapter.add("HelloCursor");
		adapter.add("MyHotline");
		adapter.add("SimpleLocation");
		adapter.add("Geocoder");
		adapter.add("MyMap");
		adapter.add("MyMap2");
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fourthclass, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent();
			intent.setClass(FourthClass.this, ClassMenu.class);
			startActivity(intent);
			FourthClass.this.finish();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
		
		Intent it;
		if(listView.getItemAtPosition(pos).toString().equals("HelloSQLite")){
			it = new Intent(this, HelloSQLite.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("HelloCursor")){
			it = new Intent(this, HelloCursor.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("MyHotline")){
			it = new Intent(this, MyHotline.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("SimpleLocation")){
			it = new Intent(this, SimpleLocation.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("Geocoder")){
			it = new Intent(this, Geocoder.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("MyMap")){
			it = new Intent(this, MyMap.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("MyMap2")){
			it = new Intent(this, MyMap2.class);
			startActivity(it);
		}
	}
}
