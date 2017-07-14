package com.swings.jam.adapter.typerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swings.jam.R;
import com.swings.jam.data.DataHelper;
import com.swings.jam.data.Type;
import com.swings.jam.data.TypeSon;
import com.swings.jam.ui.TypeSonActivity;

import java.util.ArrayList;

/**
 * Created by sonnguyen on 7/11/17.
 */

public class TypeRecylerViewAdapter extends RecyclerView.Adapter<ItemCardHolder> {
    ArrayList<Type> typeArrayList = new ArrayList<>();
    Context context;
    public TypeRecylerViewAdapter(Context context,ArrayList<Type> typeArrayList) {
        this.typeArrayList = typeArrayList;
        this.context = context;
        if(typeArrayList.size()==0){
            typeArrayList.add(new Type());
        }
    }
    @Override
    public ItemCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new ItemCardHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemCardHolder holder, int position) {

                final Type type = typeArrayList.get(position);
                holder.txtName.setText(type.getName());
                DataHelper dataHelper = new DataHelper(context);
                ArrayList<TypeSon> typeSonArrayList = dataHelper.selectAllTypeSonByIdType(type.getId());
                String s = context.getString(R.string.type);
                holder.txtDes.setText(typeSonArrayList.size()+" "+s);
                Drawable drawable;
                if(type.getImage()!=0) {
                    drawable = context.getResources().getDrawable(type.getImage());
                    holder.imgAvatar.setImageDrawable(drawable);
                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = new Intent(context, TypeSonActivity.class);
                        in.putExtra("typeId",type.getId());
                        in.putExtra("typeName",type.getName());
                        context.startActivity(in);
                    }
                });

    }

    @Override
    public int getItemCount() {
        return typeArrayList.size();
    }
}
