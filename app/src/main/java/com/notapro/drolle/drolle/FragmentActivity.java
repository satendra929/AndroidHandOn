package com.notapro.drolle.drolle;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

public class FragmentActivity extends AppCompatActivity {

    Integer [] imgid={R.drawable.foodone,R.drawable.foodthree,R.drawable.foodtwo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ImagesAdapter adapter = new ImagesAdapter(imgid,this);
        RecyclerView list = (RecyclerView) findViewById(R.id.ImageListView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder,new ViewpageFrag());
        ft.commit();


    }
}
