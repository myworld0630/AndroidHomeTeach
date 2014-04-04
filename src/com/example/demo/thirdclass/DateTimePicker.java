package com.example.demo.thirdclass;

import java.util.Calendar;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class DateTimePicker extends Activity implements OnClickListener,
		DatePickerDialog.OnDateSetListener, // 實作監聽日期交談窗事件的介面
		TimePickerDialog.OnTimeSetListener {// 實作監聽時間交談窗事件的介面

	Calendar c = Calendar.getInstance();  //建立日曆物件
    TextView txDate; // 記錄日期文字的元件
    TextView txTime; // 記錄時間文字的元件
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datetimepicker);
		
        txDate = (TextView)findViewById(R.id.textView1); // 找出日期文字元件
        txTime = (TextView)findViewById(R.id.textView2);
        
        txDate.setOnClickListener(this); //設定按下日期文字時的監聽物件
        txTime.setOnClickListener(this); //設定按下時間文字時的監聽物件
	}

    @Override
	public void onClick(View v) {
		if(v == txDate) { // 按的是日期文字
			//建立日期選擇交談窗, 並傳入設定完成時的監聽物件
	    	new DatePickerDialog(this, this, // 由活動物件監聽事件
	    	    c.get(Calendar.YEAR),  //由Calendar物件取得目前的西元年
	    	    c.get(Calendar.MONTH),        //取得目前月 (由 0 算起)
	    	    c.get(Calendar.DAY_OF_MONTH)) //取得目前日
	    	.show();  //顯示出來
		}
		else if(v == txTime) { // 按的是時間文字
			//建立時間選擇交談窗, 並傳入設定完成時的監聽物件
			new TimePickerDialog(this, this, // 由活動物件監聽事件
				c.get(Calendar.HOUR_OF_DAY), //取得目前的時 (24小時制)
				c.get(Calendar.MINUTE),      //取得目前的分 
				true)                        //使用24小時制
			.show();   //顯示出來
		}
	}

    @Override
    public void onDateSet(DatePicker v, int y, int m, int d) { // 選定日期後的處理方法						
    	txDate.setText("日期：" + y + "/" + (m+1) + "/" + d); // 將選定日期顯示在螢幕上
	}						   	

    @Override
	public void onTimeSet(TimePicker v, int h, int m) { // 選定日期後的處理方法
   		txTime.setText("時間：" + h + ":" + m); // 將選定的時間顯示在螢幕上     					
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.datetimepicker, menu);
		return true;
	}

}
