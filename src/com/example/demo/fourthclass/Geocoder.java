package com.example.demo.fourthclass;

import java.util.List;
import java.util.Locale;

import com.example.hometeach.R;

import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Geocoder extends Activity implements LocationListener {

	static final int MIN_TIME = 5000;// ��m��s����G5000 �@��  
	static final float MIN_DIST = 5; // ��m��s����G5 ����     
	LocationManager mgr;    // �w��޲z��                      
	TextView txv;
	Location myLocation;	// �x�s�̪񪺩w����
	android.location.Geocoder  geocoder;		// �ΨӬd�ߦa�}��Geocoder����
	EditText edtLat,edtLon; // �g�n�׿�J���
		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.geocoder);
		
		txv = (TextView) findViewById(R.id.txv);
        // ���o�t�ΪA�Ȫ�LocationManager����
        mgr = (LocationManager)getSystemService(LOCATION_SERVICE);
        edtLat = (EditText) findViewById(R.id.edtLan);
        edtLon = (EditText) findViewById(R.id.edtLon);
        geocoder = new android.location.Geocoder(this,Locale.getDefault());  
	}

	   @Override
		protected void onResume() {
			super.onResume();
			// ���o�̨Ϊ��w�촣�Ѫ�
			String best = mgr.getBestProvider(new Criteria(), true);
			
			if (best != null) { // ���o�֨����̫��m,�p�G������ 
				txv.setText("���o�w���T��...");
				mgr.requestLocationUpdates(best, 
						MIN_TIME, MIN_DIST, this);
			}
			else  // �L���Ѫ�, ��ܴ��ܰT�� 
				txv.setText("�нT�{�w�}�ҩw��\��!");
		}
		
	    @Override
		protected void onPause() {
			super.onPause();
			mgr.removeUpdates(this); 
		}
		
	    @Override 
	    public void onLocationChanged(Location location) { // ��m�ܧ�ƥ� 
	    	myLocation=location;	// �x�s�w����
	    }  
	    
	    @Override 
	    public void onProviderDisabled(String provider) { } 
	    @Override 
	    public void onProviderEnabled(String provider) { } 
	    @Override 
	    public void onStatusChanged(String provider, int status, Bundle extras) { } 

		// ��ܤ���w��]�w�e��
	    public void setup(View v) {
	    	Intent it =	// �ϥ�Intent����Ұ�"�w��"�]�w�{�� 
	        	new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS); 
	        startActivity(it);
	    }
	    
	    public void getLocation(View v) {	// "�H�����m���J"�s��On Click �ƥ�	
	    	if(myLocation!=null){	// �Y��m����Dnull
	    		edtLat.setText(Double.toString(		// �N�g���ন�r��
	    				myLocation.getLatitude()));
	    		edtLon.setText(Double.toString(		// �N�n�׭��ন�r��
	    				myLocation.getLongitude()));
	    	}
	    	else
	    		txv.setText("�L�k���o�w���ơI");
	    }
	    
	    public void onQuery(View view) {	// "�θg�n�׬d�a�}"�s��On Click �ƥ�
	    	String strLat = edtLat.getText().toString();	// ����J���n�צr��
	    	String strLon = edtLon.getText().toString();	// ����J���g�צr��
	    	if(strLat.length() == 0 || strLon.length() == 0) // ��r�ꬰ�ťծ� 
	    		return;										 // �����B�z
	    	
	    	txv.setText("Ū����...");
	    	double latitude = Double.parseDouble(strLat);  // ���o�n�׭�
	    	double longitude = Double.parseDouble(strLon); // ���o�g�׭�

	    	String strAddr = "";	// �Ψӫإߩҭn��ܪ��T���r�� (�a�}�r��) 
	    	try {        	
	    		List<Address> listAddr = geocoder. 
	    				getFromLocation(latitude, longitude,// �θg�n�׬d�a�}
	    								1);	// �u�ݶǦ^1���a�}���

	    		if (listAddr == null || listAddr.size() == 0) 	//�ˬd�O�_�����o�a�}
	    			strAddr += "�L�k���o�a�}���!";
	    		else {
	    			Address addr = listAddr.get(0);	// �� List �����Ĥ@��(�]�O�ߤ@���@��)
	    	    	for (int i = 0; i <= addr.getMaxAddressLineIndex(); i++) 
	    				strAddr += addr.getAddressLine(i) + "\n";
	    		}
	    	} catch (Exception ex) {
	    		strAddr += "���o�a�}�o�Ϳ��~:" + ex.toString();
	    	}
	    	txv.setText(strAddr);
	    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.geocoder, menu);
		return true;
	}

}
