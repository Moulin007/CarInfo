package com.demo.retrofitdemo.Bike_info.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demo.retrofitdemo.Bike_info.fragment.activity.BikeModelActivity;
import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeListModal;
import com.demo.retrofitdemo.CarInfo.activity.activity.CarModelActivity;
import com.demo.retrofitdemo.CarInfo.activity.adapter.CompanyListAdapter;
import com.demo.retrofitdemo.CarInfo.activity.modal.CompanyListModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

public class Bike_Compony_Adapter extends RecyclerView.Adapter<Bike_Compony_Adapter.ViewHolder> {

    Context context;
    ArrayList<BikeListModal.BikeList> bikeLists;
    public static final String COMPANY_ID = "company_id";

    public Bike_Compony_Adapter(Context context, ArrayList<BikeListModal.BikeList> bikeLists) {
        this.context = context;
        this.bikeLists = bikeLists;
    }

    @NonNull
    @Override
    public Bike_Compony_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bike_compony_adapter, parent, false);
        return new Bike_Compony_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Bike_Compony_Adapter.ViewHolder holder, int position) {
        BikeListModal.BikeList bikeList = bikeLists.get(position);

        holder.textView.setText(bikeList.getCompany_name());

        ImageView imageView = holder.imageView;

        Glide.with(context)
                .load(bikeList.getCompany_logo())
                .into(imageView);

        holder.itemView.setOnClickListener(v -> {
            context.startActivity(new Intent(context, BikeModelActivity.class)
                    .putExtra(COMPANY_ID, bikeLists.get(position).getId()));
        });
    }

    @Override
    public int getItemCount() {
        return bikeLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
