package com.example.demo.thirdclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.widget.TextView;

public class DialogAsk extends Activity implements DialogInterface.OnClickListener { // ��@��ť����

	TextView txv; // �O���w�]�� TextView ����
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogask);
		
        txv = (TextView)findViewById(R.id.answer); // ��X�w�]�� TextView ����
        new AlertDialog.Builder(this) // �إ� Builder ����
        	.setMessage("�A���w Android ����ܡH") // �]�w��ܰT��
        	.setCancelable(false) // �T�Ϊ�^��������͵�
        	.setIcon(android.R.drawable.ic_menu_edit) // �ĥΤ��ت��ϥ�
        	.setTitle("Android �ݨ��լd") // �]�w��͵������D
        	.setPositiveButton("���w", this)  // �[�J�_�w���s
        	.setNegativeButton("�Q��", this) 	// �[�J�֩w���s
        	.setNeutralButton("�S�N��", null) // ����ť���s�ƥ�
        	.show(); // ��ܥ�͵�
	}

    @Override
    public void onClick(DialogInterface dialog, int id) { // ��@��ť�����w�q����k
    	if(id == DialogInterface.BUTTON_POSITIVE) { // �p�G���U�֩w���y���w�z
    		txv.setText("�A���w Android ���");
    	}
    	else if(id == DialogInterface.BUTTON_NEGATIVE) { // �p�G���U�_�w���y�Q���z
    		txv.setText("�A�Q�� Android ���");
    	}
    }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialogask, menu);
		return true;
	}

}
