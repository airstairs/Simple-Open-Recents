package com.xthan.recentsbutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (RecentsTriggerService.isRunning()) {
            Intent triggerIntent = new Intent(this, RecentsTriggerService.class);
            triggerIntent.setAction("TRIGGER_RECENTS");
            startService(triggerIntent);
        } else {
            Toast.makeText(this, "Please enable the Accessibility Service first!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
        }

        finish();
    }
}