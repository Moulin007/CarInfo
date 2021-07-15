package com.demo.retrofitdemo.Bike_info.fragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.retrofitdemo.Apiservice;
import com.demo.retrofitdemo.AppConstant;
import com.demo.retrofitdemo.BikeApiService;
import com.demo.retrofitdemo.Bike_info.fragment.adapter.BikeColorAdapter;
import com.demo.retrofitdemo.Bike_info.fragment.adapter.BikeImageAdapter;
import com.demo.retrofitdemo.Bike_info.fragment.adapter.BikeModelAdapter;
import com.demo.retrofitdemo.Bike_info.fragment.adapter.BikeVariantsAdapter;
import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeModel;
import com.demo.retrofitdemo.CarInfo.activity.activity.CarDetailsActivity;
import com.demo.retrofitdemo.CarInfo.activity.adapter.CarModelAdapter;
import com.demo.retrofitdemo.CarInfo.activity.adapter.Color_Adapter;
import com.demo.retrofitdemo.CarInfo.activity.adapter.VariantsAdapter;
import com.demo.retrofitdemo.CarInfo.activity.adapter.ViewPagerAdapter;
import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.R;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BikeDetailsActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayList<String> images_url;
    ArrayList<String> color;
    int company_id;
    ProgressDialog pd;
    TextView text5, text6;
    ViewPager viewPager;
    int car_position;
    TabLayout tabLayout;
    RecyclerView recyclerView2, recyclerView3;
    ArrayList<BikeModel.BikeModelList.Bike_Variants> variants;
    String varients_str;
    public static final String URL = "https://rto.punchapp.in/api/v1/car-model-list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_details);

        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Loading...");
        recyclerView2 = findViewById(R.id.recyclerview7);
        recyclerView3 = findViewById(R.id.recyclerview8);

        init();

        tabLayout = findViewById(R.id.tab_layout);

        company_id = getIntent().getIntExtra(BikeModelAdapter.COMPANY_ID, -1);
        car_position = getIntent().getIntExtra(BikeModelAdapter.CAR_POSITION, -1);
        String s = getIntent().getStringExtra(BikeModelAdapter.CAR_NAME);
        String s1 = getIntent().getStringExtra(BikeModelAdapter.CAR_PRICE);
        arrayList = getIntent().getStringArrayListExtra(BikeModelAdapter.CAR_IMAGES);
        color = getIntent().getStringArrayListExtra(BikeModelAdapter.CAR_COLOR);
        varients_str = getIntent().getStringExtra(BikeModelAdapter.CAR_VARIENTS);

        Log.e("TAG", "var: " + varients_str);

        Log.e("TAG", "csize: " + varients_str);
        Log.e("TAG", "image: " + arrayList.size());

        for (int i = 0; i < arrayList.size(); i++) {
            images_url.add("https://rto.punchapp.in/bike-images/bikeimages/" + arrayList.get(i));
        }

        text5.setText(s);
        text6.setText(s1);

        BikeImageAdapter adapter2 = new BikeImageAdapter(BikeDetailsActivity.this, images_url);
        viewPager.setAdapter(adapter2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BikeDetailsActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView2.setLayoutManager(linearLayoutManager);
        BikeColorAdapter adapter3 = new BikeColorAdapter(BikeDetailsActivity.this, color);
        recyclerView2.setAdapter(adapter3);

        LinearLayoutManager linearManager = new LinearLayoutManager(BikeDetailsActivity.this);
        linearManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView3.setLayoutManager(linearManager);

        tabLayout.setupWithViewPager(viewPager);

        getBikeDetailsFromCompany(company_id);

        getvairets();
    }

    private void getvairets() {
        variants = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(varients_str);

            Log.e("TAG", "getvairets: " + jsonArray.length() + "\n" + jsonArray);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject obj1 = jsonArray.getJSONObject(i);

                BikeModel.BikeModelList.Bike_Variants varient = new BikeModel.BikeModelList.Bike_Variants();

                int variant_id = obj1.getInt("id");
                String variante_name = obj1.getString("variant_name");
                String price = obj1.getString("variant_price");
                String cc = obj1.getString("cc");

                varient.setId(variant_id);
                varient.setVariant_name(variante_name);
                varient.setVariant_price(price);
                varient.setEngine_disp(cc);

                variants.add(varient);
            }

            BikeVariantsAdapter variantsAdapter = new BikeVariantsAdapter(BikeDetailsActivity.this, variants);
            recyclerView3.setAdapter(variantsAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getBikeDetailsFromCompany(int company_id) {
        pd.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BikeApiService service = retrofit.create(BikeApiService.class);

        Call<BikeModel> call = service.getBikeDetailsFromCompany("OMMQYTiF9vyqHGiBiLiLoetLUcM", company_id);
        call.enqueue(new Callback<BikeModel>() {

            @Override
            public void onResponse(Call<BikeModel> call, Response<BikeModel> response) {

                if (pd.isShowing() && pd != null)
                    pd.dismiss();

            }

            @Override
            public void onFailure(Call<BikeModel> call, Throwable t) {
                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                Toast.makeText(BikeDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        arrayList = new ArrayList<>();
        images_url = new ArrayList<>();
        color = new ArrayList<>();

        viewPager = findViewById(R.id.viewPager);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);
    }
}