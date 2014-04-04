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

	String[] aMemo = { // �w�]���ƧѤ��e
	"1. ���@�U�i�H�s��Ƨ�", "2. �����i�H�M���Ƨ�", "3.", "4.", "5.", "6." };
	ListView lv; // ��ܳƧѿ��� ListView
	ArrayAdapter<String> aa; // ListView �P�ƧѸ�ƪ�����

	public Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitymemo);

		// //////////////////////////////////////////////////////////////////
		lv = (ListView) findViewById(R.id.listView1);
		aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, aMemo);

		lv.setAdapter(aa); // �]�w listView1 �����e

		// �]�w listView1 �Q���@�U����ť��
		lv.setOnItemClickListener(this);
		// �]�w listView1 �Q��������ť��
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
		it.putExtra("�Ƨ�", aMemo[pos]); // ���[�ƧѶ��ت����e
		startActivityForResult(it, pos); // �Ұ� Edit �åH���ئ�m���ѧO�X
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> a, View v, int pos, long id) {
		aMemo[pos] = (pos + 1) + "."; // �N���e�M�� (�u�ѽs��)
		aa.notifyDataSetChanged(); // �q�� Adapter �n��s�}�C���e
		return true; // �Ǧ^ true ��ܦ��ƥ�w�B�z
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent it) {
		if (resultCode == RESULT_OK) {
			aMemo[requestCode] = it.getStringExtra("�Ƨ�"); // �ϥζǦ^����Ƨ�s�}�C���e
			aa.notifyDataSetChanged(); // �q�� Adapter �}�C���e����s
		}
	}
}
