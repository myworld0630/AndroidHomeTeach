package com.example.demo.fourthclass;

import com.example.hometeach.R;

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
import android.widget.TextView;

public class SimpleLocation extends Activity implements LocationListener {

	static final int MIN_TIME = 5000;// ��m��s����G5000 �@��
	static final float MIN_DIST = 5; // ��m��s����G5 ����
	LocationManager mgr; // �w���`��
	TextView txv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplelocation);

		txv = (TextView) findViewById(R.id.txv);
		// ���o�t�ΪA�Ȫ�LocationManager����
		mgr = (LocationManager) getSystemService(LOCATION_SERVICE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// ���o�̨Ϊ��w�촣�Ѫ�
		String best = mgr.getBestProvider(new Criteria(), true);
		if (best != null) { // ���o�֨����̫��m,�p�G������
			txv.setText("���o�w���T��...");
			mgr.requestLocationUpdates(best, // ���U��m�ƥ��ť��
					MIN_TIME, MIN_DIST, this);
		} else { // �L���Ѫ�, ��ܴ��ܰT��
			txv.setText("�нT�{�w�}�ҩw��\��!");
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		mgr.removeUpdates(this); // �����ť��m�ƥ�
	}

	@Override
	public void onLocationChanged(Location location) { // ��m�ܧ�ƥ�
		String str = "�w�촣�Ѫ�:" + location.getProvider();
		str += String.format("\n�n��:%.6f\n�g��:%.6f\n����:%.2f����",
				location.getLatitude(), // �n��
				location.getLongitude(), // �g��
				location.getAltitude()); // ����
		txv.setText(str);
	}

	@Override
	public void onProviderDisabled(String provider) {
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	// ��ܤ�����w��]�w�e��
	public void setup(View v) {
		Intent it = // �ϥ�Intent����Ұ�"�w��"�]�w�{��
		new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		startActivity(it);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simplelocation, menu);
		return true;
	}

}
