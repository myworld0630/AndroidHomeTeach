package com.example.demo.fourthclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TextView;

public class HelloSQLite extends Activity {

	static final String db_name = "testDB"; // ��Ʈw�W��
	static final String tb_name = "test"; // ��ƪ�W��
	SQLiteDatabase db; // ��Ʈw

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hellosqlite);

		// �}�ҩΫإ߸�Ʈw
		db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);

		String createTable = "CREATE TABLE IF NOT EXISTS " + tb_name + // ��ƪ�W��
				"(name VARCHAR(32), " + // �m�W���
				"phone VARCHAR(16), " + // �q�����
				"email VARCHAR(64))"; // Email���
		db.execSQL(createTable); // �إ߸�ƪ�

		// ���J 2�����
		addData("Flag Publishing Co.", "02-23963257", "service@flag.com.tw");
		addData("PCDIY Magazine", "02-23214335", "service@pcdiy.com.tw");

		TextView txv = (TextView) findViewById(R.id.txv);
		txv.setText("��Ʈw�ɸ��|: " + db.getPath() + "\n\n"
				+ // ���o����ܸ�Ʈw��T
				"��Ʈw�����j�p: " + db.getPageSize() + " Bytes\n\n" + "��Ʈw�j�p�W��: "
				+ db.getMaximumSize() + " Bytes");

		db.close(); // ������Ʈw

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hellosqlite, menu);
		return true;
	}

	private void addData(String name, String phone, String email) {
		ContentValues cv=new ContentValues(3);	// �إߧt3�Ӹ�ƶ��ت�����
		cv.put("name", name);
		cv.put("phone", phone);
		cv.put("email", email);

		db.insert(tb_name, null, cv);	// �N��ƥ[���ƪ�
	}
}
