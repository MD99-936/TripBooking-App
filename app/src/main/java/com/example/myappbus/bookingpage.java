package com.example.myappbus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappbus.adapter.RecentsAdapter;
import com.example.myappbus.adapter.TopPlacesAdapter;
import com.example.myappbus.model.RecentsData;
import com.example.myappbus.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class bookingpage extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingpage);
        Objects.requireNonNull(getSupportActionBar()).hide();
        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("The Fairy Pools","Scotland","From $660",R.drawable.thefairypools));
        recentsDataList.add(new RecentsData("Pyramids","Egypt","From $750",R.drawable.pyramids));
        recentsDataList.add(new RecentsData("Dubai","UAE","From $560",R.drawable.dubai));
        recentsDataList.add(new RecentsData("Istanbul","Turkey","From $1050",R.drawable.istanbulturkey));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Palatine Hill","Italy","$300 - $500",R.drawable.palatine));
        topPlacesDataList.add(new TopPlacesData("Louvre Museum","France","$800 - $1400",R.drawable.louvre));
        topPlacesDataList.add(new TopPlacesData("La Sagrada Familia","Barcelona","$500 - $900",R.drawable.lasagrada));
        topPlacesDataList.add(new TopPlacesData("Colosseum","Rome","$700 - $1000",R.drawable.colosseum));
        topPlacesDataList.add(new TopPlacesData("Parthenon","Athens","$900 - $1300",R.drawable.parthenon));

        setTopPlacesRecycler(topPlacesDataList);
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList) {

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList) {

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }}