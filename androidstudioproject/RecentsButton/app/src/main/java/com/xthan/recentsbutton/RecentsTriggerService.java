package com.xthan.recentsbutton;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;

public class RecentsTriggerService extends AccessibilityService {

    private static RecentsTriggerService instance;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        instance = this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && "TRIGGER_RECENTS".equals(intent.getAction())) {
            performGlobalAction(GLOBAL_ACTION_RECENTS);
        }
        return START_NOT_STICKY;
    }

    public static boolean isRunning() {
        return instance != null;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // Not tracking UI changes
    }

    @Override
    public void onInterrupt() {
        // No-op
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}