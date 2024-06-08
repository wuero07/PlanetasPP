package com.example.planetas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        LinearLayout planetContainer = findViewById(R.id.planet_container);

        Intent intent = getIntent();
        Planet[] planetArray = (Planet[]) intent.getSerializableExtra("planetList");

        for (Planet planet : planetArray) {
            View planetView = getLayoutInflater().inflate(R.layout.item_planet_detail, null);

            ImageView planetImage = planetView.findViewById(R.id.planet_image);
            TextView planetName = planetView.findViewById(R.id.planet_name);
            TextView planetDesc = planetView.findViewById(R.id.planet_desc);

            planetImage.setImageResource(planet.getImageResId());
            planetName.setText(planet.getName());
            planetDesc.setText(planet.getLongDescription());

            planetContainer.addView(planetView);
        }
    }
}
