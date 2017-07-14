package com.swings.jam.adapter.yourjam;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.swings.jam.R;

/**
 * Created by sonnguyen on 7/11/17.
 */

public class YourJamHolder extends RecyclerView.ViewHolder {
    ImageView imgAvatar;
    TextView txtName, txtDes;

    public YourJamHolder(View itemView) {
        super(itemView);
        imgAvatar = (ImageView) itemView.findViewById(R.id.item_card_img_avatar);
        txtDes = (TextView)itemView.findViewById(R.id.item_card_txt_description);
        txtName = (TextView)itemView.findViewById(R.id.item_card_txt_name);
    }
    //TODO: 1. create table your jam, include id,name,id_backingtrack,uri of file
    //TODO: 2. edit and finish sliding drawer

}
