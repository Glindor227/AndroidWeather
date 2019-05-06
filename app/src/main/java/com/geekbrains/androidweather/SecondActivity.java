package com.geekbrains.androidweather;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geekbrains.common.ViewParamsToSecondActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName = findViewById(R.id.cityName);
        TextView textViewTemp = findViewById(R.id.tempValue);
        textViewTemp.setText(R.string.tempValue);

        Drawable drawable = ContextCompat.getDrawable(this,R.drawable.overcast1);
        ImageView imageView = findViewById(R.id.overcastValue);
        imageView.setImageDrawable(drawable);

        initViewFromDataInstance();


    }
    private void initViewFromDataInstance(){
        Object intentObj = getIntent().getSerializableExtra(MainActivity.keyDateToSecondActivity);
        if (intentObj==null){
            Log.e(MainActivity.TAG, "не получили Serializable");
            return;
        }
        ViewParamsToSecondActivity params;
        if(!(intentObj instanceof ViewParamsToSecondActivity)){
            Log.e(MainActivity.TAG, "не содержит  ViewParamsToSecondActivity");
            return;
        }


        params = (ViewParamsToSecondActivity)intentObj;

        String cityName = params.getCityName();
        textViewName.setText(cityName);

        findViewById(R.id.llHum).setVisibility(params.isEnableHum()?View.VISIBLE:View.GONE);
        findViewById(R.id.llOvercast).setVisibility(params.isEnableOvercast()?View.VISIBLE:View.GONE);
        findViewById(R.id.llPressure).setVisibility(params.isEnablePressure()?View.VISIBLE:View.GONE);
        findViewById(R.id.llWind).setVisibility(params.isEnableWind()?View.VISIBLE:View.GONE);

    }
}
