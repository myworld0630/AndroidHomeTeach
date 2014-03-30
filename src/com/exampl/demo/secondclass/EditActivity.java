package com.exampl.demo.secondclass;

import com.example.hometeach.R;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends Activity {

	TextView txv;
	EditText edt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityedit);
        
        Intent it = getIntent();               //���o�ǤJ�� Intent ����
        int no = it.getIntExtra("�s��", 0);    //Ū�X�W�� "�s��" �� Int ���, �Y�S���h�Ǧ^ 0
        String s = it.getStringExtra("�Ƨ�");  //Ū�X�W�� "�Ƨ�" �� String ���

        txv = (TextView)findViewById(R.id.textView1);
        txv.setText(s.substring(0, 2));                 //�b�e�����W����ܽs��
        edt = (EditText)findViewById(R.id.editText1);
        if(s.length() > 3)                     
        	edt.setText(s.substring(3)); //�N�ǨӪ��ƧѸ�ƥh���e3�Ӧr, �M���J�s�褸��
	}

    public void onCancel(View v) {  //�������s��
    	setResult(RESULT_CANCELED); // �Ǧ^�N����������G�X
    	finish();    //��������
    }
    public void onSave(View v) {    //���x�s�s��
    	Intent it2 = new Intent();
    	it2.putExtra("�Ƨ�", txv.getText() + " " + edt.getText()); // ���[���ؽs���P�ק�᪺���e
    	setResult(RESULT_OK, it2); // �Ǧ^�N���\�����G�X, �H�έק諸���
    	finish();    //��������
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit, menu);
		return true;
	}

}
