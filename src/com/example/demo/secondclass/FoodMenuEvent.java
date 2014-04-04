package com.example.demo.secondclass;

import java.util.ArrayList;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class FoodMenuEvent extends Activity implements OnCheckedChangeListener {

	// 用來儲存已選取項目的 ID 集合物件
	ArrayList<CompoundButton> selected = new ArrayList<CompoundButton>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodmenuevent);

		// 所有核取方塊 ID 的陣列
		int[] chk_id = { R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4, R.id.chk5,
				R.id.chk6, R.id.chk7, R.id.chk8 };

		for (int id : chk_id) { // 用迴圈替所有核取方塊加上監聽物件
			CheckBox chk = (CheckBox) findViewById(id);
			chk.setOnCheckedChangeListener(this);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foodmenuevent, menu);
		return true;
	}

	public void takeOrder(View v) {
		String msg = ""; // 儲存訊息的字串

		for (CompoundButton i : selected)
			// 以迴圈逐一將換行字元及
			msg += "\n" + i.getText(); // 選項文字附加到 msg 字串後面

		if (msg.length() > 0) // 有點餐
			msg = "你點購的餐點是：" + msg;
		else
			msg = "請點餐!";

		// 在文字方塊中顯示點購的項目
		((TextView) findViewById(R.id.showOrder)).setText(msg);
	}

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		if (isChecked == true) // 若項目被選取
			selected.add(buttonView); // 加到集合之中
		else
			// 若項目被取消
			selected.remove(buttonView); // 自集合中移除
	}

}
