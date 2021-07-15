package com.demo.retrofitdemo.CarInfo.activity.modal;

import java.util.ArrayList;

public class CompanyListModel {

    boolean status;
    String message;
    ArrayList<CompanyList> data;

    public static class CompanyList
    {
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

    public ArrayList<CompanyList> getData() {
        return data;
    }
}
