package com.example.demo.secondclass;

import java.util.ArrayList;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class FoodMenuEvent extends Activity implements OnCheckedChangeListener {

	// �Ψ��x�s�w������ت� ID ���X����
	ArrayList<CompoundButton> selected = new ArrayList<CompoundButton>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodmenuevent);

		// �Ҧ��֨���� ID ���}�C
		int[] chk_id = { R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4, R.id.chk5,
				R.id.chk6, R.id.chk7, R.id.chk8 };

		for (int id : chk_id) { // �ΰj����Ҧ��֨�����[�W��ť����
			CheckBox chk = (CheckBox) findViewById(id);
			chk.setOnCheckedChangeListener(this);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foodmenuevent, menu);
		return true;
	}

	public void takeOrder(View v) {
		String msg = ""; // �x�s�T�����r��

		for (CompoundButton i : selected)
			// �H�j��v�@�N����r����
			msg += "\n" + i.getText(); // �ﶵ��r���[�� msg �r��᭱

		if (msg.length() > 0) // ���I�\
			msg = "�A�I�ʪ��\�I�O�G" + msg;
		else
			msg = "���I�\!";

		// �b��r���������I�ʪ�����
		((TextView) findViewById(R.id.showOrder)).setText(msg);
	}

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		if (isChecked == true) // �Y���سQ���
			selected.add(buttonView); // �[�춰�X����
		else
			// �Y���سQ����
			selected.remove(buttonView); // �۶��X������
	}

}
