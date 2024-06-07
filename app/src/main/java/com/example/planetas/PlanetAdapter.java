package com.example.planetas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    private Context context;
    private List<Planet> planetList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Planet planet);
    }

    public PlanetAdapter(Context context, List<Planet> planetList, OnItemClickListener listener) {
        this.context = context;
        this.planetList = planetList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_planet, parent, false);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        Planet planet = planetList.get(position);
        holder.bind(planet, listener);
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private ImageView imageView;
        private TextView shortDescTextView;

        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.planet_name);
            imageView = itemView.findViewById(R.id.planet_image);
            shortDescTextView = itemView.findViewById(R.id.planet_short_desc);
        }

        public void bind(final Planet planet, final OnItemClickListener listener) {
            nameTextView.setText(planet.getName());
            imageView.setImageResource(planet.getImageResId());
            shortDescTextView.setText(planet.getShortDescription());

            itemView.setOnClickListener(v -> listener.onItemClick(planet));
        }
    }
}
