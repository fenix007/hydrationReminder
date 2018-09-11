package com.example.fenix007.hydrationreminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fenix007.hydrationreminder.sync.ReminderTask;
import com.example.fenix007.hydrationreminder.sync.WaterReminderIntentService;
import com.example.fenix007.hydrationreminder.utilities.PreferenceUtilities;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private TextView mWaterCounterDisplay;
    private TextView mChargingReminderCountDisplay;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWaterCounterDisplay = (TextView) findViewById(R.id.tv_water_counter);
        mChargingReminderCountDisplay = (TextView) findViewById(R.id.tv_charging_reminder_count);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public void incrementCounter(View view) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(this,"GLUG GLUG GLUG", Toast.LENGTH_SHORT);
        mToast.show();

        Intent intent = new Intent(this, WaterReminderIntentService.class);
        intent.setAction(ReminderTask.ACTION_INCREMENT_WATER_COUNT);
        startService(intent);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (PreferenceUtilities.WATER_COUNTER_KEY.equals(key)) {
            updateWaterCounter();
        }
    }

    private void updateWaterCounter() {
        int waterCount = PreferenceUtilities.getWaterCount(this);
        mWaterCounterDisplay.setText(waterCount + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }
}
