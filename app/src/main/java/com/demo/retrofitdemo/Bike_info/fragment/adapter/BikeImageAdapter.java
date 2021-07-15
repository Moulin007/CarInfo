package com.demo.retrofitdemo.Bike_info.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

public class BikeImageAdapter extends PagerAdapter {

    Context context;
    ArrayList<String> bikeList;

    public BikeImageAdapter(Context context, ArrayList<String> bikeList) {
        this.context = context;
        this.bikeList = bikeList;
    }

    @Override
    public int getCount() {
        return bikeList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.bike_image_adapter,container,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image3);


        Glide.with(context)
                .load(bikeList.get(position))
                .into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
