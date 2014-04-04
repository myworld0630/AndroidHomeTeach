package com.example.demo.thirdclass;

import java.util.Calendar;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class DateTimePicker extends Activity implements OnClickListener,
		DatePickerDialog.OnDateSetListener, // ��@��ť�����͵��ƥ󪺤���
		TimePickerDialog.OnTimeSetListener {// ��@��ť�ɶ���͵��ƥ󪺤���

	Calendar c = Calendar.getInstance();  //�إߤ�䪫��
    TextView txDate; // �O�������r������
    TextView txTime; // �O���ɶ���r������
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datetimepicker);
		
        txDate = (TextView)findViewById(R.id.textView1); // ��X�����r����
        txTime = (TextView)findViewById(R.id.textView2);
        
        txDate.setOnClickListener(this); //�]�w���U�����r�ɪ���ť����
        txTime.setOnClickListener(this); //�]�w���U�ɶ���r�ɪ���ť����
	}

    @Override
	public void onClick(View v) {
		if(v == txDate) { // �����O�����r
			//�إߤ����ܥ�͵�, �öǤJ�]�w�����ɪ���ť����
	    	new DatePickerDialog(this, this, // �Ѭ��ʪ����ť�ƥ�
	    	    c.get(Calendar.YEAR),  //��Calendar������o�ثe���褸�~
	    	    c.get(Calendar.MONTH),        //���o�ثe�� (�� 0 ��_)
	    	    c.get(Calendar.DAY_OF_MONTH)) //���o�ثe��
	    	.show();  //��ܥX��
		}
		else if(v == txTime) { // �����O�ɶ���r
			//�إ߮ɶ���ܥ�͵�, �öǤJ�]�w�����ɪ���ť����
			new TimePickerDialog(this, this, // �Ѭ��ʪ����ť�ƥ�
				c.get(Calendar.HOUR_OF_DAY), //���o�ثe���� (24�p�ɨ�)
				c.get(Calendar.MINUTE),      //���o�ثe���� 
				true)                        //�ϥ�24�p�ɨ�
			.show();   //��ܥX��
		}
	}

    @Override
    public void onDateSet(DatePicker v, int y, int m, int d) { // ��w����᪺�B�z��k						
    	txDate.setText("����G" + y + "/" + (m+1) + "/" + d); // �N��w�����ܦb�ù��W
	}						   	

    @Override
	public void onTimeSet(TimePicker v, int h, int m) { // ��w����᪺�B�z��k
   		txTime.setText("�ɶ��G" + h + ":" + m); // �N��w���ɶ���ܦb�ù��W     					
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.datetimepicker, menu);
		return true;
	}

}
