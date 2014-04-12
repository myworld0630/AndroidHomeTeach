package com.example.demo.fourthclass;

import com.example.hometeach.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MyMap extends Activity implements LocationListener {

	TextView txv;
	GoogleMap map; // �ޱ��a�Ϫ�����
	int MIN_TIME = 5000; // ��m��s����G5000 �@��
	float MIN_DIST = 5; // ��m��s����G5 ����
	LocationManager mgr; // �w��޲z��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		System.out.println(0);
		setContentView(R.layout.mymap);

		System.out.println(1);
		
		txv = (TextView) findViewById(R.id.txv);
		mgr = (LocationManager) getSystemService(LOCATION_SERVICE);
		
		// ���o GoogleMap ����, ������i�H�ޱ��a��
		System.out.println(2);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapView)).getMap();
		// ��ܡy�ڪ���m�z�ϥܫ��s
		
		System.out.println(3);
		map.setMyLocationEnabled(true);
		// �]�w�a�Ϭ����q��D�Ҧ�
		System.out.println(4);
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		// �N�a���Y��żƧאּ 18
		System.out.println(5);
		map.moveCamera(CameraUpdateFactory.zoomTo(18));
	}

	@Override
	protected void onResume() {
		super.onResume();
		String best = mgr.getBestProvider(new Criteria(), true);
		if (best != null) {
			txv.setText("�w�줤...");
			mgr.requestLocationUpdates(best, MIN_TIME, MIN_DIST, this);
		} else {
			txv.setText("�нT�{���}�ҩw��\��...");
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		mgr.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		if (location != null) { // �p�G�i�H���o�y��
			txv.setText(String.format("�n�� %.4f, �g�� %.4f (%s �w�� )",
					location.getLatitude(), // �ثe�n��
					location.getLongitude(), // �ثe�g��
					location.getProvider()));// �w��覡

			// �N�a�Ϥ����I����ثe���g�n��
			map.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(location
					.getLatitude(), location.getLongitude())));
		} else { // �L�k���o�y��
			txv.setText("�ȮɵL�k���o�w���T...");
		}
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mymap, menu);
		return true;
	}

}
