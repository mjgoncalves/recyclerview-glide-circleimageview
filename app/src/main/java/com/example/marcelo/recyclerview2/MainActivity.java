package com.example.marcelo.recyclerview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> imageURLs = new ArrayList<>();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        initImageBitmaps();


    }

    private void initImageBitmaps(){

        imageURLs.add("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Amsterdam_sights.jpg/800px-Amsterdam_sights.jpg");
        mNames.add("Amsterdam");

        imageURLs.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Tln3.jpg/320px-Tln3.jpg");
        mNames.add("Tallinn");

        imageURLs.add("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/ISS020-E-25198.JPG/1024px-ISS020-E-25198.JPG");
        mNames.add("Fernando de Noronha");

        imageURLs.add("https://upload.wikimedia.org/wikipedia/commons/f/f5/Passadi%C3%A7o_da_Gl%C3%B3ria.jpg");
        mNames.add("Diamantina");

        imageURLs.add("https://upload.wikimedia.org/wikipedia/commons/3/34/Berlin_Montage_2016.png");
        mNames.add("Berlim");

        imageURLs.add("https://upload.wikimedia.org/wikipedia/commons/0/05/Paris_montage_2013.jpg");
        mNames.add("Paris");

        imageURLs.add("https://upload.wikimedia.org/wikipedia/commons/b/bf/Tokyo_Montage_2015.jpg");
        mNames.add("Tóquio");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, imageURLs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
