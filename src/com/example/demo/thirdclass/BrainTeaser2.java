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

	// �إ߰��D�}�C
	String[] queArr = {"��������������W","����F��S�H�R�Y�H",
			"����ʤ���Y�H","���򥬤����_�H",
			"���򹫳̷R���b�H","�����򤣥Ǫk�H"};
	// �إߵ��װ}�C
	String[] ansArr = { "�y��", "��", 
			"�̥�","�r��",
			" ���O�p","����"};
	Toast tos; // �ŧi Toast ����
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brainteaser2);
		
		// �إߨ� ListView �ϥΪ� ArrayAdapter ����
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_list_item_1, // �ϥΤ��ت��G���귽
				queArr);						// �H queArr �}�C���ƨӷ� 

		ListView lv = (ListView)findViewById(R.id.lv);  //���o  ListView 
		lv.setAdapter(adapter);			 //�]�w ListView �ϥΪ� Adapter
		lv.setOnItemClickListener(this); //�]�w ListView ���سQ���ɪ��ƥ��ť��
		tos = Toast.makeText(this, "", Toast.LENGTH_SHORT); //�إ� Toast ����
	}

	@Override
	public void onItemClick(AdapterView<?> a, View v, 
			int pos, long id) {
		tos.setText("���סJ"+ansArr[pos]);  // �ܧ� Toast ���󪺤�r���e
		tos.show();                   // �ߧY���s���
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.brainteaser2, menu);
		return true;
	}

}
