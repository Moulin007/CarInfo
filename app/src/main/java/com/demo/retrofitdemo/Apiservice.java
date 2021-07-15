package com.demo.retrofitdemo;

import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.demo.retrofitdemo.CarInfo.activity.modal.CompanyListModel;
import com.demo.retrofitdemo.CarInfo.activity.modal.VariantsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Apiservice {

    @GET("api/v1/company-list")
    Call<CompanyListModel> getCompanyList(
            @Header("AuthorizationKey") String token
    );

    @FormUrlEncoded
    @POST("api/v1/car-model-list")
    Call<CarListModel> getCarFromCompany(
            @Header("AuthorizationKey") String token,
            @Field("company_id") int company_id
    );


    @FormUrlEncoded
    @POST("api/v1/car-model-list")
    Call<CarListModel> getCarDetailsFromCompany(
            @Header("AuthorizationKey") String token,
            @Field("company_id") int company_id
    );

    @FormUrlEncoded
    @POST("api/v1/car-variant-detail")
    Call<VariantsModel> getCarVariantsDetails(
            @Header("AuthorizationKey") String token,
            @Field("variant_id") int variant_id
    );
}