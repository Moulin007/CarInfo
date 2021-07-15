package com.demo.retrofitdemo.CarInfo.activity.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.demo.retrofitdemo.CarInfo.activity.adapter.CarModelAdapter;
import com.demo.retrofitdemo.CarInfo.activity.adapter.Color_Adapter;
import com.demo.retrofitdemo.CarInfo.activity.adapter.VariantsAdapter;
import com.demo.retrofitdemo.CarInfo.activity.adapter.ViewPagerAdapter;
import com.demo.retrofitdemo.Apiservice;
import com.demo.retrofitdemo.AppConstant;
import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.R;
import com.github.demono.AutoScrollViewPager;
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

public class CarDetailsActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayList<String> images_url;
    ArrayList<String> color;
    int company_id;
    ProgressDialog pd;
    TextView text5, text6, fueltype,manual,cc,kmph;
    AutoScrollViewPager viewPager;
    int car_position;
    TabLayout tabLayout;
    RecyclerView recyclerView2, recyclerView3;
    ArrayList<CarListModel.CarList.Car_Variants> variants;
    String varients_str;
    public static final String URL = "https://rto.punchapp.in/api/v1/car-model-list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Loading...");
        recyclerView2 = findViewById(R.id.recyclerview2);
        recyclerView3 = findViewById(R.id.recyclerview3);

        fueltype = findViewById(R.id.fueltype);
//        manual = findViewById(R.id.manual);
//        cc = findViewById(R.id.cc);
//        kmph = findViewById(R.id.kmph);

        init();

        tabLayout = findViewById(R.id.tab_layout);

        company_id = getIntent().getIntExtra(CarModelAdapter.COMPANY_ID, -1);
        car_position = getIntent().getIntExtra(CarModelAdapter.CAR_POSITION, -1);
        String s = getIntent().getStringExtra(CarModelAdapter.CAR_NAME);
        String s1 = getIntent().getStringExtra(CarModelAdapter.CAR_PRICE);
        arrayList = getIntent().getStringArrayListExtra(CarModelAdapter.CAR_IMAGES);
        color = getIntent().getStringArrayListExtra(CarModelAdapter.CAR_COLOR);
        varients_str = getIntent().getStringExtra(CarModelAdapter.CAR_VARIENTS);
        String mileage = getIntent().getStringExtra(CarModelAdapter.CAR_MILEGE);


        Log.e("TAG", "mileage: " + mileage);
        Log.e("TAG", "image: " + arrayList.size() );

        for (int i = 0; i < arrayList.size(); i++) {
            images_url.add("https://rto.punchapp.in/car-images/images/" + arrayList.get(i));
        }


        text5.setText(s);
        text6.setText(s1);

//        fueltype.setText(mileage);

        //SliderImage
        ViewPagerAdapter adapter2 = new ViewPagerAdapter(CarDetailsActivity.this, images_url);
        viewPager.setAdapter(adapter2);
        viewPager.startAutoScroll(3000);
        viewPager.setCycle(true);

        //colorItem
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CarDetailsActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView2.setLayoutManager(linearLayoutManager);
        Color_Adapter adapter3 = new Color_Adapter(CarDetailsActivity.this, color);
        recyclerView2.setAdapter(adapter3);

        LinearLayoutManager linearManager = new LinearLayoutManager(CarDetailsActivity.this);
        linearManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView3.setLayoutManager(linearManager);

        tabLayout.setupWithViewPager(viewPager);

        getCarDetailsFromCompany(company_id);

        getvairets();
    }

    private void getvairets() {
        variants = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(varients_str);

            Log.e("TAG", "getvairets: " + jsonArray.length() + "\n" + jsonArray);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject obj1 = jsonArray.getJSONObject(i);

                CarListModel.CarList.Car_Variants varient = new CarListModel.CarList.Car_Variants();

                int variant_id = obj1.getInt("id");
                String variante_name = obj1.getString("variant_name");
                String price = obj1.getString("variant_price");
                String transmission = obj1.getString("transmission_type");
                String fule_type = obj1.getString("fuel_type");
                String engine_disp = obj1.getString("engine_disp");

                varient.setId(variant_id);
                varient.setVariant_name(variante_name);
                varient.setVariant_price(price);
                varient.setTransmission_type(transmission);
                varient.setFuel_type(fule_type);
                varient.setEngine_disp(engine_disp);

                variants.add(varient);
            }


            VariantsAdapter variantsAdapter = new VariantsAdapter(CarDetailsActivity.this, variants);
            recyclerView3.setAdapter(variantsAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getCarDetailsFromCompany(int company_id) {
        pd.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiservice service = retrofit.create(Apiservice.class);

        Call<CarListModel> call = service.getCarDetailsFromCompany("OMMQYTiF9vyqHGiBiLiLoetLUcM", company_id);
        call.enqueue(new Callback<CarListModel>() {

            @Override
            public void onResponse(Call<CarListModel> call, Response<CarListModel> response) {

                if (pd.isShowing() && pd != null)
                    pd.dismiss();

            }

            @Override
            public void onFailure(Call<CarListModel> call, Throwable t) {
                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                Toast.makeText(CarDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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