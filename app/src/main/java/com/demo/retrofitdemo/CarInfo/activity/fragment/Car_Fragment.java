package com.demo.retrofitdemo.CarInfo.activity.fragment;

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

import com.demo.retrofitdemo.CarInfo.activity.adapter.CompanyListAdapter;
import com.demo.retrofitdemo.Apiservice;
import com.demo.retrofitdemo.AppConstant;
import com.demo.retrofitdemo.CarInfo.activity.modal.CompanyListModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Car_Fragment extends Fragment {

    ArrayList<CompanyListModel.CompanyList> companyLists;
    RecyclerView recyclerView;
    ProgressDialog pd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pd = new ProgressDialog(getContext());
        pd.setCancelable(false);
        pd.setMessage("Loading...");
        companyLists = new ArrayList<>();
        company_list();
        View view  = inflater.inflate(R.layout.fragment_car, container, false);
        recyclerView = view.findViewById(R.id.recyclerview4);
        return  view;
    }

    public void company_list(){
        pd.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiservice service = retrofit.create(Apiservice.class);
        Call<CompanyListModel> call = service.getCompanyList("OMMQYTiF9vyqHGiBiLiLoetLUcM");

        call.enqueue(new Callback<CompanyListModel>() {
            @Override
            public void onResponse(Call<CompanyListModel> call, Response<CompanyListModel> response) {

                if (pd.isShowing() && pd != null)
                    pd.dismiss();

                companyLists = response.body().getData();

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
                recyclerView.setLayoutManager(gridLayoutManager);
                CompanyListAdapter adapter = new CompanyListAdapter(getContext(), companyLists);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<CompanyListModel> call, Throwable t) {
                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}