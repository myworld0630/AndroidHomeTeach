package com.example.hometeach;

import com.example.hometeach.R;

import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class firstClass extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstclass);

		/////////////////////////////////////////////////////////////////////
		Button button = (Button) findViewById(R.id.Button02);
		button.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(firstClass.this, classMenu.class);
				startActivity(intent);
				firstClass.this.finish();
			}
		});
		/////////////////////////////////////////////////////////////////////
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("�����r�ܤj");	//�i�H�b LogCat���J tag:system.out �����T��
				TextView textView = (TextView) findViewById(R.id.TextView02);
				System.out.println(textView.getTextSize());
				textView.setTextSize(35);
			}
		});
		/////////////////////////////////////////////////////////////////////
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("���o���r���e");
				EditText editText = (EditText) findViewById(R.id.editText1);
				TextView textView = (TextView) findViewById(R.id.textView1);
				textView.setText(textView.getText()+editText.getText().toString());
			}
		});
		/////////////////////////////////////////////////////////////////////
		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnLongClickListener(new Button.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("�����_��");
				Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				vb.vibrate(500); //�_��500ms
				vb.cancel(); //�����_��
				return true;
			}
		});
		/////////////////////////////////////////////////////////////////////
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);	//���ܼ����e��
				//intent.setAction(Intent.ACTION_CALL);	//���������q��
				intent.setData(Uri.parse("tel:0800080123"));
				startActivity(intent);
				//firstClass.this.finish();	//�p�G���o���A�� backky �u���^���D�e��
			}
		});
		/////////////////////////////////////////////////////////////////////
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.firstclass, menu);
		return true;
	}
	
	
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
        	Intent intent = new Intent();
			intent.setClass(firstClass.this, classMenu.class);
			startActivity(intent);
			firstClass.this.finish();
            return true;
        }
        
        return super.onKeyDown(keyCode, event);
    }
	
}
