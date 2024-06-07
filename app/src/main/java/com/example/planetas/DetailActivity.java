package com.example.planetas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImage = findViewById(R.id.detail_image);
        TextView detailName = findViewById(R.id.detail_name);
        TextView detailLongDesc = findViewById(R.id.detail_long_desc);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int imageResId = intent.getIntExtra("imageResId", -1);
        String longDescription = intent.getStringExtra("longDescription");

        detailName.setText(name);
        if (imageResId != -1) {
            detailImage.setImageResource(imageResId);
        }
        detailLongDesc.setText(longDescription);
    }
}
