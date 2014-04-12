package com.example.demo.thirdclass;

import com.example.hometeach.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

@SuppressWarnings("deprecation")
public class GalleryDemo extends Activity {

	ImageView imageView;
	Gallery gallery;
	
	private Integer[] images = {
			R.drawable.p01, R.drawable.p02, R.drawable.p03, R.drawable.p04, 
			R.drawable.p05, R.drawable.p06, R.drawable.p07
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallerydemo);
		
		findViews();
	}

    private void findViews() {
    	imageView = (ImageView)findViewById(R.id.imageView);
    	gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));

        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	imageView.setImageResource(images[position]);
            }
        });
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gallerydemo, menu);
		return true;
	}

	public class ImageAdapter extends BaseAdapter {
        int galleryItemBackground;
        private Context context;        

        public ImageAdapter(Context c) {
            context = c;
            TypedArray attr = context.obtainStyledAttributes(R.styleable.GalleryDemo);
            galleryItemBackground = attr.getResourceId(
                    R.styleable.GalleryDemo_android_galleryItemBackground, 0);
            attr.recycle();
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
                 imageView.setLayoutParams(new Gallery.LayoutParams(500, 500));
                 imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                 imageView.setBackgroundResource(galleryItemBackground);
             } else {
                 imageView = (ImageView)convertView;
             }
             imageView.setImageResource(images[position]);
             return imageView;
        }
    }
	
}
