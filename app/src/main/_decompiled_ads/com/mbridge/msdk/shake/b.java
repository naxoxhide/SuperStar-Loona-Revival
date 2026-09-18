package com.mbridge.msdk.shake;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* JADX INFO: compiled from: ShakeSensorEventListener.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements SensorEventListener {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2418b;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public long g = 0;

    public abstract void a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public b(int i, int i2) {
        this.a = 0;
        this.f2418b = 0;
        this.a = i;
        this.f2418b = i2;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0048  */
    /* JADX WARN: Code duplicated, block: B:16:0x0057  */
    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f = -fArr[0];
        float f2 = -fArr[1];
        float f3 = -fArr[2];
        float f4 = this.d;
        if (f4 == 0.0f || Math.abs(f - f4) <= this.a) {
            float f5 = this.e;
            if (f5 == 0.0f || Math.abs(f2 - f5) <= this.a) {
                float f6 = this.f;
                if (f6 != 0.0f && Math.abs(f3 - f6) > this.a) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.g > this.f2418b) {
                        this.g = jCurrentTimeMillis;
                        a();
                    }
                }
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.g > this.f2418b) {
                    this.g = jCurrentTimeMillis;
                    a();
                }
            }
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.g > this.f2418b) {
                this.g = jCurrentTimeMillis;
                a();
            }
        }
        this.d = f;
        this.e = f2;
        this.f = f3;
    }
}
