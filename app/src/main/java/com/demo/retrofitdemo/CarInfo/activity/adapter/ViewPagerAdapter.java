package com.demo.retrofitdemo.CarInfo.activity.adapter;

import android.content.Context;
import android.util.Log;
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

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<String> carLists;

    public ViewPagerAdapter(Context context, ArrayList<String> carLists) {
        this.context = context;
        this.carLists = carLists;
    }

    @Override
    public int getCount() {
        return carLists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_adapter,container,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image3);

        Glide.with(context)
                .load(carLists.get(position))
                .into(imageView);

        Log.e("TAG", "instantiateItem: " + carLists.get(position));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
