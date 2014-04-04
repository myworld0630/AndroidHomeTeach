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

import com.example.demo.secondclass.*;
import com.example.demo.thirdclass.*;

public class ThirdClass extends Activity implements OnItemClickListener{

	private ListView listView;
	private ArrayAdapter<String>adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondclass);

		// ²M³æ°}¦C
		listView = (ListView) findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		adapter.add("TicketSpinner");
		adapter.add("EnergyCalculator");
		adapter.add("ListMenu");
		adapter.add("ArrayAdapter");
		adapter.add("BrainTeaser");
		adapter.add("BrainTeaser2");
		adapter.add("DialogShow");
		adapter.add("DialogAsk");
		adapter.add("DateTimePicker");
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
			intent.setClass(ThirdClass.this, ClassMenu.class);
			startActivity(intent);
			ThirdClass.this.finish();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
		
		Intent it;
		if(listView.getItemAtPosition(pos).toString().equals("TicketSpinner")){
			it = new Intent(this, TicketSpinner.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("EnergyCalculator")){
			it = new Intent(this, EnergyCalculator.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("ListMenu")){
			it = new Intent(this, ListMenu.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("ArrayAdapter")){
			it = new Intent(this, ArrayAdapter.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("BrainTeaser")){
			it = new Intent(this, BrainTeaser.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("BrainTeaser2")){
			it = new Intent(this, BrainTeaser2.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("DialogShow")){
			it = new Intent(this, DialogShow.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("DialogAsk")){
			it = new Intent(this, DialogAsk.class);
			startActivity(it);
		}
		else if(listView.getItemAtPosition(pos).toString().equals("DateTimePicker")){
			it = new Intent(this, DateTimePicker.class);
			startActivity(it);
		}
	}
}
