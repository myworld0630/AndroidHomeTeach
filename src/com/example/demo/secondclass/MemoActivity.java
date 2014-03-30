package com.example.demo.secondclass;

import com.example.hometeach.R;
import com.example.hometeach.R.id;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class MemoActivity extends Activity implements OnItemClickListener,OnItemLongClickListener{

	String[] aMemo = { // 預設的備忘內容
	"1. 按一下可以編輯備忘", "2. 長按可以清除備忘", "3.", "4.", "5.", "6." };
	ListView lv; // 顯示備忘錄的 ListView
	ArrayAdapter<String> aa; // ListView 與備忘資料的橋樑

	public Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitymemo);

		// //////////////////////////////////////////////////////////////////
		lv = (ListView) findViewById(R.id.listView1);
		aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, aMemo);

		lv.setAdapter(aa); // 設定 listView1 的內容

		// 設定 listView1 被按一下的監聽器
		lv.setOnItemClickListener(this);
		// 設定 listView1 被長按的監聽器
		lv.setOnItemLongClickListener(this);
		// ///////////////////////////////////////////////////////////////////
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.memo, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
		Intent it = new Intent(this, EditActivity.class);
		it.putExtra("備忘", aMemo[pos]); // 附加備忘項目的內容
		startActivityForResult(it, pos); // 啟動 Edit 並以項目位置為識別碼
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> a, View v, int pos, long id) {
		aMemo[pos] = (pos + 1) + "."; // 將內容清除 (只剩編號)
		aa.notifyDataSetChanged(); // 通知 Adapter 要更新陣列內容
		return true; // 傳回 true 表示此事件已處理
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent it) {
		if (resultCode == RESULT_OK) {
			aMemo[requestCode] = it.getStringExtra("備忘"); // 使用傳回的資料更新陣列內容
			aa.notifyDataSetChanged(); // 通知 Adapter 陣列內容有更新
		}
	}
}
