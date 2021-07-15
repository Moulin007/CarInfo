package com.demo.retrofitdemo.Bike_info.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.retrofitdemo.Bike_info.fragment.activity.BikeVariantActivity;
import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeModel;
import com.demo.retrofitdemo.CarInfo.activity.activity.CarVariantsActivity;
import com.demo.retrofitdemo.CarInfo.activity.adapter.VariantsAdapter;
import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

public class BikeVariantsAdapter extends RecyclerView.Adapter<BikeVariantsAdapter.ViewHolder> {

    Context context;
    ArrayList<BikeModel.BikeModelList.Bike_Variants> variants;
    public static final String VARIENT_DETAILS = "varient_details";

    public BikeVariantsAdapter(Context context, ArrayList<BikeModel.BikeModelList.Bike_Variants> variants) {
        this.context = context;
        this.variants = variants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bike_variants_adapter ,parent,false);
        return new BikeVariantsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BikeModel.BikeModelList.Bike_Variants bike_variants = variants.get(position);

        holder.var_name.setText(bike_variants.getVariant_name());
        holder.price.setText(bike_variants.getVariant_price());
        holder.disp.setText(bike_variants.getEngine_disp());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, BikeVariantActivity.class)
                        .putExtra(VARIENT_DETAILS, variants.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return variants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView var_name,price,disp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            var_name = itemView.findViewById(R.id.var_name);
            price = itemView.findViewById(R.id.price);
            disp = itemView.findViewById(R.id.disp);
        }
    }
}
