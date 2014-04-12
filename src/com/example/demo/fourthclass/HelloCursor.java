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

	static final String db_name = "testDB"; // ��Ʈw�W��
	static final String tb_name = "test"; // ��ƪ�W��
	SQLiteDatabase db; // ��Ʈw

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hellocursor);

		// �}�ҩΫإ߸�Ʈw
		db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
		// db.delete(tb_name, null,null);
		String createTable = "CREATE TABLE IF NOT EXISTS " + tb_name
				+ "(name VARCHAR(32), " + "phone VARCHAR(16), "
				+ "email VARCHAR(64))";
		db.execSQL(createTable); // �إ߸�ƪ�

		Cursor c = db.rawQuery("SELECT * FROM " + tb_name, null); // �d��tb_name��ƪ����Ҧ����
		if (c.getCount() == 0) { // �Y�L���, �h�ߧY�s�W 2�����
			addData("Flag Publishing Co.", "02-23963257", "service@flag.com.tw");
			addData("PCDIY Magazine", "02-23214335", "service@pcdiy.com.tw");
			c = db.rawQuery("SELECT * FROM " + tb_name, null); // ���s�d��
		}

		if (c.getCount() > 0) { // �Y�����
			String str = "�`�@�� " + c.getCount() + "�����\n";
			str += "-----\n";

			c.moveToFirst(); // ����� 1 �����
			do { // �v��Ū�X���
				str += "name:" + c.getString(0) + "\n";
				str += "phone:" + c.getString(1) + "\n";
				str += "email:" + c.getString(2) + "\n";
				str += "-----\n";
			} while (c.moveToNext()); // ���@�U���N�~��j��

			TextView txv = (TextView) findViewById(R.id.txv);
			txv.setText(str);
		}

		db.close(); // ������Ʈw
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
