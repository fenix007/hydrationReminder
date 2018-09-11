package com.example.fenix007.hydrationreminder.sync;

import android.content.Context;

import com.example.fenix007.hydrationreminder.utilities.PreferenceUtilities;

public class ReminderTask {
    public static final String ACTION_INCREMENT_WATER_COUNT = "ACTION_INCREMENT_WATER_COUNT";

    public static void executeTask(Context context, String action) {
        if (action.equals(ACTION_INCREMENT_WATER_COUNT)) {
            incrementWaterCounter(context);
        }
    }

    private static void incrementWaterCounter(Context context) {
        PreferenceUtilities.incrementCounter(context);
    }
}
