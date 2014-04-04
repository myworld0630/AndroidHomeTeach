package com.example.demo.thirdclass;

import com.example.hometeach.R;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;

public class DialogShow extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogshow);
		
        AlertDialog.Builder bdr = new AlertDialog.Builder(this);
        bdr.setMessage("交談窗示範教學！\n" // 加入文字訊息
        				+ "請按返回鍵關閉交談窗");
        bdr.setTitle("歡迎");        // 加入標題                  
        bdr.setIcon(android.R.drawable.presence_away); // 加入圖示
        bdr.setCancelable(true);   // 允許按返回鍵關閉交談窗
        bdr.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialogshow, menu);
		return true;
	}

}
