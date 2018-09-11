package com.example.fenix007.hydrationreminder.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtilities {

    public static final String WATER_COUNTER_KEY = "water_counter_key";
    public static final String CHARGE_REMINDER_COUNT = "charge_reminder_count";

    private static final int DEFAULT_COUNTER = 0;

    public static Integer incrementCounter(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        int counter = pref.getInt(WATER_COUNTER_KEY, DEFAULT_COUNTER);
        pref.edit().putInt(WATER_COUNTER_KEY, ++counter).apply();

        return counter;
    }

    public static int getWaterCount(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getInt(WATER_COUNTER_KEY, DEFAULT_COUNTER);
    }

    public static int getChargeReminderCount(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getInt(CHARGE_REMINDER_COUNT, DEFAULT_COUNTER);
    }
}
