package com.notapro.drolle.drolle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by satendra on 2/17/2017.
 */

public class ImagesAdapter extends ArrayAdapter<String> {
    private Activity mcontext;
    private ArrayList<Bitmap> mimages;
    public ImagesAdapter(Context context, ArrayList<String> listOfValues, ArrayList<Bitmap> images) {
        super(context, );
    }
}
