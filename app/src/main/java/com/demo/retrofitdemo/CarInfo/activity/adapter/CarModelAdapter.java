package com.demo.retrofitdemo.CarInfo.activity.adapter;

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
import com.demo.retrofitdemo.CarInfo.activity.activity.CarDetailsActivity;
import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.CarInfo.activity.modal.VariantsModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

public class CarModelAdapter extends RecyclerView.Adapter<CarModelAdapter.ViewHolder> {

    Context context;
    ArrayList<CarListModel.CarList> carLists;
    public static final String COMPANY_ID = "company_id";
    public static final String CAR_POSITION = "car_position";
    public static final String CAR_IMAGES = "car_images";
    public static final String CAR_NAME = "car_name";
    public static final String CAR_PRICE = "car_price";
    public static final String CAR_COLOR = "car_color";
    public static final String CAR_VARIENTS = "car_varients";
    public static final String CAR_MILEGE = "car_milege";

    ArrayList<VariantsModel.Data> data;

    public CarModelAdapter(Context context, ArrayList<CarListModel.CarList> carLists, ArrayList<VariantsModel.Data> data) {
        this.context = context;
        this.carLists = carLists;
        this.data = data;
    }

    @NonNull
    @Override
    public CarModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carmodel_adapter, parent, false);
        return new CarModelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarModelAdapter.ViewHolder holder, int position) {
        CarListModel.CarList carList = carLists.get(position);

        holder.textView1.setText(carList.getModel_name());
        holder.textView2.setText(carList.getEx_showroom_price());

        ImageView imageView = holder.imageView1;

        Glide.with(context)
                .load(carList.getImage())
                .into(imageView);

        holder.itemView.setOnClickListener(v ->

                context.startActivity(new Intent(context, CarDetailsActivity.class)
                .putExtra(CAR_POSITION, position)
                .putExtra(COMPANY_ID, carLists.get(position).getId())
                .putExtra(CAR_IMAGES, carLists.get(position).getModel_images())
                .putExtra(CAR_NAME, carLists.get(position).getModel_name())
                .putExtra(CAR_PRICE, carLists.get(position).getEx_showroom_price())
                .putExtra(CAR_COLOR, carLists.get(position).getModel_color())
                .putExtra(CAR_VARIENTS, carLists.get(position).getModel_variants())));
}


    @Override
    public int getItemCount() {
        return carLists.size();
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