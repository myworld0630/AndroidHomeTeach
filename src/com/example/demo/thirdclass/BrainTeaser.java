package com.example.demo.thirdclass;

import com.example.hometeach.R;
import com.example.hometeach.R.id;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class BrainTeaser extends Activity implements OnItemClickListener {

	// �إ߰��D�}�C
		String[] queArr = {"��������������W","����F��S�H�R�Y�H",
				"����ʤ���Y�H","���򥬤����_�H",
				"���򹫳̷R���b�H","�����򤣥Ǫk�H"};
		// �إߵ��װ}�C
	    String[] ansArr = { "�y��", "��", 
	    		"�̥�","�r��",
	    		" ���O�p","����" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brainteaser);
		
        // �إߨ� ListView �ϥΪ� ArrayAdapter ����
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        		this,
        		android.R.layout.simple_list_item_1, // �ϥΤ��ت��G���귽
        		queArr);						// �H queArr �}�C���ƨӷ� 
        
        ListView lv = (ListView)findViewById(R.id.lv);  //���o  ListView 
        lv.setAdapter(adapter);			 //�]�w ListView �ϥΪ� Adapter
        lv.setOnItemClickListener(this); //�]�w ListView ���سQ���ɪ��ƥ��ť��
	}

    @Override
    public void onItemClick(AdapterView<?> a, View v, 
    		int pos, long id) {
		Toast.makeText(this, 
			"���סJ" + ansArr[pos], Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.brainteaser, menu);
		return true;
	}

}
