package com.example.subba.gridview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        public int getCount() {
            return mThumbIds.length;
        }
        public Object getItem(int position) {
            return mThumbIds[position];
        }
        public long getItemId(int position) {
            return 0;
        }
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(100, 120));
                imageView.setScaleType(ImageView.ScaleType.FIT_START);
                imageView.setPadding(8, 8, 8, 8);
            }
            else{
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        private Integer[] mThumbIds = {
                R.mipmap.ic_ginger, R.mipmap.sample_3,
                R.mipmap.sample_4, R.mipmap.sample_5,
                R.mipmap.sample_6, R.mipmap.sample_7,

        };
    }

}
