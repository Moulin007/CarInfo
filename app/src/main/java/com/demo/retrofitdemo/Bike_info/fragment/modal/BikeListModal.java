package com.demo.retrofitdemo.Bike_info.fragment.modal;

import com.demo.retrofitdemo.CarInfo.activity.modal.CompanyListModel;

import java.util.ArrayList;

public class BikeListModal {

    boolean status;
    String message;
    ArrayList<BikeList> data;

    public static class BikeList {

        int id;
        String company_name;
        String company_logo;

        public int getId() {
            return id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public String getCompany_logo() {
            return company_logo;
        }
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<BikeList> getData() {
        return data;
    }
}
