package com.example.demo.secondclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BuyTicket extends Activity {

	TextView txv;
	RadioGroup ticketType;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buyticket);
		
		txv = (TextView) findViewById(R.id.txv);
		ticketType = (RadioGroup) findViewById(R.id.ticketType);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buyticket, menu);
		return true;
	}

	public void show(View v) {
		
		// 依選取項目顯示不同訊息 - 透過 getCheckedRadioButtonId 方法取得勾選狀態
		switch (ticketType.getCheckedRadioButtonId()) {
		case R.id.adult: // 選全票
			txv.setText("買全票");
			break;
		case R.id.child: // 選半票
			txv.setText("買半票");
			break;
		case R.id.senior: // 選敬老票
			txv.setText("買敬老票");
			break;
		}

		// int id = ticketType.getCheckedRadioButtonId();
		// RadioButton select = (RadioButton) findViewById(id);
		// txv.setText("買:" + select.getText());
	}
}
