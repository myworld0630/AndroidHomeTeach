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
	GoogleMap map; // 操控地圖的物件
	int MIN_TIME = 5000; // 位置更新條件：5000 毫秒
	float MIN_DIST = 5; // 位置更新條件：5 公尺
	LocationManager mgr; // 定位管理員

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		System.out.println(0);
		setContentView(R.layout.mymap);

		System.out.println(1);
		
		txv = (TextView) findViewById(R.id.txv);
		mgr = (LocationManager) getSystemService(LOCATION_SERVICE);
		
		// 取得 GoogleMap 物件, 此物件可以操控地圖
		System.out.println(2);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapView)).getMap();
		// 顯示『我的位置』圖示按鈕
		
		System.out.println(3);
		map.setMyLocationEnabled(true);
		// 設定地圖為普通街道模式
		System.out.println(4);
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		// 將地圖縮放級數改為 18
		System.out.println(5);
		map.moveCamera(CameraUpdateFactory.zoomTo(18));
	}

	@Override
	protected void onResume() {
		super.onResume();
		String best = mgr.getBestProvider(new Criteria(), true);
		if (best != null) {
			txv.setText("定位中...");
			mgr.requestLocationUpdates(best, MIN_TIME, MIN_DIST, this);
		} else {
			txv.setText("請確認有開啟定位功能...");
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
		if (location != null) { // 如果可以取得座標
			txv.setText(String.format("緯度 %.4f, 經度 %.4f (%s 定位 )",
					location.getLatitude(), // 目前緯度
					location.getLongitude(), // 目前經度
					location.getProvider()));// 定位方式

			// 將地圖中心點移到目前的經緯度
			map.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(location
					.getLatitude(), location.getLongitude())));
		} else { // 無法取得座標
			txv.setText("暫時無法取得定位資訊...");
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
