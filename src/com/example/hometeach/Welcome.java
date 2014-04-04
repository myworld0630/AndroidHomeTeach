package com.example.hometeach;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Welcome extends Activity {

	private View view;
	private boolean flag=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//���ù��]�w
		requestWindowFeature(Window.FEATURE_NO_TITLE); //�������D��
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //�]�w���ù�
		
		setContentView(R.layout.welcome);	//�{���P layout���������Y�N�O�Ѧ��إ�!!
	
		view = findViewById(R.id.welcome);	//��ʦb linear layout �[�@�� id
		
		view.postDelayed(new Runnable() {
			public void run() {
				if(flag==false)
					gotoMain();
				}
		 	},5000); //5������
		
	}

	private void gotoMain(){
		Intent it = new Intent(Welcome.this, ClassMenu.class);	//Intent �Q�n:�Q�n�q Welcome ���� MainActivity
		startActivity(it);
		Welcome.this.finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}