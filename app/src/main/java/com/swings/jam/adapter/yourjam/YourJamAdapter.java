package com.swings.jam.adapter.yourjam;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swings.jam.R;
import com.swings.jam.data.BackingTrack;
import com.swings.jam.data.DataHelper;
import com.swings.jam.data.Type;
import com.swings.jam.data.TypeSon;
import com.swings.jam.data.YourJam;

import java.util.ArrayList;

/**
 * Created by sonnguyen on 7/12/17.
 */

public class YourJamAdapter extends RecyclerView.Adapter<YourJamHolder> {
    ArrayList<YourJam> yourJamArrayList = new ArrayList<>();
    Context context;
    private boolean isNull = false;
    public YourJamAdapter(ArrayList<YourJam> yourJamArrayList, Context context) {
        this.yourJamArrayList = yourJamArrayList;
        this.context = context;
        if(yourJamArrayList.size()==0){
            isNull = true;
        }
        yourJamArrayList.add(new YourJam());

    }

    @Override
    public YourJamHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new YourJamHolder(v);
    }

    @Override
    public void onBindViewHolder(YourJamHolder holder, int position) {
        if(isNull&&yourJamArrayList.size()==1){
            holder.imgAvatar.setImageResource(R.drawable.dotted);
            holder.txtDes.setVisibility(View.INVISIBLE);
            holder.txtName.setText("Thu âm ngay");
            holder.txtDes.setText("Chưa có bản Jam nào");
        }
        else {
            if (position == yourJamArrayList.size() - 1) {
                holder.imgAvatar.setImageResource(R.drawable.dotted);
                holder.txtDes.setVisibility(View.INVISIBLE);
                holder.txtName.setText("Xem tất cả");
            } else {
                YourJam jam = yourJamArrayList.get(position);
                holder.txtName.setText(jam.getName());
                DataHelper dataHelper = new DataHelper(context);
                //get name of backing track
                BackingTrack backingTrack = dataHelper.getBackingTrackById(jam.getIdBackingTrack());
                String name_backingtrack = "Nguồn"+backingTrack.getName();
                holder.txtDes.setText(name_backingtrack);
                Drawable drawable;
                TypeSon typeSon = dataHelper.getTypeSonById(backingTrack.getId_typeson());
                if(typeSon!=null){
                    drawable = context.getResources().getDrawable(typeSon.getImage());
                    holder.imgAvatar.setImageDrawable(drawable);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return yourJamArrayList.size();
    }
}
