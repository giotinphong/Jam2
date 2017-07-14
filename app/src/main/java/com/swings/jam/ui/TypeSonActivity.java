package com.swings.jam.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.swings.jam.R;
import com.swings.jam.adapter.typeson.TypeSonAdapter;
import com.swings.jam.data.DataHelper;
import com.swings.jam.data.TypeSon;

import java.util.ArrayList;
import java.util.Random;

public class TypeSonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_son);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DataHelper dataHelper = new DataHelper(this);
        int typeId = getIntent().getExtras().getInt("typeId");
        ArrayList<TypeSon> typeSonArrayList = dataHelper.selectAllTypeSonByIdType(typeId);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.acti_typeson_recyclerview);
        TypeSonAdapter adapter = new TypeSonAdapter(typeSonArrayList,TypeSonActivity.this);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(TypeSonActivity.this);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager1);


        //change
        ArrayList<Integer> drawableList = new ArrayList<>();
        for(TypeSon typeSon : typeSonArrayList){
            drawableList.add(typeSon.getImage());
        }
        Random ran = new Random();
        int numran = ran.nextInt(drawableList.size());
        Drawable drawable = this.getResources().getDrawable(drawableList.get(numran));
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        toolbarLayout.setBackground(drawable);
        toolbarLayout.setTitle(getIntent().getExtras().getString("typeName"));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
