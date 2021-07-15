package com.demo.retrofitdemo.Bike_info.fragment.modal;

import com.demo.retrofitdemo.CarInfo.activity.modal.VariantsModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BikeVariantsModel {

    String message;

    ArrayList<Data> data;

    @lombok.Data
    public static class Data{
        int id;
        Engine engine;
        Milege milege;
        Features features;
        Chassis chassis;
        Dimensions dimensions;
        Electicals electicals;
        Type type;
        Others others;

        @lombok.Data
        public static class Engine {

            @SerializedName("Engine Type")
            String engine_Type;

            @SerializedName("Displacement")
            String Displacement;

            @SerializedName("Max Power")
            String Max_Power;

            @SerializedName("Max Torque")
            String Max_Torque;

            @SerializedName("No. of Cylinders")
            String No_of_Cylinders;

            @SerializedName("Cooling System")
            String Cooling_System;

            @SerializedName("Valve Per Cylinder")
            String Valve_Per_Cylinder;

            @SerializedName("Drive Type")
            String Drive_Type;

            @SerializedName("Starting")
            String Starting;

            @SerializedName("Fuel Supply")
            String Fuel_Supply;

            @SerializedName("Clutch")
            String Clutch;

            @SerializedName("Transmission")
            String Transmission;

            @SerializedName("Gear Box")
            String Gear_Box;

            @SerializedName("Bore")
            String Bore;

            @SerializedName("Stroke")
            String Stroke;

            @SerializedName("Compression Ratio")
            String Compression_Ratio;

            @SerializedName("Emission Type")
            String Emission_Type;

            @SerializedName("Ignition")
            String Ignition;
        }

        @lombok.Data
        public static class Milege {

            @SerializedName("City Mileage")
            String City_Mileage;

            @SerializedName("Highway Mileage")
            String Highway_Mileage;

            @SerializedName("Max Speed")
            String Max_Speed;

            @SerializedName("Acceleration (0-60 Kmph)")
            String Acceleration;

            @SerializedName("Acceleration (0-80 Kmph)")
            String acceleration;

            @SerializedName("Quarter Mile")
            String Quarter_Mile;

            @SerializedName("Braking (60-0 Kmph)")
            String Braking;
        }

        @lombok.Data
        public static class Features {

            @SerializedName("ABS")
            String ABS;

            @SerializedName("Braking Type")
            String Braking_Type;

            @SerializedName("Speedometer")
            String Speedometer;

            @SerializedName("Tachometer")
            String Tachometer;

            @SerializedName("Odometer")
            String Odometer;

            @SerializedName("Tripmeter")
            String Tripmeter;

            @SerializedName("Fuel Gauge")
            String Fuel_Gauge;

            @SerializedName("Console")
            String Console;

            @SerializedName("Pass Switch")
            String Pass_Switch;

            @SerializedName("Passenger Footrest")
            String Passenger_Footrest;

            @SerializedName("Clock")
            String Clock;

            @SerializedName("Additional Features")
            String Additional_Features;

            @SerializedName("Display")
            String Display;

            @SerializedName("Service Due Indicator")
            String Service_Due_Indicator;

            @SerializedName("External Fuel Filling")
            String External_Fuel_Filling;

            @SerializedName("Carry Hook")
            String Carry_Hook;

            @SerializedName("Real Time Mileage Indicator")
            String Real_Time_Mileage_Indicator;

            @SerializedName("Charging Point")
            String Charging_Point;

            @SerializedName("Stepup Seat")
            String Stepup_Seat;

            @SerializedName("i3s Technology")
            String i3s_Technology;
        }

        @lombok.Data
        public static class Chassis {

            @SerializedName("Chassis")
            String Chassis;

            @SerializedName("Body Type")
            String Body_Type;

            @SerializedName("Front Suspension")
            String Front_Suspension;

            @SerializedName("Rear Suspension")
            String Rear_Suspension;

            @SerializedName("Body Graphics")
            String Body_Graphics;
            private String text;
        }

        @lombok.Data
        public static class Dimensions {

            @SerializedName("Length")
            String Length;

            @SerializedName("Width")
            String Width;

            @SerializedName("Height")
            String Height;

            @SerializedName("Fuel Capacity")
            String Fuel_Capacity;

            @SerializedName("Ground Clearance")
            String Ground_Clearance;

            @SerializedName("Wheelbase")
            String Wheelbase;

            @SerializedName("Kerb Weight")
            String Kerb_Weight;

            @SerializedName("Saddle Height")
            String Saddle_Height;

            @SerializedName("Underseat storage")
            String Underseat_storage;

            @SerializedName("Load Capacity")
            String Load_Capacity;
        }

        @lombok.Data
        public static class Electicals {

            @SerializedName("Headlight")
            String Headlight;

            @SerializedName("Tail Light")
            String Tail_Light;

            @SerializedName("Turn Signal Lamp")
            String Turn_Signal_Lamp;

            @SerializedName("DRLs")
            String DRLs;

            @SerializedName("Low Battery Indicator")
            String Low_Battery_Indicator;

            @SerializedName("Low Fuel Indicator")
            String Low_Fuel_Indicator;

            @SerializedName("Battery Capacity")
            String Battery_Capacity;

            @SerializedName("Navigation")
            String Navigation;

            @SerializedName("LED Tail Lights")
            String LED_Tail_Lights;

            @SerializedName("Battery Type")
            String Battery_Type;

            @SerializedName("Mobile Connectivity")
            String Mobile_Connectivity;

            @SerializedName("Boot Light")
            String Boot_Light;
        }

        @lombok.Data
        public static class Type {

            @SerializedName("Tyre Size")
            String Tyre_Size;

            @SerializedName("Tyre Type")
            String Tyre_Type;

            @SerializedName("Wheel Size")
            String Wheel_Size;

            @SerializedName("Wheels Type")
            String Wheels_Type;

            @SerializedName("Front Brake")
            String Front_Brake;

            @SerializedName("Rear Brake")
            String Rear_Brake;

            @SerializedName("Front Brake Diameter")
            String Front_Brake_Diameter;

            @SerializedName("Rear Brake Diameter")
            String Rear_Brake_Diameter;

            @SerializedName("Radial Tyre")
            String Radial_Tyre;

            @SerializedName("Front Tyre Pressure (Rider)")
            String Front_Tyre_Pressure;

            @SerializedName("Rear Tyre Pressure (Rider)")
            String Rear_Tyre_Pressure;

            @SerializedName("Front Tyre Pressure (Rider & Pillion)")
            String Front_TyrePressure;

            @SerializedName("Rear Tyre Pressure (Rider & Pillion)")
            String Rear_TyrePressure;
        }

        @lombok.Data
        public static class Others {

            @SerializedName("Fuel Reserve")
            String Fuel_Reserve;

            @SerializedName("Pilot Lamps")
            String Pilot_Lamps;

            @SerializedName("Traction Control")
            String Traction_Control;

            @SerializedName("Engine Kill Switch")
            String Engine_Kill_Switch;

            @SerializedName("Seat Opening Switch")
            String Seat_Opening_Switch;

            @SerializedName("Distance to Empty Indicator")
            String Distance_to_Empty_Indicator;

            @SerializedName("Motor Type")
            String Motor_Type;

            @SerializedName("Motor Power")
            String Motor_Power;

            @SerializedName("Range")
            String Range;

            @SerializedName("Battery Charging Time")
            String Battery_Charging_Time;

            @SerializedName("Fast Charging")
            String Fast_Charging;

            @SerializedName("Riding Modes")
            String Riding_Modes;

            @SerializedName("Projector Headlights")
            String Projector_Headlights;

            @SerializedName("Engine Immobilizer")
            String Engine_Immobilizer;

            @SerializedName("Anti Theft Alarm")
            String Anti_Theft_Alarm;

            @SerializedName("ARAI Mileage")
            String ARAI_Mileage;

            @SerializedName("Acceleration (0-40 Kmph)")
            String Acceleration;

            @SerializedName("Average Fuel economy Indicator")
            String Average_Fuel_economy_Indicator;
        }

    }
}
