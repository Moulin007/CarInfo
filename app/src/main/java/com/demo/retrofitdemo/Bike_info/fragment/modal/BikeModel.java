package com.demo.retrofitdemo.Bike_info.fragment.modal;

import com.demo.retrofitdemo.CarInfo.activity.modal.CarListModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BikeModel {


    @SerializedName("status")
    boolean status;

    String message;

    ArrayList<BikeModelList> data;

    public static class BikeModelList {
        int id;
        String model_name;
        String model_price;
        String model_image;
        ArrayList<String> model_color;
        ArrayList<String> model_images;
        String model_variants;


        public int getId() {
            return id;
        }

        public String getModel_name() {
            return model_name;
        }

        public String getModel_price() {
            return model_price;
        }

        public String getModel_image() {
            return model_image;
        }

        public ArrayList<String> getModel_color() {
            return model_color;
        }

        public ArrayList<String> getModel_images() {
            return model_images;
        }

        public String getModel_variants() {
            return model_variants;
        }

        ArrayList<Bike_Variants> bike_variants;

        public static class Bike_Variants {

            int id;
            String variant_price;
            String variant_name;
            String engine_disp;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getVariant_price() {
                return variant_price;
            }

            public void setVariant_price(String variant_price) {
                this.variant_price = variant_price;
            }

            public String getVariant_name() {
                return variant_name;
            }

            public void setVariant_name(String variant_name) {
                this.variant_name = variant_name;
            }

            public String getEngine_disp() {
                return engine_disp;
            }

            public void setEngine_disp(String engine_disp) {
                this.engine_disp = engine_disp;
            }
        }
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<BikeModelList> getData() {
        return data;
    }


}
