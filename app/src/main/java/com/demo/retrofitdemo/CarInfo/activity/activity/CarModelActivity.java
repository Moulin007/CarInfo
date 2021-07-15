package com.demo.retrofitdemo.CarInfo.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.demo.retrofitdemo.CarInfo.activity.adapter.CompanyListAdapter;
import com.demo.retrofitdemo.CarInfo.activity.adapter.CarModelAdapter;
import com.demo.retrofitdemo.Apiservice;
import com.demo.retrofitdemo.AppConstant;
import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.CarInfo.activity.modal.VariantsModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarModelActivity extends AppCompatActivity {

    ArrayList<CarListModel.CarList> carList;
    ArrayList<VariantsModel.Data> data;
    int company_id;
    ProgressDialog pd;
    RecyclerView recyclerView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carmodel);

        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Loading...");
        recyclerView1 = findViewById(R.id.recyclerview1);

        company_id = getIntent().getIntExtra(CompanyListAdapter.COMPANY_ID,-1);
        init();
        getCarFromCompany(company_id);

    }

    private void getCarFromCompany(int company_id) {
        pd.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiservice service = retrofit.create(Apiservice.class);

        Call<CarListModel> call = service.getCarFromCompany("OMMQYTiF9vyqHGiBiLiLoetLUcM",company_id);
        call.enqueue(new Callback<CarListModel>(){

            @Override
            public void onResponse(Call<CarListModel> call, Response<CarListModel> response) {

                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                carList = response.body().getData();

                recyclerView1.setLayoutManager(new LinearLayoutManager(CarModelActivity.this));
                CarModelAdapter adapter1 = new CarModelAdapter(CarModelActivity.this, carList, data);
                recyclerView1.setAdapter(adapter1);
            }

            @Override
            public void onFailure(Call<CarListModel> call, Throwable t) {
                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                Toast.makeText(CarModelActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void init() {
        carList = new ArrayList<>();
        data = new ArrayList<>();
    }
}