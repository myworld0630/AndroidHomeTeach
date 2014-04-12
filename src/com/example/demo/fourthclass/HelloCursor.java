package com.example.demo.fourthclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TextView;

public class HelloCursor extends Activity {

	static final String db_name = "testDB"; // 資料庫名稱
	static final String tb_name = "test"; // 資料表名稱
	SQLiteDatabase db; // 資料庫

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hellocursor);

		// 開啟或建立資料庫
		db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
		// db.delete(tb_name, null,null);
		String createTable = "CREATE TABLE IF NOT EXISTS " + tb_name
				+ "(name VARCHAR(32), " + "phone VARCHAR(16), "
				+ "email VARCHAR(64))";
		db.execSQL(createTable); // 建立資料表

		Cursor c = db.rawQuery("SELECT * FROM " + tb_name, null); // 查詢tb_name資料表中的所有資料
		if (c.getCount() == 0) { // 若無資料, 則立即新增 2筆資料
			addData("Flag Publishing Co.", "02-23963257", "service@flag.com.tw");
			addData("PCDIY Magazine", "02-23214335", "service@pcdiy.com.tw");
			c = db.rawQuery("SELECT * FROM " + tb_name, null); // 重新查詢
		}

		if (c.getCount() > 0) { // 若有資料
			String str = "總共有 " + c.getCount() + "筆資料\n";
			str += "-----\n";

			c.moveToFirst(); // 移到第 1 筆資料
			do { // 逐筆讀出資料
				str += "name:" + c.getString(0) + "\n";
				str += "phone:" + c.getString(1) + "\n";
				str += "email:" + c.getString(2) + "\n";
				str += "-----\n";
			} while (c.moveToNext()); // 有一下筆就繼續迴圈

			TextView txv = (TextView) findViewById(R.id.txv);
			txv.setText(str);
		}

		db.close(); // 關閉資料庫
	}

	private void addData(String name, String phone, String email) {
		ContentValues cv = new ContentValues(3);
		cv.put("name", name);
		cv.put("phone", phone);
		cv.put("email", email);

		db.insert(tb_name, null, cv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_cursor, menu);
		return true;
	}

}
