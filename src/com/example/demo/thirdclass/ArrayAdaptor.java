package com.example.demo.thirdclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ArrayAdaptor extends Activity implements OnItemSelectedListener {

	Spinner drink, temp; // ��ܶ��~���ػP�ū׿ﶵ�� Spinner
	TextView txv; // ��ܭq�椺�e�� TextView
	String[] tempSet1 = { "�B", "�h�B", "��" }; // �T�طū�
	String[] tempSet2 = { "�B", "�h�B" }; // ��طū�

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.arrayadaptor);

		txv = (TextView) findViewById(R.id.order);
		temp = (Spinner) findViewById(R.id.temp); // ��X��ܷūת� Spinner
		drink = (Spinner) findViewById(R.id.drink); // ��X��ܶ��~���ت� Spinner
		drink.setOnItemSelectedListener(this); // �]�w��ť����ƥ�
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.arrayadaptor, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> sv, View v, int pos, long id) {

		String[] tempSet;
		if (pos == 3) // �Y����f�c��
			tempSet = tempSet2; // �ū׿ﶵ�S���y�šz
		else
			tempSet = tempSet1;
		ArrayAdapter<String> tempAd = // �̾ڷū׿ﶵ�إ� ArrayAdapter
		new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, // ���쥴�}�ɪ���ܼ˦�
				tempSet); // �ū׿ﶵ
		tempAd.setDropDownViewResource( // �]�w�U�Կ�檺�ﶵ�˦�
		android.R.layout.simple_spinner_dropdown_item);
		temp.setAdapter(tempAd); // �]�w�ϥ� Adapter ����
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

	// ���s���ƥ�B�z��k
	public void showOrder(View v) {
		// �N���ƦW�٤ηū׿�ܲզ��@�Ӧr��
		String msg = drink.getSelectedItem() + ", " + // ���o���ƦW��
				temp.getSelectedItem(); // ���o���׿ﶵ

		// �N�q�椺�e��ܦb��r�����
		txv.setText(msg);
	}
}
