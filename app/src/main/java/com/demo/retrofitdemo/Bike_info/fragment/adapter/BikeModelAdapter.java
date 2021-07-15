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
import com.demo.retrofitdemo.Bike_info.fragment.activity.BikeDetailsActivity;
import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeModel;
import com.demo.retrofitdemo.CarInfo.activity.activity.CarDetailsActivity;
import com.demo.retrofitdemo.CarInfo.activity.adapter.CarModelAdapter;
import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

public class BikeModelAdapter extends RecyclerView.Adapter<BikeModelAdapter.ViewHolder> {

    Context context;
    ArrayList<BikeModel.BikeModelList> bikeModelLists;
    public static final String COMPANY_ID = "company_id";
    public static final String CAR_POSITION = "car_position";
    public static final String CAR_IMAGES = "car_images";
    public static final String CAR_NAME = "car_name";
    public static final String CAR_PRICE = "car_price";
    public static final String CAR_COLOR = "car_color";
    public static final String CAR_VARIENTS = "car_varients";

    public BikeModelAdapter(Context context, ArrayList<BikeModel.BikeModelList> bikeModelLists) {
        this.context = context;
        this.bikeModelLists = bikeModelLists;
    }

    @NonNull
    @Override
    public BikeModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bikemodel_adapter, parent, false);
        return new BikeModelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BikeModelAdapter.ViewHolder holder, int position) {
        BikeModel.BikeModelList bikeModelList = bikeModelLists.get(position);

        holder.textView1.setText(bikeModelList.getModel_name());
        holder.textView2.setText(bikeModelList.getModel_price());

        ImageView imageView = holder.imageView1;

        Glide.with(context)
                .load(bikeModelList.getModel_image())
                .into(imageView);

        holder.itemView.setOnClickListener(v ->

                context.startActivity(new Intent(context, BikeDetailsActivity.class)
                        .putExtra(CAR_POSITION, position)
                        .putExtra(COMPANY_ID, bikeModelLists.get(position).getId())
                        .putExtra(CAR_IMAGES, bikeModelLists.get(position).getModel_images())
                        .putExtra(CAR_NAME, bikeModelLists.get(position).getModel_name())
                        .putExtra(CAR_PRICE, bikeModelLists.get(position).getModel_price())
                        .putExtra(CAR_COLOR, bikeModelLists.get(position).getModel_color())
                        .putExtra(CAR_VARIENTS, bikeModelLists.get(position).getModel_variants())));
    }

    @Override
    public int getItemCount() {
        return bikeModelLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView1;
        TextView textView1,textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView1 = itemView.findViewById(R.id.image2);
            textView1 = itemView.findViewById(R.id.text3);
            textView2 = itemView.findViewById(R.id.text4);
        }
    }
}
