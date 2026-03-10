package com.example.a411

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
            val enabled = prefs.getBoolean("alarm_enabled", false)
            if (enabled) {
                AlarmScheduler.schedule(context)
            }
        }
    }
}