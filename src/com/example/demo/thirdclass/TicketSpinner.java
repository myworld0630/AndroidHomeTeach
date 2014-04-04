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
	Spinner cinema;	// ���|�M�檫��
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
		String[] cinemas=getResources().			// ���o�r��귽��
				getStringArray(R.array.cinemas);	// ���r��}�C
		
		int index=cinema.getSelectedItemPosition();	// ���Q���������		
		txv.setText("�q"+cinemas[index]+"����");		// ��ܿ��������
	}
}
