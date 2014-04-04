package com.example.demo.secondclass;

import com.example.hometeach.R;
import com.example.hometeach.R.layout;
import com.example.hometeach.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TempConversion extends Activity implements OnCheckedChangeListener, TextWatcher{

	RadioGroup unit;
	EditText value; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tempconversion);
		
        /////////////////////////////////////////////////////////////////////////////
        unit  = (RadioGroup)findViewById(R.id.unit);  // ���o�y���z���s�s��
        unit.setOnCheckedChangeListener(this);        // �]�w this ����ť��
        
        value = (EditText)  findViewById(R.id.value); // ���o��J���
        value.addTextChangedListener(this);           // �]�w this ����ť��
        /////////////////////////////////////////////////////////////////////////////
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tempconversion, menu);
		return true;
	}

	public void afterTextChanged(Editable arg0) {
		calc();		
	}

	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TextWatcher ��������k, ���B���|�Ψ�
	}

	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TextWatcher ��������k, ���B���|�Ψ�
	}

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		calc();
	}

	protected void calc() {
        // ���o��r���
    	TextView degF = (TextView) findViewById(R.id.degF);
    	TextView degC = (TextView) findViewById(R.id.degC);

    	double f=0, c=0;  // �x�s�ū׭ȴ��⵲�G

    	// �Y��ܿ�J�ؤ�ū�
    	if(unit.getCheckedRadioButtonId()==R.id.unitF){
    		f = Double.parseDouble(
    				value.getText().toString());
    		c = (f-32)*5/9;  // �ؤ� => ���      

    	} else{   // �Y��ܿ�J���ū�
    		c = Double.parseDouble(
    				value.getText().toString());
    		f = c*9/5+32;    // ��� => �ؤ�
    	}

    	degC.setText(String.format("%.1f",c)+  
    			// �۱M�׸귽���J�r��
    			getResources().getString(R.string.charC));
    	degF.setText(String.format("%.1f",f)+
    			getResources().getString(R.string.charF));
    }
	
}
