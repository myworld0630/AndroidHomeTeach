package com.example.demo.thirdclass;

import java.util.ArrayList;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListMenu extends Activity implements OnItemClickListener {

	// 儲存目前選取的項目 (餐點) 名稱字串
	ArrayList<String> selected=new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listmenu);
		
		// 取得 ListView 物件, 並設定按下動作的監聽器
		ListView lv=(ListView) findViewById(R.id.lv);
		lv.setOnItemClickListener(this);			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listmenu, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
		TextView txv = (TextView) v; // 將被按下的 View 物件轉成 TextView
		String item=txv.getText().toString();

		if(selected.contains(item)) // 若 ArrayList 已有同名項目
			selected.remove(item);  // 就將它移除
		else                        // 若 ArrayList 沒有同名項目
			selected.add(item);     // 就將它加到 ArrayList (當成選取的項目)  

		String msg="";
		if(selected.size()>0){   // 若 ArrayList 中的項目數大於 0
			msg="你點了:";
			for(String str:selected)
				msg+=" "+str;    // 每個項目 (餐點) 名稱前空一格					                     
		}                        // 並附加到訊息字串後面
		else                     // 若 ArrayList 中的項目數等於 0  
			msg="請點餐!";

		TextView msgTxv=(TextView) findViewById(R.id.msgTxv);
		msgTxv.setText(msg);  // 顯示訊息字串
	}
	
}
