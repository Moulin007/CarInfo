package com.demo.retrofitdemo.Bike_info.fragment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.retrofitdemo.Apiservice;
import com.demo.retrofitdemo.AppConstant;
import com.demo.retrofitdemo.BikeApiService;
import com.demo.retrofitdemo.Bike_info.fragment.adapter.BikeVariantsAdapter;
import com.demo.retrofitdemo.Bike_info.fragment.modal.BikeVariantsModel;
import com.demo.retrofitdemo.CarInfo.activity.activity.CarVariantsActivity;
import com.demo.retrofitdemo.CarInfo.activity.adapter.VariantsAdapter;
import com.demo.retrofitdemo.CarInfo.activity.modal.VariantsModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BikeVariantActivity extends AppCompatActivity {

    TextView engine, displacement, maxpower, maxtorque, noofcylinder, cooling_system, valve_per_cylinder, drive_type, starting, fuel_supply,
            clutch, tramsmission, gear_box, bore, stroke, compression, emission_type, ignition, city_mileage, highway_mileage, max_speed,
            acceleration, acceleration0_80, quarter_mile, braking, abs, braking_type, speedometer, tachometer, odometer, tripmeter, fuel_gauge,
            console, pass_switch, passenger_footrest, clock, additional_Features, display, service_due_indicator, external_fuel_filling, carry_hook,
            real_time_mileage, charging_point, stepup_seat, i3s_technology, chassis, body_type, front_suspention, rear_suspention, body_graphics,
            length, wigth, height, fuel_capacity, ground_clearance, wheel_base, kerb_weight, saddle_height, underseat_storage, load_capacity,
            headlight, tail_light, turn_signal_lamp, drls, low_battery_indicator, low_fuel_indicator, battery_capacity, navigation, led_tail_lights,
            battery_type, mobile_connectivity, boot_light, tyre_size, tyre_type, wheel_size, wheel_type, front_brake, rear_brake, front_brake_diameter,
            rear_brake_diameter, radial_tyre, front_tyre_pessure, rear_tyre_pressure, front_tyre_pessure2, rear_tyre_pressure2, fuel_reserve,
            pilot_lamps, traction_control, engine_kill_switch, seat_opening_switch, distance_to_empty, motor_type, motor_power, range, battery_charging_time,
            fast_charging, ridding_modes, projector_headlight, engine_immobilizer, anti_theft_alarm, arai_mileage, acceleration0_40, average_fuel_economy;

    int variants_id;
    ProgressDialog pd;
    ArrayList<BikeVariantsModel.Data> variants_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_variant);

        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Loading...");

        variants_id = getIntent().getIntExtra(BikeVariantsAdapter.VARIENT_DETAILS, -1);

        init();
        getBikeVariantsDetails(variants_id);
    }

    private void setEngineDetails(BikeVariantsModel.Data.Engine engineDetails) {
        engine.setText(engineDetails.getEngine_Type());
        displacement.setText(engineDetails.getDisplacement());
        maxpower.setText(engineDetails.getMax_Power());
        maxtorque.setText(engineDetails.getMax_Torque());
        noofcylinder.setText(engineDetails.getNo_of_Cylinders());
        cooling_system.setText(engineDetails.getCooling_System());
        valve_per_cylinder.setText(engineDetails.getValve_Per_Cylinder());
        drive_type.setText(engineDetails.getDrive_Type());
        starting.setText(engineDetails.getStarting());
        fuel_supply.setText(engineDetails.getFuel_Supply());
        clutch.setText(engineDetails.getClutch());
        tramsmission.setText(engineDetails.getTransmission());
        gear_box.setText(engineDetails.getGear_Box());
        bore.setText(engineDetails.getBore());
        stroke.setText(engineDetails.getStroke());
        compression.setText(engineDetails.getCompression_Ratio());
        emission_type.setText(engineDetails.getEmission_Type());
        ignition.setText(engineDetails.getIgnition());
    }

    private void setMilegeDetails(BikeVariantsModel.Data.Milege milege) {
        city_mileage.setText(milege.getCity_Mileage());
        highway_mileage.setText(milege.getHighway_Mileage());
        max_speed.setText(milege.getMax_Speed());
        acceleration.setText(milege.getAcceleration());
        acceleration0_80.setText(milege.getAcceleration());
        quarter_mile.setText(milege.getQuarter_Mile());
        braking.setText(milege.getBraking());
    }

    private void setFeaturesDetails(BikeVariantsModel.Data.Features features) {
        abs.setText(features.getABS());
        braking_type.setText(features.getBraking_Type());
        speedometer.setText(features.getSpeedometer());
        tachometer.setText(features.getTachometer());
        odometer.setText(features.getOdometer());
        tripmeter.setText(features.getTripmeter());
        fuel_gauge.setText(features.getFuel_Gauge());
        console.setText(features.getConsole());
        pass_switch.setText(features.getPass_Switch());
        passenger_footrest.setText(features.getPassenger_Footrest());
        clock.setText(features.getClock());
        additional_Features.setText(features.getAdditional_Features());
        display.setText(features.getDisplay());
        service_due_indicator.setText(features.getService_Due_Indicator());
        external_fuel_filling.setText(features.getExternal_Fuel_Filling());
        carry_hook.setText(features.getCarry_Hook());
        real_time_mileage.setText(features.getReal_Time_Mileage_Indicator());
        charging_point.setText(features.getCharging_Point());
        stepup_seat.setText(features.getStepup_Seat());
        i3s_technology.setText(features.getI3s_Technology());
    }

    private void setChassisDetails(BikeVariantsModel.Data.Chassis chassisDetails) {
        chassis.setText(chassisDetails.getChassis());
        body_type.setText(chassisDetails.getBody_Type());
        front_suspention.setText(chassisDetails.getFront_Suspension());
        rear_suspention.setText(chassisDetails.getRear_Suspension());
        body_graphics.setText(chassisDetails.getBody_Graphics());
    }


    private void setDimensionDetails(BikeVariantsModel.Data.Dimensions dimensions) {
        length.setText(dimensions.getLength());
        wigth.setText(dimensions.getWidth());
        height.setText(dimensions.getHeight());
        fuel_capacity.setText(dimensions.getFuel_Capacity());
        ground_clearance.setText(dimensions.getGround_Clearance());
        wheel_base.setText(dimensions.getWheelbase());
        kerb_weight.setText(dimensions.getKerb_Weight());
        saddle_height.setText(dimensions.getSaddle_Height());
        underseat_storage.setText(dimensions.getUnderseat_storage());
        load_capacity.setText(dimensions.getLoad_Capacity());
    }

    private void setElecticalsDetails(BikeVariantsModel.Data.Electicals electicals) {
        headlight.setText(electicals.getHeadlight());
        tail_light.setText(electicals.getLED_Tail_Lights());
        turn_signal_lamp.setText(electicals.getTurn_Signal_Lamp());
        drls.setText(electicals.getDRLs());
        low_battery_indicator.setText(electicals.getLow_Battery_Indicator());
        low_fuel_indicator.setText(electicals.getLow_Fuel_Indicator());
        battery_capacity.setText(electicals.getBattery_Capacity());
        navigation.setText(electicals.getNavigation());
        led_tail_lights.setText(electicals.getLED_Tail_Lights());
        battery_type.setText(electicals.getBattery_Type());
        mobile_connectivity.setText(electicals.getMobile_Connectivity());
        boot_light.setText(electicals.getBoot_Light());
    }

    private void setTypeDetails(BikeVariantsModel.Data.Type type) {
        tyre_size.setText(type.getTyre_Type());
        tyre_type.setText(type.getTyre_Type());
        wheel_size.setText(type.getWheel_Size());
        wheel_type.setText(type.getWheels_Type());
        front_brake.setText(type.getFront_Brake());
        rear_brake.setText(type.getRear_Brake());
        front_brake_diameter.setText(type.getFront_Brake_Diameter());
        rear_brake_diameter.setText(type.getRear_Brake_Diameter());
        radial_tyre.setText(type.getRadial_Tyre());
        front_tyre_pessure.setText(type.getFront_TyrePressure());
        rear_tyre_pressure.setText(type.getRear_TyrePressure());
        front_tyre_pessure2.setText(type.getFront_Tyre_Pressure());
        rear_tyre_pressure2.setText(type.getRear_Tyre_Pressure());
    }

    private void setOtherDetails(BikeVariantsModel.Data.Others others) {
        fuel_reserve.setText(others.getFuel_Reserve());
        pilot_lamps.setText(others.getPilot_Lamps());
        traction_control.setText(others.getTraction_Control());
        engine_kill_switch.setText(others.getEngine_Kill_Switch());
        seat_opening_switch.setText(others.getSeat_Opening_Switch());
        distance_to_empty.setText(others.getDistance_to_Empty_Indicator());
        motor_type.setText(others.getMotor_Type());
        motor_power.setText(others.getMotor_Power());
        range.setText(others.getRange());
        battery_charging_time.setText(others.getBattery_Charging_Time());
        fast_charging.setText(others.getFast_Charging());
        ridding_modes.setText(others.getRiding_Modes());
        projector_headlight.setText(others.getProjector_Headlights());
        engine_immobilizer.setText(others.getEngine_Immobilizer());
        anti_theft_alarm.setText(others.getAnti_Theft_Alarm());
        arai_mileage.setText(others.getARAI_Mileage());
        acceleration0_40.setText(others.getAcceleration());
        average_fuel_economy.setText(others.getAverage_Fuel_economy_Indicator());
        fuel_reserve.setText(others.getFuel_Reserve());
    }

    private void getBikeVariantsDetails(int variants_id) {
        pd.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BikeApiService service = retrofit.create(BikeApiService.class);

        Call<BikeVariantsModel> call = service.getBikeVariantsDetails("OMMQYTiF9vyqHGiBiLiLoetLUcM",variants_id);
        call.enqueue(new Callback<BikeVariantsModel>(){

            @Override
            public void onResponse(Call<BikeVariantsModel> call, Response<BikeVariantsModel> response) {

                if (pd.isShowing() && pd != null)
                    pd.dismiss();

                variants_model = response.body().getData();

                setEngineDetails(variants_model.get(0).getEngine());
                setMilegeDetails(variants_model.get(0).getMilege());
                setFeaturesDetails(variants_model.get(0).getFeatures());
                setChassisDetails(variants_model.get(0).getChassis());
                setDimensionDetails(variants_model.get(0).getDimensions());
                setElecticalsDetails(variants_model.get(0).getElecticals());
                setTypeDetails(variants_model.get(0).getType());
                setOtherDetails(variants_model.get(0).getOthers());

            }

            @Override
            public void onFailure(Call<BikeVariantsModel> call, Throwable t) {
                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                Toast.makeText(BikeVariantActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void init() {
        variants_model = new ArrayList<>();

        engine = findViewById(R.id.engine);
        displacement = findViewById(R.id.displacement);
        maxpower = findViewById(R.id.maxpower);
        maxtorque = findViewById(R.id.maxtorque);
        noofcylinder = findViewById(R.id.noofcylinder);
        cooling_system = findViewById(R.id.cooling_system);
        valve_per_cylinder = findViewById(R.id.valve_per_cylinder);
        drive_type = findViewById(R.id.drive_type);
        drive_type = findViewById(R.id.drive_type);
        starting = findViewById(R.id.starting);
        fuel_supply = findViewById(R.id.fuel_supply);
        tramsmission = findViewById(R.id.tramsmission);
        bore = findViewById(R.id.bore);
        gear_box = findViewById(R.id.gear_box);
        stroke = findViewById(R.id.stroke);
        compression = findViewById(R.id.compression);
        emission_type = findViewById(R.id.emission_type);
        clock = findViewById(R.id.clock);
        emission_type = findViewById(R.id.emission_type);
        ignition = findViewById(R.id.ignition);
        city_mileage = findViewById(R.id.city_mileage);
        highway_mileage = findViewById(R.id.highway_mileage);
        max_speed = findViewById(R.id.max_speed);
        clutch = findViewById(R.id.clutch);
        acceleration = findViewById(R.id.acceleration);
        acceleration0_80 = findViewById(R.id.acceleration2);
        quarter_mile = findViewById(R.id.quarter_mile);
        braking = findViewById(R.id.braking);
        abs = findViewById(R.id.abs);
        braking_type = findViewById(R.id.braking_type);
        speedometer = findViewById(R.id.speedometer);
        tachometer = findViewById(R.id.tachometer);
        odometer = findViewById(R.id.odometer);
        tripmeter = findViewById(R.id.tripmeter);
        fuel_gauge = findViewById(R.id.fuel_gauge);
        console = findViewById(R.id.console);
        pass_switch = findViewById(R.id.pass_switch);
        passenger_footrest = findViewById(R.id.passenger_footrest);
        additional_Features = findViewById(R.id.additional_Features);
        display = findViewById(R.id.display);
        service_due_indicator = findViewById(R.id.service_due_indicator);
        external_fuel_filling = findViewById(R.id.external_fuel_filling);
        carry_hook = findViewById(R.id.carry_hook);
        real_time_mileage = findViewById(R.id.real_time_mileage);
        charging_point = findViewById(R.id.charging_point);
        stepup_seat = findViewById(R.id.stepup_seat);
        i3s_technology = findViewById(R.id.i3s_technology);
        chassis = findViewById(R.id.chassis);
        body_type = findViewById(R.id.body_type);
        front_suspention = findViewById(R.id.front_suspention);
        rear_suspention = findViewById(R.id.rear_suspention);
        body_graphics = findViewById(R.id.body_graphics);
        length = findViewById(R.id.length);
        wigth = findViewById(R.id.wigth);
        height = findViewById(R.id.height);
        fuel_capacity = findViewById(R.id.fuel_capacity);
        ground_clearance = findViewById(R.id.ground_clearance);
        wheel_base = findViewById(R.id.wheel_base);
        kerb_weight = findViewById(R.id.kerb_weight);
        saddle_height = findViewById(R.id.saddle_height);
        underseat_storage = findViewById(R.id.underseat_storage);
        load_capacity = findViewById(R.id.load_capacity);
        headlight = findViewById(R.id.headlight);
        tail_light = findViewById(R.id.tail_light);
        turn_signal_lamp = findViewById(R.id.turn_signal_lamp);
        drls = findViewById(R.id.drls);
        low_battery_indicator = findViewById(R.id.low_battery_indicator);
        low_fuel_indicator = findViewById(R.id.low_fuel_indicator);
        battery_capacity = findViewById(R.id.battery_capacity);
        navigation = findViewById(R.id.navigation);
        led_tail_lights = findViewById(R.id.led_tail_lights);
        battery_type = findViewById(R.id.battery_type);
        mobile_connectivity = findViewById(R.id.mobile_connectivity);
        boot_light = findViewById(R.id.boot_light);
        tyre_size = findViewById(R.id.tyre_size);
        tyre_type = findViewById(R.id.tyre_type);
        wheel_size = findViewById(R.id.wheel_size);
        wheel_type = findViewById(R.id.wheel_type);
        front_brake = findViewById(R.id.front_brake);
        rear_brake = findViewById(R.id.rear_brake);
        front_brake_diameter = findViewById(R.id.front_brake_diameter);
        rear_brake_diameter = findViewById(R.id.rear_brake_diameter);
        radial_tyre = findViewById(R.id.radial_tyre);
        front_tyre_pessure = findViewById(R.id.front_tyre_pessure);
        rear_tyre_pressure = findViewById(R.id.rear_tyre_pressure);
        front_tyre_pessure2 = findViewById(R.id.front_tyre_pessure2);
        rear_tyre_pressure2 = findViewById(R.id.rear_tyre_pressure2);
        fuel_reserve = findViewById(R.id.fuel_reserve);
        pilot_lamps = findViewById(R.id.pilot_lamps);
        traction_control = findViewById(R.id.traction_control);
        engine_kill_switch = findViewById(R.id.engine_kill_switch);
        seat_opening_switch = findViewById(R.id.seat_opening_switch);
        distance_to_empty = findViewById(R.id.distance_to_empty);
        motor_type = findViewById(R.id.motor_type);
        motor_power = findViewById(R.id.motor_power);
        range = findViewById(R.id.range);
        battery_charging_time = findViewById(R.id.battery_charging_time);
        fast_charging = findViewById(R.id.fast_charging);
        ridding_modes = findViewById(R.id.ridding_modes);
        projector_headlight = findViewById(R.id.projector_headlight);
        engine_immobilizer = findViewById(R.id.engine_immobilizer);
        anti_theft_alarm = findViewById(R.id.anti_theft_alarm);
        arai_mileage = findViewById(R.id.arai_mileage);
        acceleration0_40 = findViewById(R.id.acceleration0_40);
        average_fuel_economy = findViewById(R.id.average_fuel_economy);
    }
}