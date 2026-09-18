package com.bytedance.sdk.openadsdk.o;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;

/* JADX INFO: compiled from: SensorHub.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static SensorManager a;

    private static int a(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 2;
    }

    private static SensorManager a(Context context) {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = (SensorManager) context.getSystemService("sensor");
                }
            }
        }
        return a;
    }

    public static void b(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            SensorManager sensorManagerA = a(context);
            sensorManagerA.registerListener(sensorEventListener, sensorManagerA.getDefaultSensor(4), a(i));
        } catch (Throwable th) {
            f.a("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(300L);
    }

    public static void a(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            SensorManager sensorManagerA = a(context);
            sensorManagerA.registerListener(sensorEventListener, sensorManagerA.getDefaultSensor(1), a(i));
        } catch (Throwable th) {
            f.a("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void a(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            a(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            f.a("SensorHub", "stopListen error", th);
        }
    }
}
