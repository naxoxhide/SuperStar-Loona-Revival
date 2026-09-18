package com.bytedance.sdk.openadsdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: compiled from: BatteryDataWatcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    static int a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static float f828b;
    private static long c;

    /* JADX INFO: compiled from: BatteryDataWatcher.java */
    public static class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f829b;

        public a(int i, float f) {
            this.a = i;
            this.f829b = f;
        }
    }

    private static void a(Intent intent) {
        if (intent.getIntExtra("status", -1) == 2) {
            a = 1;
        } else {
            a = 0;
        }
        f828b = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
        com.bytedance.sdk.component.utils.m.a("BatteryDataWatcher", "updateFromIntent: status=" + a + ", level=" + f828b);
    }

    public static a a() {
        if (c == 0 || SystemClock.elapsedRealtime() - c > 60000) {
            Intent intentRegisterReceiver = com.bytedance.sdk.openadsdk.core.o.a().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            Log.d("BatteryDataWatcher", "obtainCurrentState: registerReceiver result is " + intentRegisterReceiver);
            if (intentRegisterReceiver != null) {
                a(intentRegisterReceiver);
                c = SystemClock.elapsedRealtime();
            }
        }
        a aVar = new a(a, f828b);
        com.bytedance.sdk.component.utils.m.a("BatteryDataWatcher", "obtainCurrentState: " + aVar.a + ", " + aVar.f829b);
        return aVar;
    }
}
