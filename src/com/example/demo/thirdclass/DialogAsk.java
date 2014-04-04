package com.example.demo.thirdclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.widget.TextView;

public class DialogAsk extends Activity implements DialogInterface.OnClickListener { // 實作監聽介面

	TextView txv; // 記錄預設的 TextView 元件
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogask);
		
        txv = (TextView)findViewById(R.id.answer); // 找出預設的 TextView 元件
        new AlertDialog.Builder(this) // 建立 Builder 物件
        	.setMessage("你喜歡 Android 手機嗎？") // 設定顯示訊息
        	.setCancelable(false) // 禁用返回鍵關閉交談窗
        	.setIcon(android.R.drawable.ic_menu_edit) // 採用內建的圖示
        	.setTitle("Android 問卷調查") // 設定交談窗的標題
        	.setPositiveButton("喜歡", this)  // 加入否定按鈕
        	.setNegativeButton("討厭", this) 	// 加入肯定按鈕
        	.setNeutralButton("沒意見", null) // 不監聽按鈕事件
        	.show(); // 顯示交談窗
	}

    @Override
    public void onClick(DialogInterface dialog, int id) { // 實作監聽介面定義的方法
    	if(id == DialogInterface.BUTTON_POSITIVE) { // 如果按下肯定的『喜歡』
    		txv.setText("你喜歡 Android 手機");
    	}
    	else if(id == DialogInterface.BUTTON_NEGATIVE) { // 如果按下否定的『討厭』
    		txv.setText("你討厭 Android 手機");
    	}
    }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialogask, menu);
		return true;
	}

}
