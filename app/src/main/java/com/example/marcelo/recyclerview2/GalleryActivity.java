package com.example.marcelo.recyclerview2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started");
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if (getIntent().hasExtra("IMAGE_URL") && getIntent().hasExtra("IMAGE_NAME")){

            String imageURL = getIntent().getStringExtra("IMAGE_URL");
            String imageName = getIntent().getStringExtra("IMAGE_NAME");
            setImage(imageURL, imageName);
        }
    }
    private void setImage(String imageURL, String imageName){

        ImageView imageView = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageURL)
                .into(imageView);

        TextView name = findViewById(R.id.imageDescription);
        name.setText(imageName);
    }
}
