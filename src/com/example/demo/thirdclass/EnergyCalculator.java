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

	// 字串陣列中各項運動的能量消耗率:『仟卡/公斤/小時』
	double[] energyRate = { 3.1, 4.4, 13.2, 9.7, 5.1, 3.7 };
	EditText weight, time; // 體重及運動時間欄位
	TextView total, txvRate; // 顯示能量消耗率, 計算結果的 TextView
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
		sports.setOnItemSelectedListener(this); // 註冊監聽器
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// 顯示選取的運動項目, 其基本的能量消耗率
		txvRate.setText(String.valueOf(energyRate[position]));
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub		
	}
    
	public void calc(View v){
		// 取得使用者輸入的體重
		
		if( (!weight.getText().toString().equals("")) && (!time.getText().toString().equals("") )){
			double w=Double.parseDouble(weight.getText().toString());
			// 取得使用者輸入的運動時間長度
			double t=Double.parseDouble(time.getText().toString());
			int selected=sports.getSelectedItemPosition(); // 取得目前選取項目的索引
			// 計算消耗能量=能量消耗率*體重*運動時間長度
			long consumedEnergy=Math.round(energyRate[selected]*w*t);
			total.setText(		// 顯示計算結果
					String.format("消耗能量\n  %d仟卡", consumedEnergy));
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
