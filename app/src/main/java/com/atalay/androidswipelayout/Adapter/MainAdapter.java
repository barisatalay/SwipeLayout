package com.atalay.androidswipelayout.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.atalay.androidswipelayout.R;
import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by baris on 31.03.2017.
 */

public class MainAdapter extends RecyclerSwipeAdapter<MainAdapter.ViewHolder> {

    private List<String> allData;
    private Activity mActivity;


    public MainAdapter(Activity mActivity, List<String> allData) {
        this.allData = allData;
        this.mActivity = mActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sample, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        String item = allData.get(i);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        String item = allData.get(i);

        holder.sample_text.setText(item);
        holder.sample_trash_button.setId(i);
    }

    @Override
    public int getItemCount() {
        return (null != allData ? allData.size() : 0);
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.sample_swipe;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.sample_text)           TextView sample_text;
        @InjectView(R.id.sample_trash_button)   ImageButton sample_trash_button;
        @InjectView(R.id.sample_swipe)          SwipeLayout swipeLayout;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);


            swipeLayout.addDrag(SwipeLayout.DragEdge.Right, swipeLayout.findViewWithTag("Bottom2"));

            swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

            swipeLayout.addSwipeListener(new SimpleSwipeListener() {
                @Override
                public void onOpen(SwipeLayout layout) {
                }

                @Override
                public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                    String q = "";
                }
            });
        }

        @OnClick(R.id.sample_trash_button)
        public void onDelete(View view){
            allData.remove(view.getId());

            Toast.makeText(mActivity.getApplicationContext(), String.valueOf(view.getId()) +". pozisyondaki eleman silindi.", Toast.LENGTH_SHORT).show();

            notifyDataSetChanged();
        }
    }


}
