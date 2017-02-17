package com.notapro.drolle.drolle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by satendra on 2/17/2017.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.MyHolder> {

    private Integer[] mimg;
    private Context mcontext;

    public static class MyHolder extends RecyclerView.ViewHolder {
        public ImageView imView;

        public MyHolder(View itemView) {
            super(itemView);
            imView=(ImageView) itemView.findViewById(R.id.listimage);
        }
    }

    public ImagesAdapter(Integer[] img,Context context){
        mimg=img;
        mcontext=context;
    }

    private Context getContext(){
        return mcontext;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new MyHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Integer temp = mimg[position];
        ImageView im = holder.imView;
        im.setImageResource(temp);
    }

    @Override
    public int getItemCount() {
        return mimg.length;
    }
}
