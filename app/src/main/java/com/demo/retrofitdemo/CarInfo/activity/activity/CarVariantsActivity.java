package com.demo.retrofitdemo.CarInfo.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.retrofitdemo.CarInfo.activity.adapter.VariantsAdapter;
import com.demo.retrofitdemo.Apiservice;
import com.demo.retrofitdemo.AppConstant;
import com.demo.retrofitdemo.CarInfo.activity.modal.VariantsModel;
import com.demo.retrofitdemo.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarVariantsActivity extends AppCompatActivity {

    TextView engineTxt,fastcharging,displacement,maxpower,maxtorque,noofcylinder,valvespercylinder,valvesconfiguration,fuelsupplysystem,
            turbocharger,supercharger,transmissiontype,gearbox,mildhybrid,drivetype,fueltype,mileage,fueltypecapacity,emissionormcompliance,
            topspeed,fornt_suspension,rear_suspension,steering_type,steering_column,steering_gear_type,turing_radius,fornt_breake,rear_breake_type,
            acceleration,KMPH,length,width,hight,bootspace,seatingcapacity,groundclearanceuniladen,wheelbase,fronttread,reartread,
            kerbweight,grossweight,noofdoors,parkingsensors,foldablerearseat,trunkopener, tyreksize,tyretype,wheelsize,additionalfeatures,
            noofairbags,advancesaftlyfeatures,antipinchpowerwindows;

    int variants_id;
    ProgressDialog pd;
    ArrayList<VariantsModel.Data> variants_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_variants);

        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("Loading...");

        variants_id = getIntent().getIntExtra(VariantsAdapter.VARIENT_DETAILS, -1);

        init();
        getCarVariantsDetails(variants_id);


    }

    private void setEngineDetails(VariantsModel.Data.Engine engine) {
        engineTxt.setText(engine.getEngine_Type());
        fastcharging.setText(engine.getFast_Charging());
        displacement.setText(engine.getDisplacement());
        maxpower.setText(engine.getMax_Power());
        maxtorque.setText(engine.getMax_Torque());
        noofcylinder.setText(engine.getNo_of_cylinder());
        valvespercylinder.setText(engine.getValves_Per_Cylinder());
        valvesconfiguration.setText(engine.getValve_Configuration());
        fuelsupplysystem.setText(engine.getFuel_Supply_System());
        turbocharger.setText(engine.getTurbo_Charger());
        supercharger.setText(engine.getSuper_Charge());
        transmissiontype.setText(engine.getTransmissionType());
        gearbox.setText(engine.getGear_Box());
        mildhybrid.setText(engine.getMild_Hybrid());
        drivetype.setText(engine.getDrive_Type());

    }

    private void setFuelDetails(VariantsModel.Data.Fuel fuel) {
        fueltype.setText(fuel.getFuel_Type());
        mileage.setText(fuel.getMileage());
        fueltypecapacity.setText(fuel.getFuel_Tank_Capacity());
        emissionormcompliance.setText(fuel.getEmission_Norm_Compliance());
        topspeed.setText(fuel.getTop_Speed());
    }

    private void setSuspensionDetails(VariantsModel.Data.Suspension suspension) {
        fornt_suspension.setText(suspension.getFront_Suspension());
        rear_suspension.setText(suspension.getRear_Suspension());
        steering_type.setText(suspension.getSteering_Type());
        steering_column.setText(suspension.getSteering_Column());
        steering_gear_type.setText(suspension.getTurning_Radius());
        turing_radius.setText(suspension.getFront_Suspension());
        fornt_breake.setText(suspension.getFront_Brake_Type());
        rear_breake_type.setText(suspension.getRear_Brake_Type());
        acceleration.setText(suspension.getAcceleration());
        KMPH.setText(suspension.getKmph());
    }

    private void setDimensionDetails(VariantsModel.Data.Dimension dimension) {
        length.setText(dimension.getLength());
        width.setText(dimension.getWidth());
        hight.setText(dimension.getHeight());
        bootspace.setText(dimension.getBoot_Space());
        seatingcapacity.setText(dimension.getSeating_Capacity());
        groundclearanceuniladen.setText(dimension.getGround_Clearance_Unladen());
        wheelbase.setText(dimension.getWheel_Base());
        fronttread.setText(dimension.getFront_Tread());
        reartread.setText(dimension.getRear_Tread());
        kerbweight.setText(dimension.getKerb_Weight());
        grossweight.setText(dimension.getGross_Weight());
        noofdoors.setText(dimension.getNo_of_Doors());
    }

    private void setOtherfeatureDetails(VariantsModel.Data.Otherfeature otherfeature) {
        parkingsensors.setText(otherfeature.getParking_Sensors());
        foldablerearseat.setText(otherfeature.getFoldable_Rear_Seat());
        trunkopener.setText(otherfeature.getTrunk_Opener());
        tyreksize.setText(otherfeature.getTyre_Size());
        tyretype.setText(otherfeature.getTyre_Type());
        wheelsize.setText(otherfeature.getWheel_Size());
        additionalfeatures.setText(otherfeature.getAdditional_Features());
        noofairbags.setText(otherfeature.getNo_of_Airbags());
        advancesaftlyfeatures.setText(otherfeature.getAdvance_Safety_Features());
        antipinchpowerwindows.setText(otherfeature.getAntiPinch_Power_Windows());

    }


    private void getCarVariantsDetails(int variants_id) {
        pd.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiservice service = retrofit.create(Apiservice.class);

        Call<VariantsModel> call = service.getCarVariantsDetails("OMMQYTiF9vyqHGiBiLiLoetLUcM",variants_id);
        call.enqueue(new Callback<VariantsModel>(){

            @Override
            public void onResponse(Call<VariantsModel> call, Response<VariantsModel> response) {

                if (pd.isShowing() && pd != null)
                    pd.dismiss();

                    variants_model = response.body().getData();

                    setEngineDetails(variants_model.get(0).getEngine());
                    setFuelDetails(variants_model.get(0).getFuel());
                    setSuspensionDetails(variants_model.get(0).getSuspension());
                    setDimensionDetails(variants_model.get(0).getDimension());
                    setOtherfeatureDetails(variants_model.get(0).getOtherfeature());

                    Log.e("TAG", "response: " + response.body().getData().get(0).getEngine().getEngine_Type());
            }

            @Override
            public void onFailure(Call<VariantsModel> call, Throwable t) {
                if (pd.isShowing() && pd != null)
                    pd.dismiss();
                Toast.makeText(CarVariantsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        variants_model = new ArrayList<>();

        engineTxt = findViewById(R.id.engine);
        fastcharging = findViewById(R.id.fastcharging);
        displacement = findViewById(R.id.displacement);
        maxpower = findViewById(R.id.maxpower);
        maxtorque = findViewById(R.id.maxtorque);
        noofcylinder = findViewById(R.id.noofcylinder);
        valvespercylinder = findViewById(R.id.valvespercylinder);
        valvesconfiguration = findViewById(R.id.valvesconfiguration);
        fuelsupplysystem = findViewById(R.id.fuelsupplysystem);
        turbocharger = findViewById(R.id.turbocharger);
        supercharger = findViewById(R.id.supercharger);
        transmissiontype = findViewById(R.id.transmissiontype);
        gearbox = findViewById(R.id.gearbox);
        mildhybrid = findViewById(R.id.mildhybrid);
        drivetype = findViewById(R.id.drivetype);
        fueltype = findViewById(R.id.fueltype);
        mileage = findViewById(R.id.mileage);
        fueltypecapacity = findViewById(R.id.fueltypecapacity);
        emissionormcompliance = findViewById(R.id.emissionormcompliance);
        topspeed = findViewById(R.id.topspeed);
        fornt_suspension = findViewById(R.id.fornt_suspension);
        rear_suspension = findViewById(R.id.rear_suspension);
        steering_type = findViewById(R.id.steering_type);
        steering_column = findViewById(R.id.steering_column);
        steering_gear_type = findViewById(R.id.steering_gear_type);
        turing_radius = findViewById(R.id.turing_radius);
        fornt_breake = findViewById(R.id.fornt_breake);
        rear_breake_type = findViewById(R.id.rear_breake_type);
        acceleration = findViewById(R.id.acceleration);
        KMPH = findViewById(R.id.KMPH);
        length = findViewById(R.id.length);
        width = findViewById(R.id.width);
        hight = findViewById(R.id.hight);
        bootspace = findViewById(R.id.bootspace);
        seatingcapacity = findViewById(R.id.seatingcapacity);
        groundclearanceuniladen = findViewById(R.id.groundclearanceuniladen);
        wheelbase = findViewById(R.id.wheelbase);
        fronttread = findViewById(R.id.fronttread);
        reartread = findViewById(R.id.reartread);
        kerbweight = findViewById(R.id.kerbweight);
        grossweight = findViewById(R.id.grossweight);
        noofdoors = findViewById(R.id.noofdoors);
        parkingsensors = findViewById(R.id.parkingsensors);
        foldablerearseat = findViewById(R.id.foldablerearseat);
        trunkopener = findViewById(R.id.trunkopener);
        tyreksize = findViewById(R.id.trunksize);
        tyretype = findViewById(R.id.tyretype);
        wheelsize = findViewById(R.id.wheelsize);
        additionalfeatures = findViewById(R.id.additionalfeatures);
        noofairbags = findViewById(R.id.noofairbags);
        advancesaftlyfeatures = findViewById(R.id.advancesaftlyfeatures);
        antipinchpowerwindows = findViewById(R.id.antipinchpowerwindows);
    }
}