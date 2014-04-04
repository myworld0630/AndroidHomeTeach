package com.example.demo.thirdclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridViewDemo extends Activity {

	private GridView gridView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridviewdemo);
		findViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gridviewdemo, menu);
		return true;
	}

	private void findViews() {
		gridView = (GridView) findViewById(R.id.gridView);
		gridView.setAdapter(new ImageAdapter(this));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Toast.makeText(GridViewDemo.this, "" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	private class ImageAdapter extends BaseAdapter {
		private Context context;
		private Integer[] images = { R.drawable.p01, R.drawable.p02,
				R.drawable.p03, R.drawable.p04, R.drawable.p05, R.drawable.p06,
				R.drawable.p07, R.drawable.p08, R.drawable.p09, R.drawable.p10,
				R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14,
				R.drawable.p15, R.drawable.p16, R.drawable.p17, R.drawable.p18,
				R.drawable.p19, R.drawable.p20, R.drawable.p21, R.drawable.p22 };

		public ImageAdapter(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			return images.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(context);
				imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			} else {
				imageView = (ImageView) convertView;
			}

			imageView.setImageResource(images[position]);
			return imageView;
		}
	}

}
