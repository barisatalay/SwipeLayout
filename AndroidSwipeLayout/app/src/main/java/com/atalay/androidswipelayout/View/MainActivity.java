package com.atalay.androidswipelayout.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.atalay.androidswipelayout.Adapter.MainAdapter;
import com.atalay.androidswipelayout.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.main_list)     RecyclerView main_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        loadAdapter();
    }

    private void loadAdapter() {
        List<String> result = new ArrayList<String>();
        for (int i=0;i<25;i++)
            result.add(String.valueOf(i + 1) + ". eleman");

        main_list.setAdapter(new MainAdapter(this,result));
    }

    private void initUi() {
        ButterKnife.inject(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        main_list.setLayoutManager(layoutManager);
        main_list.setHasFixedSize(true);
        main_list.setItemAnimator(new DefaultItemAnimator());

    }
}
