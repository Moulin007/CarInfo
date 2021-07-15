package com.demo.retrofitdemo.CarInfo.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.retrofitdemo.CarInfo.activity.activity.CarVariantsActivity;
import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

public class VariantsAdapter extends RecyclerView.Adapter<VariantsAdapter.ViewHolder> {

    Context context;
    ArrayList<CarListModel.CarList.Car_Variants> variants;
    public static final String VARIENT_DETAILS = "varient_details";

    public VariantsAdapter(Context context, ArrayList<CarListModel.CarList.Car_Variants> variants) {
        this.context = context;
        this.variants = variants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.variants_adapter ,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CarListModel.CarList.Car_Variants car_variants = variants.get(position);

        holder.text1.setText(car_variants.getVariant_name());
        holder.text2.setText(car_variants.getVariant_price());
        holder.text3.setText(car_variants.getTransmission_type());
        holder.text4.setText(car_variants.getFuel_type());
        holder.text5.setText(car_variants.getEngine_disp());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CarVariantsActivity.class)
                .putExtra(VARIENT_DETAILS, variants.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return variants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text1,text2,text3,text4,text5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.text7);
            text2 = itemView.findViewById(R.id.text8);
            text3 = itemView.findViewById(R.id.text9);
            text4 = itemView.findViewById(R.id.text10);
            text5 = itemView.findViewById(R.id.text11);
        }
    }
}