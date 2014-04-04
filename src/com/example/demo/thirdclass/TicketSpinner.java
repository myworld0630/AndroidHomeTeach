package com.example.demo.thirdclass;

import com.example.hometeach.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class TicketSpinner extends Activity {
	TextView txv;	
	Spinner cinema;	// 戲院清單物件
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticketspinner);
		
		txv = (TextView)findViewById(R.id.txv);
		cinema = (Spinner) findViewById(R.id.cinema);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ticketspinner, menu);
		return true;
	}
	
	public void order(View v){
		String[] cinemas=getResources().			// 取得字串資源中
				getStringArray(R.array.cinemas);	// 的字串陣列
		
		int index=cinema.getSelectedItemPosition();	// 取被選取的項目		
		txv.setText("訂"+cinemas[index]+"的票");		// 顯示選取的項目
	}
}
