package com.notapro.drolle.drolle;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by satendra on 2/16/2017.
 */

public class ViewPageAdapter extends PagerAdapter {

    int[] image;
    Context con;
    LayoutInflater inflater;

    @Override
    public int getCount() {
        return 3;
    }

    public ViewPageAdapter(int[] img,Context context){
        this.image=img;
        this.con= context;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        ImageView imgflag;

        inflater = (LayoutInflater) con
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewp_item, container,
                false);

        // Locate the ImageView in viewpager_item.xml
        imgflag = (ImageView) itemView.findViewById(R.id.ImageItem);
        // Capture position and set to the ImageView
        imgflag.setImageResource(image[position]);

        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((LinearLayout) object);

    }
}
