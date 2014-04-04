package com.example.demo.secondclass;

import com.example.hometeach.R;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TempConversion extends Activity implements OnCheckedChangeListener, TextWatcher{

	RadioGroup unit;
	EditText value; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tempconversion);
		
        /////////////////////////////////////////////////////////////////////////////
        unit  = (RadioGroup)findViewById(R.id.unit);  // 取得『單位』單選鈕群組
        unit.setOnCheckedChangeListener(this);        // 設定 this 為監聽器
        
        value = (EditText)  findViewById(R.id.value); // 取得輸入欄位
        value.addTextChangedListener(this);           // 設定 this 為監聽器
        /////////////////////////////////////////////////////////////////////////////
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tempconversion, menu);
		return true;
	}

	public void afterTextChanged(Editable arg0) {
		calc();		
	}

	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TextWatcher 介面的方法, 此處不會用到
	}

	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TextWatcher 介面的方法, 此處不會用到
	}

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		calc();
	}

	protected void calc() {
        // 取得文字方塊
    	TextView degF = (TextView) findViewById(R.id.degF);
    	TextView degC = (TextView) findViewById(R.id.degC);

    	double f=0, c=0;  // 儲存溫度值換算結果

    	// 若選擇輸入華氏溫度
    	if(unit.getCheckedRadioButtonId()==R.id.unitF){
    		f = Double.parseDouble(
    				value.getText().toString());
    		c = (f-32)*5/9;  // 華氏 => 攝氏      

    	} else{   // 若選擇輸入攝氏溫度
    		c = Double.parseDouble(
    				value.getText().toString());
    		f = c*9/5+32;    // 攝氏 => 華氏
    	}

    	degC.setText(String.format("%.1f",c)+  
    			// 自專案資源載入字串
    			getResources().getString(R.string.charC));
    	degF.setText(String.format("%.1f",f)+
    			getResources().getString(R.string.charF));
    }
	
}
