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

	static final int MIN_TIME = 5000;// 位置更新條件：5000 毫秒
	static final float MIN_DIST = 5; // 位置更新條件：5 公尺
	LocationManager mgr; // 定位總管
	TextView txv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplelocation);

		txv = (TextView) findViewById(R.id.txv);
		// 取得系統服務的LocationManager物件
		mgr = (LocationManager) getSystemService(LOCATION_SERVICE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 取得最佳的定位提供者
		String best = mgr.getBestProvider(new Criteria(), true);
		if (best != null) { // 取得快取的最後位置,如果有的話
			txv.setText("取得定位資訊中...");
			mgr.requestLocationUpdates(best, // 註冊位置事件監聽器
					MIN_TIME, MIN_DIST, this);
		} else { // 無提供者, 顯示提示訊息
			txv.setText("請確認已開啟定位功能!");
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		mgr.removeUpdates(this); // 停止監聽位置事件
	}

	@Override
	public void onLocationChanged(Location location) { // 位置變更事件
		String str = "定位提供者:" + location.getProvider();
		str += String.format("\n緯度:%.6f\n經度:%.6f\n高度:%.2f公尺",
				location.getLatitude(), // 緯度
				location.getLongitude(), // 經度
				location.getAltitude()); // 高度
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

	// 顯示手機的定位設定畫面
	public void setup(View v) {
		Intent it = // 使用Intent物件啟動"定位"設定程式
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
