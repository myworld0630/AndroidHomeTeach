package com.example.demo.thirdclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class BrainTeaser2 extends Activity implements OnItemClickListener {

	// 建立問題陣列
	String[] queArr = {"什麼門遠永關不上","什麼東西沒人愛吃？",
			"什麼瓜不能吃？","什麼布切不斷？",
			"什麼鼠最愛乾淨？","偷什麼不犯法？"};
	// 建立答案陣列
	String[] ansArr = { "球門", "虧", 
			"傻瓜","瀑布",
			" 環保署","偷笑"};
	Toast tos; // 宣告 Toast 物件
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brainteaser2);
		
		// 建立供 ListView 使用的 ArrayAdapter 物件
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_list_item_1, // 使用內建的佈局資源
				queArr);						// 以 queArr 陣列當資料來源 

		ListView lv = (ListView)findViewById(R.id.lv);  //取得  ListView 
		lv.setAdapter(adapter);			 //設定 ListView 使用的 Adapter
		lv.setOnItemClickListener(this); //設定 ListView 項目被按時的事件監聽器
		tos = Toast.makeText(this, "", Toast.LENGTH_SHORT); //建立 Toast 物件
	}

	@Override
	public void onItemClick(AdapterView<?> a, View v, 
			int pos, long id) {
		tos.setText("答案︰"+ansArr[pos]);  // 變更 Toast 物件的文字內容
		tos.show();                   // 立即重新顯示
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.brainteaser2, menu);
		return true;
	}

}
