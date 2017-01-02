package com.notapro.drolle.drolle;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by satendra on 12/29/2016.
 */

public class FragmentCheck extends Fragment implements View.OnClickListener{

    FragmentActivity listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button bttoast = (Button) view.findViewById(R.id.btToast);
        bttoast.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.listener = (FragmentActivity)context;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btToast:
                Context context = getActivity().getApplicationContext();
                Toast toast = Toast.makeText(context,"Its working",Toast.LENGTH_LONG);
                toast.show();
                break;
        }

    }
}
