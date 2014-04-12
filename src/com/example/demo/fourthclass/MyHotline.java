package com.example.demo.fourthclass;

import com.example.hometeach.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MyHotline extends Activity implements
		AdapterView.OnItemClickListener {

	static final String DB_NAME = "HotlineDB";
	static final String TB_NAME = "hotlist";
	static final int MAX = 8;
	static final String[] FROM = new String[] { "name", "phone", "email" };
	SQLiteDatabase db;
	Cursor cur;
	SimpleCursorAdapter adapter;
	EditText etName, etPhone, etEmail;
	Button btInsert, btUpdate, btDelete;
	ListView lv;
	final String tag = MyHotline.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myhotline);

		etName = (EditText) findViewById(R.id.etName);
		etPhone = (EditText) findViewById(R.id.etPhone);
		etEmail = (EditText) findViewById(R.id.etEmail);
		btInsert = (Button) findViewById(R.id.btInsert);
		btUpdate = (Button) findViewById(R.id.btUpdate);
		btDelete = (Button) findViewById(R.id.btDelete);

		// �}�ҩΫإ߸�Ʈw
		db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);

		// �إ߸�ƪ�
		String createTable = "CREATE TABLE IF NOT EXISTS " + TB_NAME
				+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ // �������
				"name VARCHAR(32), " + "phone VARCHAR(16), "
				+ "email VARCHAR(64))";
		db.execSQL(createTable);

		cur = db.rawQuery("SELECT * FROM " + TB_NAME, null); // �d�߸��

		// �Y�d�ߵ��G�O�Ū��h�g�J 2 �����ո��
		if (cur.getCount() == 0) {
			addData("�X�Ф��q", "02-23963257", "service@flag.com.tw");
			addData("�X�T���q", "02-23214335", "service@pcdiy.com.tw");
		}

		adapter = new SimpleCursorAdapter(this, R.layout.item, cur, FROM,
				new int[] { R.id.name, R.id.phone, R.id.email }, 0);

		lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(adapter); // �]�w Adapter
		lv.setOnItemClickListener(this); // �]�w���U�ƥ󪺺�ť��
		requery(); // �I�s�ۭq��k, ���s�d�ߤγ]�w���s���A
	}

	private void addData(String name, String phone, String email) {
		ContentValues cv = new ContentValues(3); // �إߧt 3 ����쪺 ContentValues����
		cv.put(FROM[0], name);
		cv.put(FROM[1], phone);
		cv.put(FROM[2], email);

		db.insert(TB_NAME, null, cv); // �s�W1���O��
	}

	private void update(String name, String phone, String email, int id) {
		ContentValues cv = new ContentValues(3);
		cv.put(FROM[0], name);
		cv.put(FROM[1], phone);
		cv.put(FROM[2], email);

		db.update(TB_NAME, cv, "_id=" + id, null); // ��s id �ҫ������
	}

	private void requery() { // ���s�d�ߪ��ۭq��k
		cur = db.rawQuery("SELECT * FROM " + TB_NAME, null);
		adapter.changeCursor(cur); // ��� Adapter��Cursor
		if (cur.getCount() == MAX) // �w�F�W��, ���ηs�W�s
			btInsert.setEnabled(false);
		else
			btInsert.setEnabled(true);
		btUpdate.setEnabled(false); // ���Χ�s�s
		btDelete.setEnabled(false); // ���ΧR���s
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		cur.moveToPosition(position); // ���� Cursor �ܨϥΪ̿��������
		// Ū�X�m�W,�q��,Email��ƨ����
		etName.setText(cur.getString(cur.getColumnIndex(FROM[0])));
		etPhone.setText(cur.getString(cur.getColumnIndex(FROM[1])));
		etEmail.setText(cur.getString(cur.getColumnIndex(FROM[2])));

		btUpdate.setEnabled(true); // �ҥΧ�s�s
		btDelete.setEnabled(true); // �ҥΧR���s
	}

	public void onInsertUpdate(View v) {
		String nameStr = etName.getText().toString().trim();
		String phoneStr = etPhone.getText().toString().trim();
		String emailStr = etEmail.getText().toString().trim();
		if (nameStr.length() == 0 || // ���@��쪺���e���ŧY��^
				phoneStr.length() == 0 || emailStr.length() == 0)
			return;

		if (v.getId() == R.id.btUpdate) // ����s�s
			update(nameStr, phoneStr, emailStr, cur.getInt(0));
		else
			// ���s�W�s
			addData(nameStr, phoneStr, emailStr);

		requery(); // ��s Cursor ���e
	}

	public void onDelete(View v) { // �R���s��On Click�ƥ��k
		db.delete(TB_NAME, "_id=" + cur.getInt(0), null);
		requery();
	}

	public void call(View v) { // ���q��
		String uri = "tel:" + cur.getString(cur.getColumnIndex(FROM[1]));
		Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		startActivity(it);
	}

	public void mail(View v) { // �H�e�q�l�l��
		String uri = "mailto:" + cur.getString(cur.getColumnIndex(FROM[2]));
		Intent it = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
		startActivity(it);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.myhotline, menu);
		return true;
	}

}
