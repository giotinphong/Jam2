package com.swings.jam.adapter.typeson;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.swings.jam.R;

/**
 * Created by sonnguyen on 7/13/17.
 */

public class TypeSonHolder extends RecyclerView.ViewHolder {
    ImageView imgAvatar;
    TextView txtName,txtDes;
    public TypeSonHolder(View itemView) {
        super(itemView);
        imgAvatar = (ImageView)itemView.findViewById(R.id.item_card_typeson_img_avatar);
        txtName = (TextView)itemView.findViewById(R.id.item_card_typeson_txt_name);
        txtDes = (TextView)itemView.findViewById(R.id.item_card_typeson_txt_des);
    }
}
