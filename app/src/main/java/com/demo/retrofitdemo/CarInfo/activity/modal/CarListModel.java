package com.demo.retrofitdemo.CarInfo.activity.modal;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import javax.sql.RowSet;

public class CarListModel {

    @SerializedName("status")
    boolean status;

    String message;

    ArrayList<CarList> data;


    public static class CarList {
        int id;
        String model_name;
        String ex_showroom_price;
        String image;
        ArrayList<String> model_color;
        ArrayList<String> model_images;
        String model_variants;

        public int getId() {
            return id;
        }

        public String getModel_name() {
            return model_name;
        }

        public String getEx_showroom_price() {
            return ex_showroom_price;
        }

        public String getImage() {
            return image;
        }

        public ArrayList<String> getModel_color() {
            return model_color;
        }

        public ArrayList<String> getModel_images() {
            return model_images;
        }


        ArrayList<Car_Variants> car_variants;

        public static class Car_Variants {
            int id;
            String variant_price;
            String variant_name;
            String transmission_type;
            String fuel_type;
            String engine_disp;

            public int getId() {
                return id;
            }

            public String getVariant_price() {
                return variant_price;
            }

            public String getVariant_name() {
                return variant_name;
            }

            public String getTransmission_type() {
                return transmission_type;
            }

            public String getFuel_type() {
                return fuel_type;
            }

            public String getEngine_disp() {
                return engine_disp;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setVariant_price(String variant_price) {
                this.variant_price = variant_price;
            }

            public void setVariant_name(String variant_name) {
                this.variant_name = variant_name;
            }

            public void setTransmission_type(String transmission_type) {
                this.transmission_type = transmission_type;
            }

            public void setFuel_type(String fuel_type) {
                this.fuel_type = fuel_type;
            }

            public void setEngine_disp(String engine_disp) {
                this.engine_disp = engine_disp;
            }
        }
        public String getModel_variants() {
            return model_variants;
        }
    }



    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<CarList> getData() {
        return data;
    }


}