package com.demo.retrofitdemo;

import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeListModal;
import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeModel;
import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeVariantsModel;
import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.CarInfo.activity.modal.CompanyListModel;
import com.demo.retrofitdemo.CarInfo.activity.modal.VariantsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BikeApiService {

    @GET("api/bike-v1/company-list")
    Call<BikeListModal> getBikeList(
            @Header("AuthorizationKey") String token
    );

    @FormUrlEncoded
    @POST("api/bike-v1/bike-model-list")
    Call<BikeModel> getBikeFromCompany(
            @Header("AuthorizationKey") String token,
            @Field("company_id") int company_id
    );

    @FormUrlEncoded
    @POST("api/bike-v1/bike-model-list")
    Call<BikeModel> getBikeDetailsFromCompany(
            @Header("AuthorizationKey") String token,
            @Field("company_id") int company_id
    );

    @FormUrlEncoded
    @POST("api/bike-v1/bike-variant-detail")
    Call<BikeVariantsModel> getBikeVariantsDetails(
            @Header("AuthorizationKey") String token,
            @Field("variant_id") int variant_id
    );
}
