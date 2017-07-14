package com.swings.jam.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.swings.jam.R;

import static android.R.attr.radius;

/**
 * Created by sonnguyen on 7/9/17.
 */

public class ButtonCustom extends LinearLayout {
    private  float Radius;
    private  int color;
    private  float elevation;
    private  Drawable icon;
    private  String text;
    LinearLayout linearMain;
    ImageView imgIcon;
    CardView cardMain;
    TextView txtTitle;

    public ButtonCustom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs,R.styleable.ButtonCustom);
        //get attr
         color = typedArray.getColor(R.styleable.ButtonCustom_Background,getResources().getColor(R.color.button_rectangle));
         elevation = typedArray.getDimension(R.styleable.ButtonCustom_Elevation,0);
         icon = typedArray.getDrawable(R.styleable.ButtonCustom_src);
         text = typedArray.getString(R.styleable.ButtonCustom_text);
         Radius = typedArray.getDimension(R.styleable.ButtonCustom_CornerRadius,20);
    }
    public void setHeight(){
        int height = getHeight();
        int width = getWidth();
        //set card
    }
    public ButtonCustom(Context context) {
        super(context);
        initializeViews(context);
    }


    //init view
    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.button, this);
    }





    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        imgIcon = (ImageView)findViewById(R.id.img_icon);
        cardMain = (CardView)findViewById(R.id.cardview_main);
        txtTitle = (TextView)findViewById(R.id.txt_title);
        linearMain = (LinearLayout)findViewById(R.id.linear_main);
        //set
        setBackgroundColor(color);
        setElevation(elevation);
        if(icon!=null)
            setIconDrawResource(icon);
        setText(text);
        setCardCornerRadius(Radius);


    }
    //setup method
    public void setText(String text){
        txtTitle.setText(text);
    }
    public String getText(){
        return txtTitle.getText().toString();
    }
    public void setIconDrawResource(Drawable resource){
        imgIcon.setImageDrawable(resource);
    }
    public void setCardCornerRadius(float dimen){
        cardMain.setRadius(dimen);
    }
    public void setBackgroundColor(int color){
        cardMain.setCardBackgroundColor(color);
    }
    public void setElevation(float elevation){
        cardMain.setCardElevation(elevation);
    }


}
