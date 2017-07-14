package com.swings.jam.adapter.typerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.swings.jam.R;

/**
 * Created by sonnguyen on 7/11/17.
 */

public class ItemCardHolder extends RecyclerView.ViewHolder {
    ImageView imgAvatar;
    TextView txtName, txtDes;

    public ItemCardHolder(View itemView) {
        super(itemView);
        imgAvatar = (ImageView) itemView.findViewById(R.id.item_card_img_avatar);
        txtDes = (TextView)itemView.findViewById(R.id.item_card_txt_description);
        txtName = (TextView)itemView.findViewById(R.id.item_card_txt_name);

    }
}
