package com.example.android_chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.SystemClock;
public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    private ImageView mQuitButton;
    private ImageView mCounterButton;
    private Chronometer mChronometer;
    public static boolean mStartCounter = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setClickListener();
    }
    private void initView() {
        mQuitButton = findViewById(R.id.quit_btn);
        mCounterButton = findViewById(R.id.counter_btn);
        mChronometer = findViewById(R.id.counter);
    }
    private void setClickListener() {
        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        mCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (false == mStartCounter) {
                    mCounterButton.setImageResource(R.mipmap.counter_active);
                    mStartCounter = true;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mChronometer.setVisibility(View.VISIBLE);
                            mChronometer.setBase(SystemClock.elapsedRealtime());
                            mChronometer.start();
                        }
                    });
                }
                else {
                    mStartCounter = false;
                    mCounterButton.setImageResource(R.mipmap.counter_unactive);
                    mChronometer.setVisibility(View.GONE);
                    mChronometer.stop();
                }
            }
        });
    }
}