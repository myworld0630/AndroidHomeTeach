package com.example.demo.thirdclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ArrayAdaptor extends Activity implements OnItemSelectedListener {

	Spinner drink, temp; // 顯示飲品項目與溫度選項的 Spinner
	TextView txv; // 顯示訂單內容的 TextView
	String[] tempSet1 = { "冰", "去冰", "溫" }; // 三種溫度
	String[] tempSet2 = { "冰", "去冰" }; // 兩種溫度

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.arrayadaptor);

		txv = (TextView) findViewById(R.id.order);
		temp = (Spinner) findViewById(R.id.temp); // 找出顯示溫度的 Spinner
		drink = (Spinner) findViewById(R.id.drink); // 找出顯示飲品項目的 Spinner
		drink.setOnItemSelectedListener(this); // 設定監聽選取事件
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.arrayadaptor, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> sv, View v, int pos, long id) {

		String[] tempSet;
		if (pos == 3) // 若選取檸檬汁
			tempSet = tempSet2; // 溫度選項沒有『溫』
		else
			tempSet = tempSet1;
		ArrayAdapter<String> tempAd = // 依據溫度選項建立 ArrayAdapter
		new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, // 選單位打開時的顯示樣式
				tempSet); // 溫度選項
		tempAd.setDropDownViewResource( // 設定下拉選單的選項樣式
		android.R.layout.simple_spinner_dropdown_item);
		temp.setAdapter(tempAd); // 設定使用 Adapter 物件
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

	// 按鈕的事件處理方法
	public void showOrder(View v) {
		// 將飲料名稱及溫度選擇組成一個字串
		String msg = drink.getSelectedItem() + ", " + // 取得飲料名稱
				temp.getSelectedItem(); // 取得甜度選項

		// 將訂單內容顯示在文字方塊中
		txv.setText(msg);
	}
}
