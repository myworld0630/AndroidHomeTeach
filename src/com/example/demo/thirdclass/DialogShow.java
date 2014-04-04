package com.example.demo.thirdclass;

import com.example.hometeach.R;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;

public class DialogShow extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogshow);
		
        AlertDialog.Builder bdr = new AlertDialog.Builder(this);
        bdr.setMessage("��͵��ܽd�оǡI\n" // �[�J��r�T��
        				+ "�Ы���^��������͵�");
        bdr.setTitle("�w��");        // �[�J���D                  
        bdr.setIcon(android.R.drawable.presence_away); // �[�J�ϥ�
        bdr.setCancelable(true);   // ���\����^��������͵�
        bdr.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialogshow, menu);
		return true;
	}

}
