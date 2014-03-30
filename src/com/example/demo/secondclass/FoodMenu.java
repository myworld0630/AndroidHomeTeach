package com.example.demo.secondclass;

import com.example.hometeach.R;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class FoodMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodmenu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foodmenu, menu);
		return true;
	}

    public void takeOrder(View v) {
    	CheckBox chk;
    	String msg="";    
    	// �ΰ}�C�s��Ҧ� CheckBox ���� ID
    	int[] id={R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4}; 

    	for(int i:id){    // �H�j��v�@�˵��U CheckBox �O�_�Q���
    		chk = (CheckBox) findViewById(i);
    		if(chk.isChecked())            // �Y���Q���
    			msg+="\n"+chk.getText();   // �N����r���οﶵ��r
    	}                                  // ���[�� msg �r��᭱

    	if(msg.length()>0) // ���I�\
    		msg ="�A�I�ʪ��\�I�O�G"+msg;
    	else
    		msg ="���I�\!";

    	// �b��r���������I�ʪ�����
    	((TextView) findViewById(R.id.showOrder)).setText(msg);
    }
	
}
