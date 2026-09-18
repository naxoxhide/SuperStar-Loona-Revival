package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.AdListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class r {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdListener f2886b = null;
    public Map<String, Object> c = new HashMap();
    public int d = 0;
    public com.tnkfactory.ad.pub.a e = null;

    public r(String str) {
        this.a = str;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    public final Object a(String str) {
        return this.c.get(str);
    }

    public void a() {
    }

    public void a(View view) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(ViewGroup viewGroup, j1 j1Var) {
    }

    public final void a(AdItem adItem) {
        AdListener adListener = this.f2886b;
        if (adListener != null) {
            adListener.onClick(adItem);
        }
    }

    public final void a(AdItem adItem, AdError adError) {
        AdListener adListener = this.f2886b;
        if (adListener != null) {
            adListener.onError(adItem, adError);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Object>] */
    public final void a(String str, Object obj) {
        this.c.put(str, obj);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0076 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:9:0x0074 A[RETURN, SYNTHETIC] */
    public final boolean a(Context context) {
        y0 y0VarA = y0.a(context);
        String str = this.a;
        long j = y0VarA.b(y0VarA.a).getLong("__tnk_0004_" + str, 0L);
        long j2 = y0VarA.b(y0VarA.a).getLong("__tnk_0006_" + str, 10L);
        if (j2 >= 0) {
            if (System.currentTimeMillis() - j > j2 * 1000) {
                return true;
            }
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        if (simpleDateFormat.format(new Date()).equals(simpleDateFormat.format(new Date(j)))) {
            return false;
        }
        return true;
    }

    public int[] a(int i, int i2) {
        return new int[]{-1, -1};
    }

    public View b(Context context) {
        return null;
    }

    public void b() {
    }

    public void b(AdItem adItem) {
        AdListener adListener = this.f2886b;
        if (adListener != null) {
            adListener.onLoad(adItem);
        }
    }

    public final String c() {
        if (this.e != null) {
            return this.e.c + "_" + this.e.g;
        }
        return null;
    }

    public void c(Context context) {
        throw null;
    }

    public final void c(AdItem adItem) {
        AdListener adListener = this.f2886b;
        if (adListener != null) {
            adListener.onShow(adItem);
        }
    }

    public void d(Context context) {
    }

    public final boolean d() {
        String str = this.a;
        return str != null && str.length() > 0;
    }

    public void e(Context context) {
    }

    public final boolean e() {
        return this.d == 0;
    }

    public final boolean f() {
        com.tnkfactory.ad.pub.a aVar;
        return !g() || (aVar = this.e) == null || System.currentTimeMillis() - aVar.Y < aVar.i * 1000;
    }

    public final boolean g() {
        return this.d == 2;
    }

    public void h() {
    }

    public void i() {
    }
}
