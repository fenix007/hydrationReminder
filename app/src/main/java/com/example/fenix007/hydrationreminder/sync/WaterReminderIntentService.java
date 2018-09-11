package com.example.fenix007.hydrationreminder.sync;

import android.app.IntentService;
import android.content.Intent;

public class WaterReminderIntentService extends IntentService{
    public WaterReminderIntentService() {
        super("WaterReminderIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ReminderTask.executeTask(this, intent.getAction());
    }
}
