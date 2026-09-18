package com.applovin.impl.sdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class k implements SensorEventListener, AppLovinBroadcastManager.Receiver {
    private final Sensor aVG;
    private final a aVH;
    private float aVI;
    private final SensorManager afT;
    private final com.applovin.impl.sdk.n sdk;

    public interface a {
        void tA();

        void tz();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public k(com.applovin.impl.sdk.n nVar, a aVar) {
        this.sdk = nVar;
        SensorManager sensorManager = (SensorManager) com.applovin.impl.sdk.n.getApplicationContext().getSystemService("sensor");
        this.afT = sensorManager;
        this.aVG = sensorManager.getDefaultSensor(1);
        this.aVH = aVar;
    }

    public void Lk() {
        this.afT.unregisterListener(this);
        this.afT.registerListener(this, this.aVG, (int) TimeUnit.MILLISECONDS.toMicros(50L));
        AppLovinBroadcastManager.unregisterReceiver(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public void Ll() {
        AppLovinBroadcastManager.unregisterReceiver(this);
        this.afT.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float fMax = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f = this.aVI;
            float f2 = (f * 0.5f) + (fMax * 0.5f);
            this.aVI = f2;
            if (f < 0.8f && f2 > 0.8f) {
                this.aVH.tA();
            } else {
                if (f <= -0.8f || f2 >= -0.8f) {
                    return;
                }
                this.aVH.tz();
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.afT.unregisterListener(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            Lk();
        }
    }
}
