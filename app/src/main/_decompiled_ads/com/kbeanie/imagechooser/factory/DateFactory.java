package com.kbeanie.imagechooser.factory;

import android.util.Log;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class DateFactory {
    static String TAG = "DateFactory";
    private static DateFactory instance;
    private Long timeInMillis;

    private DateFactory() {
    }

    public long getTimeInMillis() {
        if (this.timeInMillis != null) {
            Log.d(TAG, "Time set. Is: " + this.timeInMillis);
            return this.timeInMillis.longValue();
        }
        return Calendar.getInstance().getTimeInMillis();
    }

    public void setTimeInMillis(long j) {
        Log.d(TAG, "Setting time. Is: " + j);
        this.timeInMillis = Long.valueOf(j);
    }

    public void reset() {
        Log.d(TAG, "We reset time");
        this.timeInMillis = null;
    }

    public static DateFactory getInstance() {
        if (instance == null) {
            instance = new DateFactory();
        }
        return instance;
    }
}
