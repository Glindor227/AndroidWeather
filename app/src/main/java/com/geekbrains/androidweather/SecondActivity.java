package com.geekbrains.androidweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geekbrains.common.ViewParamsToSecondActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewTemp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName = findViewById(R.id.cityName);
        textViewTemp = findViewById(R.id.tempValue);
        textViewTemp.setText(R.string.tempValue);

        initViewFromDataInstance();


    }
    private void initViewFromDataInstance(){
        Object intentObj = getIntent().getSerializableExtra(MainActivity.keyDateToSecondActivity);
        if (intentObj==null){
            Log.e(MainActivity.TAG, "не получили Serializable");
            return;
        }
        ViewParamsToSecondActivity params = null;
        if(!(intentObj instanceof ViewParamsToSecondActivity)){
            Log.e(MainActivity.TAG, "не содержит  ViewParamsToSecondActivity");
            return;
        }


        params = (ViewParamsToSecondActivity)intentObj;

        String cityName = params.getCityName();
        textViewName.setText(cityName);

//        findViewById(R.id.llTemp).setVisibility(params.isEnableTemp()?View.VISIBLE:View.GONE);
        findViewById(R.id.llHum).setVisibility(params.isEnableHum()?View.VISIBLE:View.GONE);
        findViewById(R.id.llOvercast).setVisibility(params.isEnableOvercast()?View.VISIBLE:View.GONE);
        findViewById(R.id.llPressure).setVisibility(params.isEnablePressure()?View.VISIBLE:View.GONE);
        findViewById(R.id.llWind).setVisibility(params.isEnableWind()?View.VISIBLE:View.GONE);

    }
}
