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

	// �x�s�ثe��������� (�\�I) �W�٦r��
	ArrayList<String> selected=new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listmenu);
		
		// ���o ListView ����, �ó]�w���U�ʧ@����ť��
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
		TextView txv = (TextView) v; // �N�Q���U�� View �����ন TextView
		String item=txv.getText().toString();

		if(selected.contains(item)) // �Y ArrayList �w���P�W����
			selected.remove(item);  // �N�N������
		else                        // �Y ArrayList �S���P�W����
			selected.add(item);     // �N�N���[�� ArrayList (�����������)  

		String msg="";
		if(selected.size()>0){   // �Y ArrayList �������ؼƤj�� 0
			msg="�A�I�F:";
			for(String str:selected)
				msg+=" "+str;    // �C�Ӷ��� (�\�I) �W�٫e�Ť@��					                     
		}                        // �ê��[��T���r��᭱
		else                     // �Y ArrayList �������ؼƵ��� 0  
			msg="���I�\!";

		TextView msgTxv=(TextView) findViewById(R.id.msgTxv);
		msgTxv.setText(msg);  // ��ܰT���r��
	}
	
}
