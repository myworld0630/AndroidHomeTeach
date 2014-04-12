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

	static final int MIN_TIME = 5000;// 位置更新條件：5000 毫秒  
	static final float MIN_DIST = 5; // 位置更新條件：5 公尺     
	LocationManager mgr;    // 定位管理員                      
	TextView txv;
	Location myLocation;	// 儲存最近的定位資料
	android.location.Geocoder  geocoder;		// 用來查詢地址的Geocoder物件
	EditText edtLat,edtLon; // 經緯度輸入欄位
		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.geocoder);
		
		txv = (TextView) findViewById(R.id.txv);
        // 取得系統服務的LocationManager物件
        mgr = (LocationManager)getSystemService(LOCATION_SERVICE);
        edtLat = (EditText) findViewById(R.id.edtLan);
        edtLon = (EditText) findViewById(R.id.edtLon);
        geocoder = new android.location.Geocoder(this,Locale.getDefault());  
	}

	   @Override
		protected void onResume() {
			super.onResume();
			// 取得最佳的定位提供者
			String best = mgr.getBestProvider(new Criteria(), true);
			
			if (best != null) { // 取得快取的最後位置,如果有的話 
				txv.setText("取得定位資訊中...");
				mgr.requestLocationUpdates(best, 
						MIN_TIME, MIN_DIST, this);
			}
			else  // 無提供者, 顯示提示訊息 
				txv.setText("請確認已開啟定位功能!");
		}
		
	    @Override
		protected void onPause() {
			super.onPause();
			mgr.removeUpdates(this); 
		}
		
	    @Override 
	    public void onLocationChanged(Location location) { // 位置變更事件 
	    	myLocation=location;	// 儲存定位資料
	    }  
	    
	    @Override 
	    public void onProviderDisabled(String provider) { } 
	    @Override 
	    public void onProviderEnabled(String provider) { } 
	    @Override 
	    public void onStatusChanged(String provider, int status, Bundle extras) { } 

		// 顯示手機定位設定畫面
	    public void setup(View v) {
	    	Intent it =	// 使用Intent物件啟動"定位"設定程式 
	        	new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS); 
	        startActivity(it);
	    }
	    
	    public void getLocation(View v) {	// "以手機位置當輸入"鈕的On Click 事件	
	    	if(myLocation!=null){	// 若位置物件非null
	    		edtLat.setText(Double.toString(		// 將經度轉成字串
	    				myLocation.getLatitude()));
	    		edtLon.setText(Double.toString(		// 將緯度值轉成字串
	    				myLocation.getLongitude()));
	    	}
	    	else
	    		txv.setText("無法取得定位資料！");
	    }
	    
	    public void onQuery(View view) {	// "用經緯度查地址"鈕的On Click 事件
	    	String strLat = edtLat.getText().toString();	// 取輸入的緯度字串
	    	String strLon = edtLon.getText().toString();	// 取輸入的經度字串
	    	if(strLat.length() == 0 || strLon.length() == 0) // 當字串為空白時 
	    		return;										 // 結束處理
	    	
	    	txv.setText("讀取中...");
	    	double latitude = Double.parseDouble(strLat);  // 取得緯度值
	    	double longitude = Double.parseDouble(strLon); // 取得經度值

	    	String strAddr = "";	// 用來建立所要顯示的訊息字串 (地址字串) 
	    	try {        	
	    		List<Address> listAddr = geocoder. 
	    				getFromLocation(latitude, longitude,// 用經緯度查地址
	    								1);	// 只需傳回1筆地址資料

	    		if (listAddr == null || listAddr.size() == 0) 	//檢查是否有取得地址
	    			strAddr += "無法取得地址資料!";
	    		else {
	    			Address addr = listAddr.get(0);	// 取 List 中的第一筆(也是唯一的一筆)
	    	    	for (int i = 0; i <= addr.getMaxAddressLineIndex(); i++) 
	    				strAddr += addr.getAddressLine(i) + "\n";
	    		}
	    	} catch (Exception ex) {
	    		strAddr += "取得地址發生錯誤:" + ex.toString();
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
