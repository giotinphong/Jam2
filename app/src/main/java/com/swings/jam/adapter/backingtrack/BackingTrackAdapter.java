package com.swings.jam.adapter.backingtrack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swings.jam.R;
import com.swings.jam.data.BackingTrack;

import java.util.ArrayList;

/**
 * Created by sonnguyen on 7/11/17.
 */

public class BackingTrackAdapter extends RecyclerView.Adapter<BackingTrackViewHolder> {
    ArrayList<BackingTrack> backingTrackArrayList = new ArrayList<>();
    Context context;
    private boolean isNull = false;
    public BackingTrackAdapter(ArrayList<BackingTrack> backingTrackArrayList, Context context) {
        this.backingTrackArrayList = backingTrackArrayList;
        this.context = context;
        //add null backing track
        if(backingTrackArrayList.size()==0){
            isNull = true;
        }
        backingTrackArrayList.add(new BackingTrack());
    }

    @Override
    public BackingTrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_backingtrack,parent,false);
        return new BackingTrackViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BackingTrackViewHolder holder, int position) {
        if(isNull&&backingTrackArrayList.size()==1){
            holder.imgAvatar.setBackgroundResource(R.drawable.dotted);
            holder.imgAvatar.setGravity(Gravity.CENTER);
            holder.txtCount.setVisibility(View.INVISIBLE);
            holder.txtName.setText("Bạn chưa có bản jam nào");
        }
        else{
            if(position == backingTrackArrayList.size()-1){
                //go to finally of list, create button xem them
                holder.imgAvatar.setBackgroundResource(R.drawable.dotted);
                holder.imgAvatar.setGravity(Gravity.CENTER);
                holder.txtCount.setVisibility(View.INVISIBLE);
                holder.txtName.setText("Xem thêm");
                holder.txtName.setTextColor(context.getResources().getColor(R.color.text_black));
                holder.txtName.setBackgroundColor(context.getResources().getColor(R.color.no_color));
            }
            else{
                BackingTrack backingTrack = backingTrackArrayList.get(position);
                holder.txtName.setText(backingTrack.getName());
                holder.txtCount.setText(backingTrack.getCount()+"");
            }
        }

    }

    @Override
    public int getItemCount() {
        return backingTrackArrayList.size();
    }
}
