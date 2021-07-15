package com.demo.retrofitdemo.CarInfo.activity.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.demo.retrofitdemo.CarInfo.activity.adapter.Fragment_PagerAdapter;
import com.demo.retrofitdemo.Bike_info.fragment.fragment.Bike_Fragment;
import com.demo.retrofitdemo.CarInfo.activity.fragment.Car_Fragment;
import com.demo.retrofitdemo.CarInfo.activity.modal.FragmentModel;
import com.demo.retrofitdemo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<FragmentModel> models;
    BottomNavigationView bottomNavigationView;
    Fragment[] fragments = {new Car_Fragment(), new Bike_Fragment()};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        models = new ArrayList<>();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.page_1:

                       switchToFragment1();
                       break;

                    case R.id.page_2:

                        switchToFragment2();
                        break;
                }

                return true;
            }
        });

        for (int i = 0; i <fragments.length ; i++) {
            FragmentModel fragmentModels = new FragmentModel();

            fragmentModels.setFragment(fragments[i]);

            models.add(fragmentModels);
        }
        Fragment_PagerAdapter fragment_pagerAdapter = new Fragment_PagerAdapter(getSupportFragmentManager(), models);
        viewPager.setAdapter(fragment_pagerAdapter);

    }

    public void switchToFragment1() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.car_fragment, new Car_Fragment()).commit();
    }

    public void switchToFragment2() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.bike_fragment, new Bike_Fragment()).commit();
    }

}
