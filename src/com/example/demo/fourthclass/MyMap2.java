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
import android.provider.Settings;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MyMap2 extends Activity implements LocationListener {

	TextView txv;
	GoogleMap map; // �ޱ��a�Ϫ�����
	int MIN_TIME = 5000; // ��m��s����G5000 �@��
	float MIN_DIST = 5; // ��m��s����G5 ����
	LocationManager mgr; // �w��޲z��

	boolean isSatellite = false; // �O�_��ܽìP��
	boolean isTraffic = false; // �O�_��ܥ�q��
	LatLng currPoint; // �x�s�ثe����m

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mymap2);

		txv = (TextView) findViewById(R.id.txv);
		mgr = (LocationManager) getSystemService(LOCATION_SERVICE);

		// ���o GoogleMap ����, ������i�H�ޱ��a��
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapView)).getMap();
		// ��ܡy�ڪ���m�z�ϥܫ��s
		map.setMyLocationEnabled(true);
		// �]�w�a�Ϭ����q��D�Ҧ�
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		// �N�a���Y��żƧאּ 18
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
			currPoint = new LatLng(location.getLatitude(),
					location.getLongitude());
			map.animateCamera(CameraUpdateFactory.newLatLng(currPoint));
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
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) { // �̷ӿﶵ�� id �ӳB�z
		case R.id.satellite:
			isSatellite = !isSatellite; // �����O�_��ܽìP��
			item.setChecked(isSatellite); // �����\����ت����Ī��A
			if (isSatellite) // �]�w�O�_��ܽìP��
				map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			else
				map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			break;
		case R.id.traffic:
			isTraffic = !isTraffic; // �����O�_��ܥ�q��
			item.setChecked(isTraffic); // �����\����ت����Ī��A
			map.setTrafficEnabled(isTraffic); // �]�w�O�_��ܥ�q��
			break;
		case R.id.currLoction:
			map.animateCamera( // �b�a�Ϥ����ʨ�ثe��m
			CameraUpdateFactory.newLatLng(currPoint));
			break;
		case R.id.setGPS:
			Intent i = new Intent( // �Q�� Intent �Ұʨt�Ϊ��w��A�ȳ]�w
					Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			startActivity(i);
			break;
		case R.id.about:
			new AlertDialog.Builder(this)
					// �Υ�͵���ܵ{�������P���v�n��
					.setTitle("���� �ڪ��a��")
					.setMessage("�ڪ��a�� ���窩 v1.0\nCopyright 2014 Flag Corp.")
					.setPositiveButton("����", null).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mymap2, menu);
		return true;
	}

}
