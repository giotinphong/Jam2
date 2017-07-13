package com.swings.jam.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.swings.jam.R;
import com.swings.jam.adapter.typeson.TypeSonAdapter;
import com.swings.jam.data.DataHelper;
import com.swings.jam.data.TypeSon;

import java.util.ArrayList;

public class TypeSonActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_son2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DataHelper dataHelper = new DataHelper(this);
        int typeId = getIntent().getExtras().getInt("typeId");
        ArrayList<TypeSon> typeSonArrayList = dataHelper.selectAllTypeSonByIdType(typeId);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.acti_typeson_recyclerview);
        TypeSonAdapter adapter = new TypeSonAdapter(typeSonArrayList,TypeSonActivity2.this);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(TypeSonActivity2.this);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager1);
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
