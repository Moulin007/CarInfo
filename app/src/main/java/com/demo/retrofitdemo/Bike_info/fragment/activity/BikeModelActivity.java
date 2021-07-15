package com.demo.retrofitdemo.Bike_info.fragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.demo.retrofitdemo.Apiservice;
import com.demo.retrofitdemo.AppConstant;
import com.demo.retrofitdemo.BikeApiService;
import com.demo.retrofitdemo.Bike_info.fragment.adapter.BikeModelAdapter;
import com.demo.retrofitdemo.Bike_info.fragment.adapter.Bike_Compony_Adapter;
import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeModel;
import com.demo.retrofitdemo.CarInfo.activity.activity.CarModelActivity;
import com.demo.retrofitdemo.CarInfo.activity.adapter.CarModelAdapter;
import com.demo.retrofitdemo.CarInfo.activity.adapter.CompanyListAdapter;
import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BikeModelActivity extends AppCompatActivity {

    ArrayList<BikeModel.BikeModelList> bikeModelLists;
    int company_id;
    ProgressDialog pd;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_model);

        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Loading...");
        recyclerView = findViewById(R.id.recyclerview6);

        company_id = getIntent().getIntExtra(Bike_Compony_Adapter.COMPANY_ID,-1);
        init();
        getBikeFromCompany(company_id);
    }

    private void init() {
        bikeModelLists = new ArrayList<>();
    }

    private void getBikeFromCompany(int company_id) {
        pd.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BikeApiService service = retrofit.create(BikeApiService.class);

        Call<BikeModel> call = service.getBikeFromCompany("OMMQYTiF9vyqHGiBiLiLoetLUcM",company_id);
        call.enqueue(new Callback<BikeModel>(){

            @Override
            public void onResponse(Call<BikeModel> call, Response<BikeModel> response) {

                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                bikeModelLists = response.body().getData();

                recyclerView.setLayoutManager(new LinearLayoutManager(BikeModelActivity.this));
                BikeModelAdapter adapter = new BikeModelAdapter(BikeModelActivity.this, bikeModelLists);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BikeModel> call, Throwable t) {
                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                Toast.makeText(BikeModelActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}