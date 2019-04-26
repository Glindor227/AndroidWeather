package com.geekbrains.androidweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "GlindorLog";
    TextView counterTextView;

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

        counterTextView = findViewById(R.id.counterText);

        findViewById(R.id.toSecondActivityBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.increaseCounterBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(counterTextView.getText().toString());
                String text = String.valueOf(++counter);
                counterTextView.setText(text);
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