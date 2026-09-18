package com.igaworks.adpopcorn.cores.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static double a = 1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static double f1609b = 1.0d;
    private static double c;
    private static double d;
    private static int e;
    private static int f;

    public static int a(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static int a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static void a() {
        c = 0.0d;
        d = 0.0d;
    }

    public static void a(Activity activity) {
        int height;
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            e = point.x;
            height = point.y;
        } else {
            e = defaultDisplay.getWidth();
            height = defaultDisplay.getHeight();
        }
        f = height;
        Configuration configuration = activity.getResources().getConfiguration();
        if (configuration == null || configuration.orientation != 1) {
            a = ((double) e) / 1280.0d;
            f1609b = ((double) f) / 720.0d;
        } else {
            a = ((double) e) / 720.0d;
            f1609b = ((double) f) / 1280.0d;
        }
    }

    public static void a(Activity activity, int i) {
        int height;
        double d2;
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            e = point.x;
            height = point.y;
        } else {
            e = defaultDisplay.getWidth();
            height = defaultDisplay.getHeight();
        }
        f = height;
        Configuration configuration = activity.getResources().getConfiguration();
        if (configuration == null || configuration.orientation != 1) {
            c = ((double) i) / 1280.0d;
            d2 = ((double) f) / 720.0d;
        } else {
            c = ((double) i) / 720.0d;
            d2 = ((double) f) / 1280.0d;
        }
        d = d2;
    }

    public static int b() {
        return f;
    }

    public static int c() {
        return e;
    }

    public static double d() {
        double d2 = d;
        return d2 == 0.0d ? f1609b : d2;
    }

    public static double e() {
        double d2 = c;
        return d2 == 0.0d ? a : d2;
    }
}
