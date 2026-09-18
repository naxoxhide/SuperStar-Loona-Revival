package com.tapjoy;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes4.dex */
public class TapjoyDisplayMetricsUtil {
    public final Configuration a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f2712b;

    public TapjoyDisplayMetricsUtil(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f2712b = displayMetrics;
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.a = context.getResources().getConfiguration();
    }

    public int getScreenDensityDPI() {
        return this.f2712b.densityDpi;
    }

    public float getScreenDensityScale() {
        return this.f2712b.density;
    }

    public int getScreenLayoutSize() {
        return this.a.screenLayout & 15;
    }
}
