package com.geekbrains.androidweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.geekbrains.common.ViewParamsToSecondActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "GlindorLog";

    private EditText viewCityName;
    private CheckBox viewCityHum;
    private CheckBox viewCityOvercast;
    private CheckBox viewCityWind;
    private CheckBox viewCityPressure;

    static final String keyDateToSecondActivity = "ToSecondActivity";
    private void viewCycleInfo(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if (savedInstanceState == null)
            instanceState = "Первая загрузка ";
        else
            instanceState = "повторная загрузка ";
        viewCycleInfo(instanceState + "onCreate");

        initView();
        initButton();

    }

    private void initView() {
        viewCityName = findViewById(R.id.editText);
        viewCityHum = findViewById(R.id.checkBoxHumidity);
        viewCityOvercast = findViewById(R.id.checkBoxOvercast);
        viewCityWind = findViewById(R.id.checkBoxWind);
        viewCityPressure = findViewById(R.id.checkBoxPressure);
    }
    private void initButton() {

        findViewById(R.id.toSecondActivityBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(keyDateToSecondActivity,new ViewParamsToSecondActivity(viewCityName.getText().toString(),
                        viewCityHum.isChecked(),
                        viewCityOvercast.isChecked(),
                        viewCityWind.isChecked(),
                        viewCityPressure.isChecked()
                        ));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewCycleInfo("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewCycleInfo("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewCycleInfo("onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        viewCycleInfo("onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewCycleInfo("onStop");
    }
}