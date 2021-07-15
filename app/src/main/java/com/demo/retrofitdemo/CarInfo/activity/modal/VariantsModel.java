package com.demo.retrofitdemo.CarInfo.activity.modal;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VariantsModel {

    String message;

    ArrayList<Data> data;

    @lombok.Data
    public static class Data{
        int id;
        Engine engine;
        Fuel fuel;
        Suspension suspension;
        Dimension dimension;
        Otherfeature otherfeature;

        @lombok.Data
        public static class Engine{

            @SerializedName("Engine Type")
            String engine_Type;

            @SerializedName("Fast Charging")
            String fast_Charging;

            @SerializedName("Displacement (cc)")
            String displacement;

            @SerializedName("Max Power")
            String max_Power;

            @SerializedName("Max Torque")
            String max_Torque;

            @SerializedName("No. of cylinder")
            String no_of_cylinder;

            @SerializedName("Valves Per Cylinder")
            String valves_Per_Cylinder;

            @SerializedName("Valve Configuration")
            String valve_Configuration;

            @SerializedName("Fuel Supply System")
            String fuel_Supply_System;

            @SerializedName("Turbo Charger")
            String turbo_Charger;

            @SerializedName("Super Charge")
            String super_Charge;

            @SerializedName("TransmissionType")
            String transmissionType;

            @SerializedName("Gear Box")
            String gear_Box;

            @SerializedName("Mild Hybrid")
            String mild_Hybrid;

            @SerializedName("Drive Type")
            String drive_Type;
        }

        @lombok.Data
        public static class Fuel{
            @SerializedName("Fuel Type")
            String fuel_Type;

            @SerializedName("Mileage (ARAI)")
            String mileage;

            @SerializedName("Fuel Tank Capacity (Litres)")
            String fuel_Tank_Capacity;

            @SerializedName("Emission Norm Compliance")
            String Emission_Norm_Compliance;

            @SerializedName("Top Speed (Kmph)")
            String top_Speed;
        }

        @lombok.Data
        public static class Suspension{
            @SerializedName("Front Suspension")
            String front_Suspension;

            @SerializedName("Rear Suspension")
            String rear_Suspension;

            @SerializedName("Steering Type")
            String steering_Type;

            @SerializedName("Steering Column")
            String steering_Column;

            @SerializedName("Steering Gear Type")
            String steering_Gear_Type;

            @SerializedName("Turning Radius (Metres)")
            String turning_Radius;

            @SerializedName("Front Brake Type")
            String front_Brake_Type;

            @SerializedName("Rear Brake Type")
            String rear_Brake_Type;

            @SerializedName("Acceleration")
            String acceleration;

            @SerializedName("0-100kmph")
            String kmph;
        }

        @lombok.Data
        public static class Dimension{
            @SerializedName("Length (mm)")
            String length;

            @SerializedName("Width (mm)")
            String width;

            @SerializedName("Height (mm)")
            String height;

            @SerializedName("Boot Space (Litres)")
            String boot_Space;

            @SerializedName("Seating Capacity")
            String seating_Capacity;

            @SerializedName("Ground Clearance Unladen (mm)")
            String ground_Clearance_Unladen;

            @SerializedName("Wheel Base (mm)")
            String wheel_Base;

            @SerializedName("Front Tread (mm)")
            String front_Tread;

            @SerializedName("Rear Tread (mm)")
            String rear_Tread;

            @SerializedName("Kerb Weight (Kg)")
            String kerb_Weight;

            @SerializedName("Gross Weight (Kg)")
            String gross_Weight;

            @SerializedName("No of Doors")
            String no_of_Doors;
        }

        @lombok.Data
        public static class Otherfeature{
            @SerializedName("Parking Sensors")
            String parking_Sensors;

            @SerializedName("Foldable Rear Seat")
            String foldable_Rear_Seat;

            @SerializedName("Trunk Opener")
            String trunk_Opener;

            @SerializedName("Tyre Size")
            String tyre_Size;

            @SerializedName("Tyre Type")
            String tyre_Type;

            @SerializedName("Wheel Size")
            String wheel_Size;

            @SerializedName("Additional Features")
            String additional_Features;

            @SerializedName("No of Airbags")
            String no_of_Airbags;

            @SerializedName("Advance Safety Features")
            String advance_Safety_Features;

            @SerializedName("Anti-Pinch Power Windows")
            String antiPinch_Power_Windows;
        }
    }
}
