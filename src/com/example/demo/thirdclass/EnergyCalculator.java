package com.example.demo.thirdclass;

import com.example.hometeach.*;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class EnergyCalculator extends Activity implements OnItemSelectedListener{

	// �r��}�C���U���B�ʪ���q���Ӳv:�y�a�d/����/�p�ɡz
	double[] energyRate = { 3.1, 4.4, 13.2, 9.7, 5.1, 3.7 };
	EditText weight, time; // �魫�ιB�ʮɶ����
	TextView total, txvRate; // ��ܯ�q���Ӳv, �p�⵲�G�� TextView
	Spinner sports;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.energycalculator);

		weight = (EditText) findViewById(R.id.weight);
		time = (EditText) findViewById(R.id.timeSpan);
		total = (TextView) findViewById(R.id.total);
		txvRate = (TextView) findViewById(R.id.txvRate);
		sports = (Spinner) findViewById(R.id.sports);
		sports.setOnItemSelectedListener(this); // ���U��ť��
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// ��ܿ�����B�ʶ���, ��򥻪���q���Ӳv
		txvRate.setText(String.valueOf(energyRate[position]));
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub		
	}
    
	public void calc(View v){
		// ���o�ϥΪ̿�J���魫
		
		if( (!weight.getText().toString().equals("")) && (!time.getText().toString().equals("") )){
			double w=Double.parseDouble(weight.getText().toString());
			// ���o�ϥΪ̿�J���B�ʮɶ�����
			double t=Double.parseDouble(time.getText().toString());
			int selected=sports.getSelectedItemPosition(); // ���o�ثe������ت�����
			// �p����ӯ�q=��q���Ӳv*�魫*�B�ʮɶ�����
			long consumedEnergy=Math.round(energyRate[selected]*w*t);
			total.setText(		// ��ܭp�⵲�G
					String.format("���ӯ�q\n  %d�a�d", consumedEnergy));
		}
		else{
			System.out.println("String is empty");
		}
		
	}
    	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.energycalculator, menu);
		return true;
	}

}
