package com.challenger.apps.airlines;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/19/17.
 */
public class AirlinesRecyclerViewAdapter extends RecyclerView.Adapter<AirlinesRecyclerViewAdapter.ViewHolder>{

    private ArrayList airlines;
    private Context context;

    AirlinesRecyclerViewAdapter(Context context){
        airlines = new ArrayList();
        this.context = context;
    }

    void updateAirlinesList(ArrayList airlines){
        this.airlines = airlines;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_airlines_recyclerview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.airlineName.setText("Egypt Air");
        Picasso.with(context)
                .load("http://www.arabaviation.com/Portals/0/Egypt/govTech_Egyptair-Logo.jpg")
                .error(R.drawable.photo_not_available)
                .placeholder(R.drawable.loading)
                .into(holder.airlineLogo);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView airlineLogo;
        public TextView airlineName;
        public ViewHolder(View v) {
            super(v);
            airlineLogo = (ImageView) v.findViewById(R.id.airline_logo);
            airlineName = (TextView) v.findViewById(R.id.airline_name);
        }
    }
}
