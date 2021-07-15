package com.demo.retrofitdemo.Bike_info.fragment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.retrofitdemo.CarInfo.activity.adapter.Color_Adapter;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

public class BikeColorAdapter extends RecyclerView.Adapter<BikeColorAdapter.ViewHolder> {

    Context context;
    ArrayList<String> color;

    public BikeColorAdapter(Context context, ArrayList<String> colorList) {
        this.context = context;
        this.color = colorList;
    }

    @NonNull
    @Override
    public BikeColorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bike_color_adapter, parent, false);
        return new BikeColorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BikeColorAdapter.ViewHolder holder, int position) {
        holder.imageView.setBackgroundColor(Color.parseColor(color.get(position)));
        Log.e("TAG", "color: " + color.get(position) );
    }

    @Override
    public int getItemCount() {
        return color.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.color_image);
        }
    }
}
