package com.notapro.drolle.drolle;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewpageFrag extends Fragment {

    int position =0;
    Handler handler;
    Runnable runnable;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int[] img = {R.drawable.bannerthree,R.drawable.bannertwo,R.drawable.bannerone};
        // Locate the ViewPager
        final ViewPager viewPager = (ViewPager) getView().findViewById(R.id.Pager_view);
        // Pass results to ViewPagerAdapter Class
        PagerAdapter adapter = new ViewPageAdapter(img,getContext());
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);

        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                if( position >= 3){
                    position = 0;
                }else{
                    position = position+1;
                }
                viewPager.setCurrentItem(position, true);
                handler.postDelayed(runnable, 2000);
            }
        };

    }

    @Override
    public void onPause() {
        super.onPause();
        if (handler!= null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 2000);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.viewpage_frag, container, false);
    }

}
