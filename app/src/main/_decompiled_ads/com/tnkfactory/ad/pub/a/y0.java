package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static y0 f2896b;
    public Context a;

    public y0(Context context) {
        this.a = context.getApplicationContext();
    }

    public static y0 a(Context context) {
        if (f2896b == null) {
            f2896b = new y0(context);
        }
        return f2896b;
    }

    public final int a() {
        return b(this.a).getInt("__tnk_0001_", -1);
    }

    public final void a(int i) {
        SharedPreferences.Editor editorEdit = b(this.a).edit();
        editorEdit.putInt("__tnk_0001_", i);
        editorEdit.apply();
        com.tnkfactory.ad.pub.b.f fVar = com.tnkfactory.ad.pub.b.f.x;
        if (fVar != null) {
            fVar.q = i;
        }
    }

    public final void a(String str) {
        SharedPreferences.Editor editorEdit = b(this.a).edit();
        editorEdit.putLong("__tnk_0004_" + str, System.currentTimeMillis());
        editorEdit.apply();
    }

    public final void a(String str, int i) {
        SharedPreferences.Editor editorEdit = b(this.a).edit();
        editorEdit.putInt("__tnk_0008_" + str, i);
        editorEdit.apply();
    }

    public final void a(String str, long j) {
        SharedPreferences.Editor editorEdit = b(this.a).edit();
        editorEdit.putLong("__tnk_0006_" + str, j);
        editorEdit.apply();
    }

    public final int b() {
        return b(this.a).getInt("__tnk_0002_", -1);
    }

    public final SharedPreferences b(Context context) {
        return context.getSharedPreferences("__tnk_pub__", 0);
    }

    public final void b(int i) {
        SharedPreferences.Editor editorEdit = b(this.a).edit();
        editorEdit.putInt("__tnk_0002_", i);
        editorEdit.apply();
        com.tnkfactory.ad.pub.b.f fVar = com.tnkfactory.ad.pub.b.f.x;
        if (fVar != null) {
            fVar.r = i;
        }
    }

    public final String c() {
        return b(this.a).getString("__tnk_202301_", "").replaceAll("-", "").trim();
    }

    public final void d() {
        SharedPreferences.Editor editorEdit = b(this.a).edit();
        editorEdit.putLong("__tnk_0007_", System.currentTimeMillis());
        editorEdit.apply();
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = b(this.a).edit();
        editorEdit.putString("__tnk_202301_", str);
        editorEdit.apply();
        com.tnkfactory.ad.pub.b.f fVar = com.tnkfactory.ad.pub.b.f.x;
        if (fVar != null) {
            fVar.a = str;
        }
    }
}
