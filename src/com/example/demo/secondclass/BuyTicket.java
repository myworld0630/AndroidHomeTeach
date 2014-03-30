package com.example.demo.secondclass;

import com.example.hometeach.R;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BuyTicket extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buyticket);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buyticket, menu);
		return true;
	}

	public void show(View v) {
		TextView txv = (TextView) findViewById(R.id.txv);
		RadioGroup ticketType = (RadioGroup) findViewById(R.id.ticketType);

		// �̿��������ܤ��P�T�� - �z�L getCheckedRadioButtonId ��k���o�Ŀ窱�A
		switch (ticketType.getCheckedRadioButtonId()) {
		case R.id.adult: // �����
			txv.setText("�R����");
			break;
		case R.id.child: // ��b��
			txv.setText("�R�b��");
			break;
		case R.id.senior: // ��q�Ѳ�
			txv.setText("�R�q�Ѳ�");
			break;
		}

		// int id = ticketType.getCheckedRadioButtonId();
		// RadioButton select = (RadioButton) findViewById(id);
		// txv.setText("�R:" + select.getText());
	}
}