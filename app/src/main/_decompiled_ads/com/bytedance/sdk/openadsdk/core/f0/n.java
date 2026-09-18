package com.bytedance.sdk.openadsdk.core.f0;

import android.text.TextUtils;

/* JADX INFO: compiled from: Image.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f584b;
    private int c;
    private double d;
    private boolean e;
    private String f;

    public void a(int i) {
        this.c = i;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.f584b;
    }

    public boolean f() {
        return this.e;
    }

    public boolean g() {
        return !TextUtils.isEmpty(this.a) && this.f584b > 0 && this.c > 0;
    }

    public double a() {
        return this.d;
    }

    public void b(int i) {
        this.f584b = i;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public int b() {
        return this.c;
    }

    public void a(String str) {
        this.f = str;
    }
}
