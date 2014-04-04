package com.example.demo.secondclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class FoodImgMenu extends Activity implements OnCheckedChangeListener {

	int items = 0; // �O���ثe����\�I���ƶq

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodimgmenu);

		int[] chk_id = { R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4 };
		for (int id : chk_id)
			((CheckBox) findViewById(id)).setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foodimgmenu, menu);
		return true;
	}

	public void onCheckedChanged(CompoundButton chk, boolean isChecked) {
		int visible;
		if (isChecked) { // �Q�����
			items++; // �ƶq�[ 1
			visible = View.VISIBLE; // �N�Ϥ��]���i��
		} else { // �Q������
			items--; // �ƶq�� 1
			visible = View.GONE; // �N�Ϥ��]�����i��
		}

		switch (chk.getId()) { // �̶��� ID, �M�w�n��諸 ImageView ID
		case R.id.chk1:
			findViewById(R.id.output1).setVisibility(visible);
			break;
		case R.id.chk2:
			findViewById(R.id.output2).setVisibility(visible);
			break;
		case R.id.chk3:
			findViewById(R.id.output3).setVisibility(visible);
			break;
		case R.id.chk4:
			findViewById(R.id.output4).setVisibility(visible);
			break;
		}

		TextView msg = (TextView) findViewById(R.id.msg);
		if (items > 0) // ������ؤj�� 0, ��ܦ��I�\���T��
			msg.setText("�A�I���\�I�p�U");
		else
			// �_�h��ܽ��I�\���T��
			msg.setText("���I�\!");
	}

}
