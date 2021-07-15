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
import com.demo.retrofitdemo.CarInfo.activity.activity.CarModelActivity;
import com.demo.retrofitdemo.CarInfo.activity.modal.CompanyListModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

public class CompanyListAdapter extends RecyclerView.Adapter<CompanyListAdapter.ViewHolder> {

    Context context;
    ArrayList<CompanyListModel.CompanyList> companyLists;
    public static final String COMPANY_ID = "company_id";

    public CompanyListAdapter(Context context, ArrayList<CompanyListModel.CompanyList> arrayList) {
        this.context = context;
        this.companyLists = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.companylist_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CompanyListModel.CompanyList companylist = companyLists.get(position);

        holder.textView.setText(companylist.getCompany_name());

        ImageView imageView = holder.imageView;

        Glide.with(context)
                .load(companylist.getCompany_logo())
                .into(imageView);

        holder.itemView.setOnClickListener(v -> {
            context.startActivity(new Intent(context, CarModelActivity.class)
            .putExtra(COMPANY_ID, companyLists.get(position).getId()));
        });
    }

    @Override
    public int getItemCount() {
        return companyLists.size();
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
