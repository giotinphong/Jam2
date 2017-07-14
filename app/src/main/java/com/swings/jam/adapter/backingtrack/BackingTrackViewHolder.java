package com.swings.jam.adapter.backingtrack;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.swings.jam.R;

/**
 * Created by sonnguyen on 7/11/17.
 */

public class BackingTrackViewHolder extends RecyclerView.ViewHolder {
    RelativeLayout imgAvatar;
    TextView txtName, txtCount;

    public BackingTrackViewHolder(View itemView) {
        super(itemView);
        imgAvatar = (RelativeLayout) itemView.findViewById(R.id.item_backingtrack_linear_image);
        txtCount = (TextView)itemView.findViewById(R.id.item_backingtrack_txt_count);
        txtName = (TextView)itemView.findViewById(R.id.item_backingtrack_txt_name);
    }

}
