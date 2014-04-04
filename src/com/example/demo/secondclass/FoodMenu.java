package com.example.demo.secondclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class FoodMenu extends Activity {

	int a = 50;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodmenu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foodmenu, menu);
		return true;
	}

    public void takeOrder(View v) {
    	CheckBox chk;
    	String msg="";    
    	// 用陣列存放所有 CheckBox 元件的 ID
    	int[] id={R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4}; 

    	for(int i:id){    // 以迴圈逐一檢視各 CheckBox 是否被選取
    		
    		chk = (CheckBox) findViewById(i);
    		if(chk.isChecked()){
    			if(i == R.id.chk1)
    				msg += "\n" + chk.getText() + "(" + a + "元)";   // 將換行字元及選項文字
    		}
    		
    	}                                  // 附加到 msg 字串後面

    	if(msg.length()>0) // 有點餐
    		msg ="你點購的餐點是："+msg;
    	else
    		msg ="請點餐!";

    	// 在文字方塊中顯示點購的項目
    	((TextView) findViewById(R.id.showOrder)).setText(msg);
    }
	
}
