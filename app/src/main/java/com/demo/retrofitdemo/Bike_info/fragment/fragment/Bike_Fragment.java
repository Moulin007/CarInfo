package com.demo.retrofitdemo.Bike_info.fragment.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.demo.retrofitdemo.AppConstant;
import com.demo.retrofitdemo.BikeApiService;
import com.demo.retrofitdemo.Bike_info.fragment.adapter.Bike_Compony_Adapter;
import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeListModal;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Bike_Fragment extends Fragment {

    ArrayList<BikeListModal.BikeList> bikeLists;
    RecyclerView recyclerView;
    ProgressDialog pd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        pd = new ProgressDialog(getContext());
        pd.setCancelable(false);
        pd.setMessage("Loading...");
        bikeLists = new ArrayList<>();
        bike_list();
        View view  = inflater.inflate(R.layout.fragment_bike_, container, false);
        recyclerView = view.findViewById(R.id.recyclerview5);
        return  view;
    }

    private void bike_list() {
        pd.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BikeApiService service = retrofit.create(BikeApiService.class);
        Call<BikeListModal> call = service.getBikeList("OMMQYTiF9vyqHGiBiLiLoetLUcM");

        call.enqueue(new Callback<BikeListModal>() {
            @Override
            public void onResponse(Call<BikeListModal> call, Response<BikeListModal> response) {

                if (pd.isShowing() && pd != null)
                    pd.dismiss();

                bikeLists = response.body().getData();
                Log.e("TAG", "bike: " + bikeLists.get(0).getCompany_name());

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
                recyclerView.setLayoutManager(gridLayoutManager);
                Bike_Compony_Adapter adapter = new Bike_Compony_Adapter(getContext(), bikeLists);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BikeListModal> call, Throwable t) {
                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}