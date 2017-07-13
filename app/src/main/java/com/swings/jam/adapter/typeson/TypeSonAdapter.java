package com.swings.jam.adapter.typeson;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swings.jam.R;
import com.swings.jam.data.DataHelper;
import com.swings.jam.data.TypeSon;

import java.util.ArrayList;

/**
 * Created by sonnguyen on 7/13/17.
 */

public class TypeSonAdapter extends RecyclerView.Adapter<TypeSonHolder> {
    ArrayList<TypeSon> typeSonArrayList = new ArrayList<>();
    Context context;

    public TypeSonAdapter(ArrayList<TypeSon> typeSonArrayList, Context context) {
        this.typeSonArrayList = typeSonArrayList;
        this.context = context;
    }

    @Override
    public TypeSonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_typeson,parent,false);
        return new TypeSonHolder(v);
    }

    @Override
    public void onBindViewHolder(TypeSonHolder holder, int position) {
        TypeSon typeSon = typeSonArrayList.get(position);
        DataHelper dataHelper = new DataHelper(context);
        int countSongs = dataHelper.countSongByTypeSonId(typeSon.getId());
        holder.txtDes.setText(countSongs+" Backing tracks");
        holder.txtName.setText(typeSon.getName());
        try {
            Drawable drawable = context.getResources().getDrawable(typeSon.getImage());
            holder.imgAvatar.setImageDrawable(drawable);
        }catch (Exception e ){}

    }

    @Override
    public int getItemCount() {
        return typeSonArrayList.size();
    }
}
